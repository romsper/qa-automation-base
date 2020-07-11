import os

from selene.support.shared import browser
from selenium import webdriver


class InitDriver:

    def init_driver(self):
        hub = os.getenv("HUB") is not None or "localhost"

        chrome_options = webdriver.ChromeOptions()
        chrome_capabilities = {
            "browserName": "chrome",
            "version": "83.0",
            "enableVNC": True,
            "enableVideo": False
        }

        remote_webdriver = webdriver.Remote(
            options=chrome_options,
            command_executor="http://" + hub + ":4444/wd/hub",
            desired_capabilities=chrome_capabilities)
        remote_webdriver.maximize_window()

        browser.driver = remote_webdriver
        browser.base_url = "https://google.com"
        browser.timeout = 10
