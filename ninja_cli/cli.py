from typing import Optional, Annotated

import typer

from .commands import mkm
from . import __app_name__, __version__, ERRORS
from .utils import config

app = typer.Typer()
app.add_typer(mkm.app, name="mkm", help="Utility to manage mkm account")


def _version_callback(value: bool) -> None:
    if value:
        typer.echo(f"{__app_name__} v{__version__}")
        raise typer.Exit()


@app.command(help="Create the configuration file.")
def init() -> None:
    app_init_error = config.init_app()
    if app_init_error:
        typer.secho(
            message=f'Creating config file failed with "{ERRORS[app_init_error]}"',
            fg=typer.colors.RED
        )
        raise typer.Exit(1)
    else:
        typer.secho(f"Configuration file created.", fg=typer.colors.GREEN)


@app.callback()
def main(
    version: Annotated[Optional[bool],
                       typer.Option("--version", "-v", callback=_version_callback)] = None):
    return
