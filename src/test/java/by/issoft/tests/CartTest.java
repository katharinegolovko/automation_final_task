package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import by.issoft.pagefactory.ProductPage;
import by.issoft.pagefactory.SearchPage;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CartTest extends TestBase {

    String firstProduct = "Faded Short Sleeve T-shirts",
            secondProduct = "Blouse",
            thirdProduct = "Printed Chiffon Dress";

    @Test
    @Step("User can successfully add 3 products to cart")
    @Description("User can successfully add 3 products to cart")
    void userShouldBeAbleToAddProductsToCart() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToLogin(credentials.username())
                .enterPassword(credentials.password())
                .clickSignInButton();
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        searchPage.searchProduct(firstProduct);
        productPage.openProductPage(firstProduct)
                .addProductToCart();
        searchPage.clearSearchInput()
                .searchProduct(secondProduct);
        productPage.openProductPage(secondProduct)
                .addProductToCart();
        searchPage.clearSearchInput()
                .searchProduct(thirdProduct);
        productPage.openProductPage(thirdProduct)
                .addProductToCart();
        Assertions.assertEquals("$61.91", driver.findElement(By.id("total_price")).getText());
    }
}
