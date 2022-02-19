package io.github.w3code.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.github.w3code.tests.TestBase.shop;

public class SignInPage {

    //locators and elements
    private final String PAGE_TITLE = "Authentication";

    private final SelenideElement
            pageTitle = $(".page-heading"),
            emailField = $("#email"),
            passwordField = $("#passwd"),
            signInButton = $("#SubmitLogin");

    //actions
    @Step("Open the Sign in page")
    public SignInPage openPage() {
        open("/index.php?controller=authentication");
        return this;
    }

    @Step("Verify Sign in page")
    public SignInPage verifySignInPage() {
        pageTitle.shouldHave(text(PAGE_TITLE));
        return this;
    }

    @Step("Type email in Email address field")
    public SignInPage typeEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Type password in Password field")
    public SignInPage typePassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Type password in Password field")
    public SignInPage clickSignIn() {
        signInButton.click();
        return this;
    }
}
