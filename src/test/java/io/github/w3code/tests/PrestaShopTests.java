package io.github.w3code.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.github.w3code.helpers.ShopLogin.loginShopViaAPI;

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
        loginShopViaAPI(shop.user(), shop.password());

        myAccountPage
                .openPage()
                .verifyMyAccountPage();
    }
}
