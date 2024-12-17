package registration.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    String Url = "https://automationexercise.com/signup";
    //////////Locators//////////
    private By genderCheckbox = By.id("id_gender2");
    private By passwordField = By.xpath("//input[@id='password']");
    private By Day = By.id("days");
    private By Month = By.id("months");
    private By Year = By.id("years");
    private By NewsLetterCheckbox = By.id("newsletter");
    private By SpecialOffersCheckbox = By.id("optin");
    private By FirstNameField = By.id("first_name");
    private By LastNameField = By.id("last_name");
    private By CompanyField = By.id("company");
    private By AddressField1 = By.id("address1");
    private By AddressField2 = By.id("address2");
    private By CountryField = By.id("country");
    private By StateField = By.id("state");
    private By CityField = By.id("city");
    private By ZipCodeField = By.id("zipcode");
    private By MobileNumberField = By.id("mobile_number");
    private By CreateAccountButton = By.xpath("//button[@data-qa='create-account']");
    ///////////Action Methods///////////
    public void navigateToSignupPage(){
        driver.get(Url);
    }
    @Step("Entering the Account Information Section")
    //function to enter Account information section
    public SignupPage enterAccountInformation(String password, String day, String month, String year) {
        driver.findElement(genderCheckbox).click();
        driver.findElement(passwordField).sendKeys(password);
        new Select(driver.findElement(Day)).selectByVisibleText(day);
        new Select(driver.findElement(Month)).selectByVisibleText(month);
        new Select(driver.findElement(Year)).selectByVisibleText(year);
        driver.findElement(NewsLetterCheckbox).click();
        driver.findElement(SpecialOffersCheckbox).click();
        return this;

    }
    @Step("Entering Address Information section")
    //function to enter address information section
    public SignupPage enterAddressInformation(String firstName, String lastName, String companyName, String address1, String address2, String country, String state, String city, String zipCode, String number) {
        driver.findElement(FirstNameField).sendKeys(firstName);
        driver.findElement(LastNameField).sendKeys(lastName);
        driver.findElement(CompanyField).sendKeys(companyName);
        driver.findElement(AddressField1).sendKeys(address1);
        driver.findElement(AddressField2).sendKeys(address2);
        new Select(driver.findElement(CountryField)).selectByVisibleText(country);
        driver.findElement(StateField).sendKeys(state);
        driver.findElement(CityField).sendKeys(city);
        driver.findElement(ZipCodeField).sendKeys(zipCode);
        driver.findElement(MobileNumberField).sendKeys(number);
        return this;
    }
    @Step("Clicking on Create Account Button")
    public void clickOnCreateAccountButton() {
        driver.findElement(CreateAccountButton).click();
    }
}
