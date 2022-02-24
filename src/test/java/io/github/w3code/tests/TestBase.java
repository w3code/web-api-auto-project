package io.github.w3code.tests;

import com.codeborne.selenide.Configuration;
import io.github.w3code.config.ShopConfig;
import io.github.w3code.config.WebConfig;
import io.github.w3code.helpers.Attach;
import io.github.w3code.pages.*;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class TestBase {
    public static ShopConfig shop = ConfigFactory.create(ShopConfig.class, System.getProperties());
    public static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    IdentityPage identityPage = new IdentityPage();
    WomanPage womanPage = new WomanPage();
    MyWishList myWishList = new MyWishList();

    @BeforeAll
    static void startMaximized() {
        RestAssured.baseURI = shop.shopUrl();
        Configuration.baseUrl = shop.shopUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (!Objects.isNull(System.getProperty("environment")) && System.getProperty("environment").equals("selenoid")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = webConfig.remoteDriverUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        step("Close webdriver", () ->
                closeWebDriver());
    }
}
