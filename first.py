import pytest
import allure


@allure.feature("Example")
class TestClass():

    @pytest.mark.first
    def test_first(self):
        a = 3
        b = 2
        assert (a + b) == 5

    @pytest.mark.second
    def test_second(self):
        a = 3
        b = 7
        assert (a + b) == 10
