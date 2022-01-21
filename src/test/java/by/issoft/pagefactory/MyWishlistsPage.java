package by.issoft.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishlistsPage {

    private static final String MYWISHLISTSPAGE = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";

    WebDriver driver;

    public MyWishlistsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "table")
    private WebElement wishlistsTable;

    @FindBy(xpath = "//td//*[contains(text(),'My wishlist')]")
    private WebElement autoCreatedWishlist;

    @FindBy(css = ".wishlist_delete .icon")
    private WebElement deleteWishlistButton;

    @FindBy(id = "name")
    private WebElement newWishlistNameField;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishlistButton;

    @FindBy(xpath = "//td//*[contains(text(),'View')]")
    private WebElement viewWishlistLink;


    public MyWishlistsPage openMyWishlistsPage() {
        driver.get(MYWISHLISTSPAGE);
        return this;
    }

    public boolean checkAutoWishlistWasCreated() {
        return autoCreatedWishlist.isDisplayed();
    }

    public MyWishlistsPage clickDeleteWishlistButton() {
        deleteWishlistButton.click();
        return this;
    }

    public MyWishlistsPage createNewWishlist(String wishlistName) {
        newWishlistNameField.sendKeys(wishlistName);
        saveWishlistButton.click();
        return this;
    }

    public MyWishlistsPage clickViewWishlistLink() {
        viewWishlistLink.click();
        return this;
    }
}
