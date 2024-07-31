import { RemovalPolicy, Stack, StackProps } from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as dynamodb from 'aws-cdk-lib/aws-dynamodb'
import * as apigateway from 'aws-cdk-lib/aws-apigateway'
import * as lambda from 'aws-cdk-lib/aws-lambda'
import * as secretsmanager from 'aws-cdk-lib/aws-secretsmanager';

export class NinjaBotStack extends Stack {
  LAYERS_ARN = [
    "arn:aws:lambda:eu-central-1:017000801446:layer:AWSLambdaPowertoolsPythonV2:17",
    "arn:aws:lambda:eu-central-1:770693421928:layer:Klayers-p311-requests:9"
  ]
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const secret = new secretsmanager.Secret(this, 'TelegramSecret');

    const dynamodb_table = new dynamodb.Table(this, "Collections", {
        partitionKey: { name: "id", type: dynamodb.AttributeType.STRING },
        removalPolicy: RemovalPolicy.DESTROY
      }
    )

    const layers = this.LAYERS_ARN
      .map((arn, index) => lambda.LayerVersion.fromLayerVersionArn(this, 'Layer' + index, arn))


    const lambda_backend = new lambda.Function(this, "NinjaBot", {
      runtime: lambda.Runtime.PYTHON_3_11,
      handler: "app.lambda_handler",
      code: lambda.Code.fromAsset("src"),
      tracing: lambda.Tracing.ACTIVE,
      layers: layers,
      environment: {
        DYNAMODB: dynamodb_table.tableName,
        TELEGRAM_SECRET: secret.secretName
      },
    })

    secret.grantRead(lambda_backend.role!)
    dynamodb_table.grantReadData(lambda_backend.role!)

    const api = new apigateway.RestApi(this, "RestAPI", {
      deployOptions: {
        dataTraceEnabled: true,
        tracingEnabled: true
      },
    })
    const endpoint = api.root.addResource("ninja-bot")
    const endpointMethod = endpoint.addMethod("POST", new apigateway.LambdaIntegration(lambda_backend))

  }
}
