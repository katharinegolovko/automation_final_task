package by.issoft.pagefactory;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Cart')]")
    private WebElement viewCartButton;

    @FindBy(id = "total_price")
    private WebElement totalPriceValue;

    public CartPage viewCart() {
        viewCartButton.click();
        return this;
    }

    public CartPage checkTotalValue(String expectedTotal) {
        Assertions.assertEquals(expectedTotal, totalPriceValue.getText());
        return this;
    }


}
