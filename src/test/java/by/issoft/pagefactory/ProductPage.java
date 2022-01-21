package by.issoft.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "wishlist_button")
    private WebElement addWishlistButton;

    @FindBy(css = ".fancybox-item")
    private WebElement addedConfirmationPopUpCloseButton;

    @FindBy(xpath = "//*[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(className = "cross")
    private WebElement closeConfirmationPopUpButton;


    public ProductPage addProductToWishlist() {
        addWishlistButton.click();
        addedConfirmationPopUpCloseButton.click();
        return this;
    }

    public ProductPage addProductToCart() {
        addToCartButton.click();
        closeConfirmationPopUpButton.click();
        return this;
    }

    public ProductPage openProductPage(String productName) {
        String productXpath = "//*[@id = 'center_column']//a[contains(text(), '" + productName + "')]";
        driver.findElement(By.xpath(productXpath)).click();
        return this;
    }

}
