import configparser
from pathlib import Path
from typing import Any
from ninja_cli import (
    DB_WRITE_ERROR, DIR_ERROR, FILE_ERROR, SUCCESS, __app_name__
)

CONFIG_DIR_PATH = Path.home() / f".{__app_name__}"
CONFIG_FILE_PATH = CONFIG_DIR_PATH / "config.ini"
DEFAULT_CONFIG = {}


def init_app() -> int:
    return _init_config_file()


def _init_config_file() -> int:
    try:
        CONFIG_DIR_PATH.mkdir(exist_ok=True)
    except OSError:
        return DIR_ERROR
    try:
        CONFIG_FILE_PATH.touch(exist_ok=True)
    except OSError:
        return FILE_ERROR
    for key, value in DEFAULT_CONFIG.items():
        save_entry(key=key, value=value)
    return SUCCESS


def save_entry(key: str, value: Any) -> int:
    config_parser = configparser.ConfigParser()
    config_parser[key] = value
    try:
        with CONFIG_FILE_PATH.open("w") as file:
            config_parser.write(file)
    except OSError:
        return DB_WRITE_ERROR
    return SUCCESS


def get_config():
    config_parser = configparser.ConfigParser()
    if config_parser.read(CONFIG_FILE_PATH):
        return config_parser
    else:
        return FILE_ERROR
