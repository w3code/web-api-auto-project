package io.github.w3code.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.github.w3code.api.AuthorizationAPI.getAuthorizationCookie;
import static io.restassured.RestAssured.given;

public class PrestaShopTests extends TestBase {

    @Test
    @DisplayName("UI login test")
    @Tag("UILoginTest")
    @Disabled
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
        String authorizationCookie = getAuthorizationCookie(shop.user(), shop.password());

        open("/img/logo.jpg");

        getWebDriver().manage().addCookie(
                new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364", authorizationCookie));

        myAccountPage
                .openPage()
                .verifyMyAccountPage();
    }
}
