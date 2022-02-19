package io.github.w3code.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PrestaShopTests extends TestBase {

    @Test
    @DisplayName("UI login test")
    @Tag("UILoginTest")
    void uILoginTest() {
        signInPage
                .openPage()
                .verifySignInPage()
                .typeEmail(shop.user())
                .typePassword(shop.password())
                .clickSignIn();

        myAccountPage.verifyMyAccountPage();
    }
}
