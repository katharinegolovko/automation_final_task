package by.issoft.utils.factory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridFactory extends WebDriverFactory {


    private WebDriver driver;

    @Override
    public WebDriver initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);
        return driver = new RemoteWebDriver(new URL(
                "http://192.168.100.30:4444/"), capabilities);
    }
}
