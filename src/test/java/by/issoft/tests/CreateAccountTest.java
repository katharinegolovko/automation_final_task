package by.issoft.tests;

import by.issoft.pagefactory.AccountCreationPage;
import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateAccountTest extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName();

    @Test
    @Step("User can successfully create new account")
    @Description("User can successfully create new account by providing all required fields")
    void userShouldBeAbleToCreateNewAccount() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToCreateAccount(faker.internet().emailAddress())
                .clickCreateAccountButton();
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.createAccount(
                        firstName,
                        lastName,
                        "TestPass1!",
                        faker.address().fullAddress(),
                        faker.address().city(),
                        faker.numerify("#####"),
                        faker.numerify("##########"))
                .selectState("Florida")
                .clickRegisterButton();
        Assertions.assertTrue(accountCreationPage.checkMyAccountPageOpened());
        Assertions.assertEquals(firstName + " " + lastName, driver.findElement(By.className("account")).getText());
    }
}
