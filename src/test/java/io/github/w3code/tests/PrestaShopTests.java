package io.github.w3code.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.github.w3code.helpers.ShopLogin.loginShopViaApi;

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
}
