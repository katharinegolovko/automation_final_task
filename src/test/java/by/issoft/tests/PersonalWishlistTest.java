package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import by.issoft.pagefactory.MyWishlistsPage;
import by.issoft.pagefactory.ProductPage;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonalWishlistTest extends TestBase {

    String personalWishlistName = "My dress wishlist",
            productName = "Printed Dress";

    @Test
    @Step("User can create his own Wishlist and add product to it")
    @Description("User can create his own Wishlist and add product to it")
    @Order(1)
    void userShouldBeAbleToCreatePersonalWishlist() {
        LoginPage loginPage = openLoginPage();
        loginPage.enterEmailToLogin(credentials.username())
                .enterPassword(credentials.password())
                .clickSignInButton();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage(driver);
        myWishlistsPage.openMyWishlistsPage();
        myWishlistsPage.createNewWishlist(personalWishlistName);
        driver.findElement(By.xpath("//a[contains(text(),'Printed Dress')]")).click();
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToWishlist();
        myWishlistsPage.openMyWishlistsPage();
        Assertions.assertTrue(myWishlistsPage.checkPersonalWishlistWasCreated(personalWishlistName));
        myWishlistsPage.clickViewWishlistLink();
        Assertions.assertTrue(myWishlistsPage.checkProductWasAddedToWishlist(productName));
    }

    @Test
    @Step("User can delete personally created Wishlist")
    @Description("User can delete personally created Wishlist")
    @Order(2)
    void userShouldBeAbleToDeletePersonallyCreatedWishlist() {
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
