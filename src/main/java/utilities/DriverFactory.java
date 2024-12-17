package utilities;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {
    static WebDriver driver;

    @Step("Initializing new driver (Browser Type: {browserName} | Headless Execution: {headless})")
    public static WebDriver initializingDriver(String browserName, Boolean maximize, Boolean headless) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions;
            if (Boolean.TRUE.equals(headless)) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions ffOptions;
            if (Boolean.TRUE.equals(headless)) {
                ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--headless");
                driver = new FirefoxDriver(ffOptions);
            } else {
                driver = new FirefoxDriver();
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions;
            if (Boolean.TRUE.equals(headless)) {
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                driver = new EdgeDriver(edgeOptions);
            } else {
                driver = new EdgeDriver();
            }
        } else {
            driver = new SafariDriver();
        }
        if (Boolean.TRUE.equals(maximize)) {
            driver.manage().window().maximize();
        }
        return driver;
    }

}