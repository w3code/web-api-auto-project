package io.github.w3code.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {

    //locators and elements
    private final String PAGE_TITLE = "My account";

    private final SelenideElement
            pageTitle = $(".page-heading");

    //actions
    @Step("Verify My account page")
    public MyAccountPage verifyMyAccountPage() {
        pageTitle.shouldHave(text(PAGE_TITLE));
        return this;
    }
}
