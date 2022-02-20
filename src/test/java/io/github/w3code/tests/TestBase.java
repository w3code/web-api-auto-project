package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.config.ShopConfig;
import io.github.w3code.helpers.Attach;
import io.github.w3code.pages.IdentityPage;
import io.github.w3code.pages.MyAccountPage;
import io.github.w3code.pages.SignInPage;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    public static ShopConfig shop = ConfigFactory.create(ShopConfig.class, System.getProperties());
    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    IdentityPage identityPage = new IdentityPage();

    @BeforeAll
    static void startMaximized() {
        RestAssured.baseURI = shop.shopUrl();
        Configuration.baseUrl = shop.shopUrl();
        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
