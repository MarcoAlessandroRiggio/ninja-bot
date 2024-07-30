import { RemovalPolicy, Stack, StackProps } from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as dynamodb from 'aws-cdk-lib/aws-dynamodb'
import * as apigateway from 'aws-cdk-lib/aws-apigateway'
import * as lambda from 'aws-cdk-lib/aws-lambda'

export class NinjaBotStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const dynamodb_table = new dynamodb.Table(this, "Collections", {
      partitionKey: { name: "id", type: dynamodb.AttributeType.STRING },
      removalPolicy: RemovalPolicy.DESTROY
      }
    )

    const lambda_backend = new lambda.Function(this, "NinjaBot", {
      runtime: lambda.Runtime.PYTHON_3_12,
      handler: "app.lambda_handler",
      code: lambda.Code.fromAsset("src"),
      tracing: lambda.Tracing.ACTIVE,
      environment: {
        DYNAMODB: dynamodb_table.tableName
      },
    })

    dynamodb_table.grantReadData(lambda_backend.role!)

    const api = new apigateway.RestApi(this, "RestAPI", {
      deployOptions: {
        dataTraceEnabled: true,
        tracingEnabled: true
      },
    })


    const endpoint = api.root.addResource("scan")
    const endpointMethod = endpoint.addMethod("POST", new apigateway.LambdaIntegration(lambda_backend))

  }
}
