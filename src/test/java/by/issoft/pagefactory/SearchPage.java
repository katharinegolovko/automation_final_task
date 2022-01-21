package by.issoft.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    public SearchPage searchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchInput.submit();
        return this;
    }

    public SearchPage clearSearchInput() {
        searchInput.clear();
        return this;
    }

}


