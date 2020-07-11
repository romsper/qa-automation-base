import time

import allure
import pytest

# Run tests by mark $ pytest -s -v -m first


@allure.feature("Feature name")
@allure.story("Story name")
@pytest.mark.simple
class TestSimple:

    @pytest.fixture(scope='function', autouse=True)
    def init_driver(self):
        print("START") # Before like in JUnit
        yield
        print("STOP") # After like in JUnit

    @pytest.mark.first
    def test_first(self):
        time.sleep(10)
        a = 3
        b = 2
        assert (a + b) == 5

    @pytest.mark.second
    def test_second(self):
        a = 3
        b = 7
        assert (a + b) == 10