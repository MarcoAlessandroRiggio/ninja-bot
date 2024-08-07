import json
import os

import requests
from aws_lambda_powertools.utilities import parameters


def lambda_handler(event, context):
    print(event)
    try:
        body = json.loads(event['body'])
        print(body)
        message_part = body['message'].get('text')
        print("Message part : {}".format(message_part))

        data = {'url': message_part}


        chat_id = body['message']['chat']['id']
        telegram_token = parameters.get_secret(os.getenv('TELEGRAM_SECRET'))
        url = f'https://api.telegram.org/bot{telegram_token}/sendMessage'

        payload = {
            'chat_id': chat_id,
            'text': 'ciao'
        }

        r = requests.post(url, json=payload)

        return {
            "statusCode": 200
        }

    except:
        return {
            "statusCode": 200
        }
