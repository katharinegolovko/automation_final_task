package by.issoft.tests;

import by.issoft.pagefactory.CartPage;
import by.issoft.pagefactory.LoginPage;
import by.issoft.pagefactory.ProductPage;
import by.issoft.pagefactory.SearchPage;
import by.issoft.utils.MyTestWatcher;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class CartTest extends TestBase {

    String firstProduct = "Faded Short Sleeve T-shirts",
            secondProduct = "Blouse",
            thirdProduct = "Printed Chiffon Dress";

    @Test
    @Step("User can successfully add 3 products to cart")
    @Description("User can successfully add 3 products to cart")
    void userShouldBeAbleToAddProductsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
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
        CartPage cartPage = new CartPage(driver);
        cartPage.viewCart()
                .checkTotalValue("$61.91");
    }
}
