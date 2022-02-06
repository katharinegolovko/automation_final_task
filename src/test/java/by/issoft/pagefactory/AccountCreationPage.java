package by.issoft.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {

    WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateField;

    @FindBy(id = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "id_country")
    private WebElement coutryDropdown;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@class='page-heading' and contains(text(), 'My account')]")
    private WebElement myAccountPageTitle;

    @FindBy(className = "account")
    private WebElement userAccountName;

    public AccountCreationPage createAccount(String firstName, String lastName, String password, String address, String city, String postalCode, String mobilePhone) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        postalCodeField.sendKeys(postalCode);
        mobilePhoneField.sendKeys(mobilePhone);
        return this;
    }

    public AccountCreationPage selectState(String state) {
        Select stateDropdown = new Select(stateField);
        stateDropdown.selectByVisibleText(state);
        return this;
    }

    public AccountCreationPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public boolean checkMyAccountPageOpened() {
        return myAccountPageTitle.isDisplayed();
    }

    public String getUserAccountName() {
        return driver.findElement(By.className("account")).getText();
    }
}