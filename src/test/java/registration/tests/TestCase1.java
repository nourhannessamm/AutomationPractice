package registration.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import registration.pages.*;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;

public class TestCase1 {
    private WebDriver driver;
    private JsonFileManager jsonFileManager;
    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();
    }
    @BeforeClass
    public void DataFileParsing(){
        // as we need to do this only one time (Parsing the file only one time)
        jsonFileManager = new JsonFileManager("src\\test\\resources\\TestDataJsonFile\\TestData.json");
    }
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.initializingDriver(System.getProperty("browserName"),true,Boolean.parseBoolean(System.getProperty("headlessExecution")));
      // driver=new ChromeDriver();
      // driver.manage().window().maximize();
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("The user can register successfully")
    public void registrationScenario(){
        new HomePage(driver)
                .navigateToHomePage()
                .clickOnSignUpLoginButton();
        new SignupOrLoginPage(driver)
                 .fillingInNewUserSignUpData(jsonFileManager.getTestData("name"),jsonFileManager.getTestData("email"))
                 .clickOnSignUpButton();
        new SignupPage(driver)
                 .enterAccountInformation(jsonFileManager.getTestData("password"), jsonFileManager.getTestData("day"), jsonFileManager.getTestData("month"), jsonFileManager.getTestData("year"))
                 .enterAddressInformation(jsonFileManager.getTestData("firstName"), jsonFileManager.getTestData("lastName"), jsonFileManager.getTestData("companyName"), jsonFileManager.getTestData("address1"), jsonFileManager.getTestData("address2"), jsonFileManager.getTestData("country"), jsonFileManager.getTestData("state"), jsonFileManager.getTestData("city"), jsonFileManager.getTestData("zipCode"), jsonFileManager.getTestData("number"))
                 .clickOnCreateAccountButton();
        new AccountCreatedPage(driver)
                  .createAccountAssertions()
                  .clickOnContinueButton()
                  .clickOnDeleteButton();
        new AccountDeletedPage(driver)
                  .AssertDeleteAccount()
                  .clickOnContinueButton();

    }
    @Test
    public void registrationScenario2(){
        new HomePage(driver)
                .navigateToHomePage()
                .clickOnSignUpLoginButton();
        new SignupOrLoginPage(driver)
                .fillingInNewUserSignUpData(jsonFileManager.getTestData("name2"),jsonFileManager.getTestData("email2"))
                .clickOnSignUpButton();
        new SignupPage(driver)
                .enterAccountInformation(jsonFileManager.getTestData("password2"), jsonFileManager.getTestData("day2"), jsonFileManager.getTestData("month2"), jsonFileManager.getTestData("year2"))
                .enterAddressInformation(jsonFileManager.getTestData("firstName2"), jsonFileManager.getTestData("lastName2"), jsonFileManager.getTestData("companyName2"), jsonFileManager.getTestData("address1"), jsonFileManager.getTestData("address2"), jsonFileManager.getTestData("country"), jsonFileManager.getTestData("state"), jsonFileManager.getTestData("city"), jsonFileManager.getTestData("zipCode"), jsonFileManager.getTestData("number"))
                .clickOnCreateAccountButton();
        new AccountCreatedPage(driver)
                .createAccountAssertions()
                .clickOnContinueButton()
                .clickOnDeleteButton();
        new AccountDeletedPage(driver)
                .AssertDeleteAccount()
                .clickOnContinueButton();

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
