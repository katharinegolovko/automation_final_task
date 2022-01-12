package by.issoft.tests;

import by.issoft.pagefactory.AccountCreationPage;
import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.MyTestWatcher;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class LoginTest extends TestBase {

    @Test
    @Step("User can successfully log in")
    @Description("User can successfully log in with valid credentials")
    void userShouldBeAbleToLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin("test-qb3ueborr@srv1.mail-tester.com")
                .enterPassword("TestPass1!")
                .clickSignInButton();
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.checkMyAccountPageOpened()
                .checkUserAccountName("Test Account");
    }
}
