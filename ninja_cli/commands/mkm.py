import typer

from ..utils.mkm import Mkm
from ..utils import config

app = typer.Typer()


@app.command(help="Delete all listed items from your account")
def empty_all():
    Mkm()
    print(f"Deleting all items")


@app.command(help="Set the username account for the others commands")
def set_username(username: str):
    _update_configuration(key="username", value=username)


@app.command(help="Set the password account for the others commands")
def set_password(password: str):
    _update_configuration(key="password", value=password)


def _update_configuration(key: str, value: str):
    cli_configuration = config.get_config()
    mkm_configuration = cli_configuration["mkm"]
    mkm_configuration[key] = value
    config.save_entry(key="mkm", value=mkm_configuration)
    typer.secho(f"{key} updated.", fg=typer.colors.GREEN)
