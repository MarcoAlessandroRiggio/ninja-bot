import requests
from ..utils import config

HEADERS = {
    'Cookie': '__cf_bm=dE2487qlsQamqxwSg9MtwoSb26XjtOw3XEFZ8W.kzNY-1722182410-1.0.1.1-5ym6.fjQ1DkuMQ2I9.XxZJBubJfKuW95l_J0SN8aULdn1CPD.Ve56x4y7pIaEyILakp..D4t_A1QaJ1AEXnYfg; _cfuvid=NnBmg4fTW.pwZ1_WKKiC7VlZRe2Domm5AwBv8xPRhkE-1722182410833-0.0.1.1-604800000; PHPSESSID=9t90befo1k30s9vso4tko6i8ic',
    "User-Agent": "ninja-cli",
    "Content-Type": "application/x-www-form-urlencoded",
    "Origin": "https://www.cardmarket.com",
    "DNT": "1",
    "Upgrade-Insecure-Requests": "1",
    "Sec-Fetch-Dest": "document",
    "Sec-Fetch-Mode": "navigate",
    "Sec-Fetch-Site": "same-origin",
    "Sec-Fetch-User": "1",
    "Priority": "u=0, i",
    "Pragma": "no-cache",
    "Cache-Control": "no-cache",
    "TE": "trailers"
}

_URL = "https://www.cardmarket.com"


class Mkm:
    def __init__(self):
        self._authenticate()

    def _authenticate(self):
        mkm_configuration = config.get_config()["mkm"]
        response = requests.post(url=f"{_URL}/PostGetAction/User_Login",
                                 headers=HEADERS,
                                 data={
                                     "username": mkm_configuration["username"],
                                     "userPassword": mkm_configuration["password"]
                                 })
        print(response.status_code)
