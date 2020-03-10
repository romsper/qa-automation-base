The example contains Kotlin + Selenide/Appium + JUnit 5 + Allure + Allure EE + TestRail

`PageFactory` - Kotlin doesn't work with `Appium` annotations for both platform like: `@AndroidFindBy(id="signUpButton")` and `@XCUIFindBy(id="signUpButton")`, so use `platform` env variable and `PageFactory` for split `iOS` and `Android`. 

`Allure EE` - I got a trial version and I **HIGHLY RECOMMEND** it to use and you will forget about stupid `TestRail`!

`TestRail` - Connect test results with test cases after each run. It doesn't work if you set the `@Disable` annotation to some test. 