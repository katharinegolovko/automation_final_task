package by.issoft.tests;

import by.issoft.pagefactory.AccountCreationPage;
import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTest extends TestBase {

    @Test
    @Step("User can successfully log in")
    @Description("User can successfully log in with valid credentials")
    void userShouldBeAbleToLogin() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToLogin(credentials.username())
                .enterPassword(credentials.password())
                .clickSignInButton();
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        Assertions.assertTrue(accountCreationPage.checkMyAccountPageOpened());
        Assertions.assertEquals("Test Account", accountCreationPage.getUserAccountName());
    }
}
