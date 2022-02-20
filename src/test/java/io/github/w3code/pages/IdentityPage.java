package io.github.w3code.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IdentityPage {

    //locators and elements
    private final String PAGE_TITLE = "Your personal information",
            SUCCESS_MESSAGE = "Your personal information has been successfully updated.";

    private final SelenideElement
            pageTitle = $(".page-subheading"),
            firstName = $("#firstname"),
            lastName = $("#lastname"),
            saveButton = $(By.xpath("//button[@name='submitIdentity']")),
            currentPassword = $("#old_passwd"),
            successMessage = $(".alert-success"),
            titleName = $(By.xpath("//a[@title='View my customer account']"));

    //actions
    public IdentityPage openPage() {
        open("/index.php?controller=identity");
        return this;
    }

    @Step("Verify Identity page")
    public IdentityPage verifyIdentityPage() {
        pageTitle.shouldHave(text(PAGE_TITLE));
        return this;
    }

    @Step("Type first name in First name field")
    public IdentityPage typeFirstname(String firstname) {
        firstName.setValue(firstname);
        return this;
    }

    @Step("Type last name in Last name field")
    public IdentityPage typeLastName(String lastname) {
        lastName.setValue(lastname);
        return this;
    }

    @Step("Type current password in Current Password field")
    public IdentityPage typeCurrentPassword(String currentPassword) {
        this.currentPassword.setValue(currentPassword);
        return this;
    }

    @Step("Click Save button")
    public IdentityPage clickSave() {
        saveButton.click();
        return this;
    }

    @Step("Verify Success Message")
    public IdentityPage verifySuccessMessage() {
        successMessage.shouldHave(text(SUCCESS_MESSAGE));
        return this;
    }

    @Step("Verify Title name")
    public IdentityPage verifyTitleName(String firstname, String lastname) {
        titleName.shouldHave(text(firstname + " " + lastname));
        return this;
    }
}
