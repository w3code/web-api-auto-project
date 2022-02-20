package io.github.w3code.helpers;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.github.w3code.api.AuthorizationAPI.getAuthorizationCookie;

public class ShopLogin {
    public static void loginShopViaAPI(String user, String password) {
        String authorizationCookie = getAuthorizationCookie(user, password);

        open("/img/logo.jpg");

        getWebDriver().manage().addCookie(
                new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364", authorizationCookie));
    }
}
