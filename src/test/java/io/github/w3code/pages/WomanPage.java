package io.github.w3code.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WomanPage {

    //locators and elements
    private final String PAGE_TITLE = "WOMEN",
            OK_ADDED_MESSAGE = "Product successfully added to your shopping cart";

    private final SelenideElement
            pageTitle = $(".title_block"),
            firstCart = $(".product_img_link"),
            addToCartButton = $(By.xpath("//a[@title='Add to cart']")),
            okMessage = $("h2");

    //actions
    @Step("Open the Woman page")
    public WomanPage openPage() {
        open("/index.php?id_category=3&controller=category");
        return this;
    }

    @Step("Verify Woman page")
    public WomanPage verifyWomanPage() {
        pageTitle.shouldHave(text(PAGE_TITLE));
        return this;
    }

    @Step("Move to first cart")
    public WomanPage moveToFirstCart() {
        firstCart.hover();
        return this;
    }

    @Step("Click Add To Cart")
    public WomanPage clickAddToCart() {
        addToCartButton.click();
        return this;
    }

    @Step("Verify product added message")
    public WomanPage verifyProductAdded() {
        okMessage.shouldHave(text(OK_ADDED_MESSAGE));
        return this;
    }

}
