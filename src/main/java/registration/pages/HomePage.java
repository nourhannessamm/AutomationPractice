package registration.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    private String Url = "https://automationexercise.com/";

    /////Action Methods////
  @Step("Navigate to Home Page")

    public MainMenu navigateToHomePage(){

       driver.get(Url);
       return new MainMenu(driver);

    }


}
