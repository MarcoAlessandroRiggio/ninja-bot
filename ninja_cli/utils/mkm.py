import requests
import http.client as http_client
import logging
from ..utils import config


_URL = "https://www.cardmarket.com"


class Mkm:
    def __init__(self):
        self._authenticate()
        pass

    def _authenticate(self):
        mkm_configuration = config.get_config()["mkm"]
        response = requests.Session().post(url=f"{_URL}/PostGetAction/User_Login", data={
            "username": mkm_configuration["username"],
            "userPassword": mkm_configuration["password"]
        })
        print(response.status_code)
        # print(response.text)
        # http_client.HTTPConnection.debuglevel = 1
        # logging.basicConfig()
        # logging.getLogger().setLevel(logging.DEBUG)
        # requests_log = logging.getLogger("requests.packages.urllib3")
        # requests_log.setLevel(logging.DEBUG)
        # requests_log.propagate = True
        # response = requests.get(url=f"{_URL}/en/Magic/Stock/Offers/Singles")
        # print(response.status_code)
        # print(response.text)
