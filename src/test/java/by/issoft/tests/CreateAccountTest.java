package by.issoft.tests;

import by.issoft.pagefactory.AccountCreationPage;
import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.MyTestWatcher;
import by.issoft.utils.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class CreateAccountTest extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            password = "TestPass1!",
            mobileNumber = faker.numerify("##########"),
            address = faker.address().fullAddress(),
            city = faker.address().city(),
            postalCode = mobileNumber = faker.numerify("#####"),
            state = "Florida";

    @Test
    @Step("User can successfully create new account")
    @Description("User can successfully create new account by providing all required fields")
    void userShouldBeAbleToCreateNewAccount() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToCreateAccount(email)
                .clickCreateAccountButton();
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPassword(password)
                .enterAddress(address)
                .enterCity(city)
                .selectState(state)
                .enterPostalCode(postalCode)
                .enterMobilePhone(mobileNumber)
                .clickRegisterButton();
        accountCreationPage.checkMyAccountPageOpened()
                .checkUserAccountName(firstName + " " + lastName);
    }
}
