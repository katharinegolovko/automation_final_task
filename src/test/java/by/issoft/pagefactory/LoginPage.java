package by.issoft.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailCreationField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement emailLoginField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public LoginPage enterEmailToCreateAccount(String email) {
        emailCreationField.sendKeys(email);
        return this;
    }

    public LoginPage clickCreateAccountButton() {
        createAccountButton.click();
        return this;
    }

    public LoginPage enterEmailToLogin(String email) {
        emailLoginField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return this;
    }
}
