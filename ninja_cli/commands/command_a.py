import typer

app = typer.Typer()


@app.command(help="Set the password account for the others commands")
def echo(message: str):
    typer.secho(f"{message}", fg=typer.colors.GREEN)
