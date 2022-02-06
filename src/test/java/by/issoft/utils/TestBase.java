package by.issoft.utils;

import by.issoft.config.CredentialsConfig;
import by.issoft.pagefactory.LoginPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@ExtendWith(MyTestWatcher.class)
public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    protected static WebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    void cleanup() {
        driver.close();
        Driver.setDriver(null);
    }

    public LoginPage openLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return loginPage;
    }
}
