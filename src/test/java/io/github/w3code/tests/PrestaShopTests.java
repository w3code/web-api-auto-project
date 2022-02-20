package io.github.w3code.tests;

import com.github.javafaker.Faker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.github.w3code.filters.CustomLogFilter.customLogFilter;
import static io.github.w3code.helpers.ShopLogin.loginShopViaApi;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class PrestaShopTests extends TestBase {

    @Test
    @DisplayName("UI login test")
    @Tag("UILoginTest")
    void uiLoginTest() {
        signInPage
                .openPage()
                .verifySignInPage()
                .typeEmail(shop.user())
                .typePassword(shop.password())
                .clickSignIn();

        myAccountPage.verifyMyAccountPage();
    }

    @Test
    @DisplayName("API login test")
    @Tag("APILoginTest")
    void apiLoginTest() {
        loginShopViaApi(shop.user(), shop.password());

        myAccountPage
                .openPage()
                .verifyMyAccountPage();
    }

    @Test
    @DisplayName("Modify profile name test")
    @Tag("ModifyProfileNameTest")
    void modifyProfileNameTest() {
        loginShopViaApi(shop.user(), shop.password());

        //Generate fake firstname and lastname
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        identityPage
                .openPage()
                .verifyIdentityPage()
                .typeFirstname(firstName)
                .typeLastName(lastName)
                .typeCurrentPassword(shop.password())
                .clickSave()
                .verifySuccessMessage()
                .verifyTitleName(firstName, lastName);
    }

    @Test
    @DisplayName("Add to cart test")
    @Tag("AddToCartTest")
    void addToCartTest() {
        womanPage
                .openPage()
                .verifyWomanPage()
                .moveToFirstCart()
                .clickAddToCart()
                .verifyProductAdded();

        //Get cookie from browser
        Cookie cookie = getWebDriver().manage().getCookieNamed("PrestaShop-a30a9934ef476d11b6cc3c983616e364");

        //Check shopping cart for added position by API
        String response =  given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/x-www-form-urlencoded")
                .cookie(String.valueOf(cookie))
                .queryParam("controller", "order")
                .when()
                .post("/index.php")
                .then()
                .extract().response().asString();

        //Parse response as HTML
        Document getHTML = Jsoup.parse(response);

        //Get cart quantity
        String cartQuantity = getHTML.getElementById("summary_products_quantity").ownText();

        assertThat(cartQuantity.startsWith("1"));
    }
}
