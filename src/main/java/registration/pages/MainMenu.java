package registration.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class MainMenu {
    private WebDriver driver;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }
    ///// Locators /////
    private By SignUporLoginButton = By.partialLinkText("Signup");
    private By deletebutton = By.xpath("//a[@href='/delete_account']");
    /// /Action Methods/////
    @Step("Clicking on Signup or Login Button from Main Menu")
    public void clickOnSignUpLoginButton() {
        //locate the sign-up link then perform action "clicking" on it
        //driver.findElement(SignUporLoginButton).click();
        ElementActions.click(driver,SignUporLoginButton);
    }
    @Step("Clicking on Delete button from Main Menu")
    public void clickOnDeleteButton(){
        driver.findElement(deletebutton).click();

    }
}
