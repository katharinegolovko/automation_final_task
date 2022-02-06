package by.issoft.utils.factory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsFactory extends WebDriverFactory {

    private RemoteWebDriver driver;

    @Override
    public WebDriver initializeDriver() throws MalformedURLException {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("oauth-katyagolovkowork-34863"));
        sauceOptions.setCapability("access_key", System.getenv("abacb6cc-0103-4d51-823a-505b1a769f12"));
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://" + "oauth-katyagolovkowork-34863" + ":" + "abacb6cc-0103-4d51-823a-505b1a769f12" + "@ondemand.saucelabs.com:443/wd/hub");

        return driver = new RemoteWebDriver(url, options);
    }
}
