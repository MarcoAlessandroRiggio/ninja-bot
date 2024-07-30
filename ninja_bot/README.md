to retrieve the bot's access token ask to Bot Godfather:
/mybots

To set the bot's webhooks:
curl --location \
     --request POST \
     'https://api.telegram.org/bot{BOT_ACCESS_TOKEN}/setWebhook?url={API_GATEWAY_URL_AND_METHOD}'