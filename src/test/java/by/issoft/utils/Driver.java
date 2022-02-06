package by.issoft.utils;

import by.issoft.utils.factory.SauceLabsFactory;
import by.issoft.utils.factory.SeleniumGridFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            String runParameter = System.getProperty("driver.type");
            String browserParameter = System.getProperty("browser.type");
            switch (runParameter) {
                case "locally":
                    switch (browserParameter) {
                        case "chrome":
                            return driver = new ChromeDriver();
                        case "firefox":
                            return driver = new FirefoxDriver();
                    }
                case "seleniumgrid":
                    SeleniumGridFactory seleniumGridFactory = new SeleniumGridFactory();
                    seleniumGridFactory.initializeDriver();
                case "saucelabs":
                    SauceLabsFactory sauceLabsFactory = new SauceLabsFactory();
                    return driver = sauceLabsFactory.initializeDriver();
            }
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}
