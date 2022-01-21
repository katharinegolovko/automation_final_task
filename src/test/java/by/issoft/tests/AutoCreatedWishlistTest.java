package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import by.issoft.pagefactory.MyWishlistsPage;
import by.issoft.pagefactory.ProductPage;
import by.issoft.pagefactory.SearchPage;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;


@TestMethodOrder(OrderAnnotation.class)
public class AutoCreatedWishlistTest extends TestBase {


    @Test
    @Step("User can add product to auto-created Wishlist")
    @Description("Auto wishlist is successfully created, when User adds product for the first time")
    @Order(1)
    void userShouldBeAbleToAddProductToAutoCreatedWishlist() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToLogin(credentials.username())
                .enterPassword(credentials.password())
                .clickSignInButton();
        driver.findElement(By.className("lnk_wishlist")).click();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        searchPage.searchProduct("Faded Short Sleeve T-shirts");
        productPage.openProductPage("Faded Short Sleeve T-shirts")
                .addProductToWishlist();
        myWishlistsPage.openMyWishlistsPage()
                .checkAutoWishlistWasCreated();
        Assertions.assertTrue(myWishlistsPage.checkAutoWishlistWasCreated());
        Assertions.assertTrue(driver.findElement(By.className("product_infos")).isDisplayed());
    }

    @Test
    @Step("User can delete auto-created Wishlist")
    @Description("Auto wishlist can be successfully deleted by User")
    @Order(2)
    void userShouldBeAbleToDeleteAutoCreatedWishlist() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToLogin(credentials.username())
                .enterPassword(credentials.password())
                .clickSignInButton();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage(driver);
        myWishlistsPage.openMyWishlistsPage()
                .clickDeleteWishlistButton();
        driver.switchTo().alert().accept();
    }
}
