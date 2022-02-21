package io.github.w3code.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WomanPage {

    //locators and elements
    private final String PAGE_TITLE = "WOMEN",
            OK_ADDED_MESSAGE = "Product successfully added to your shopping cart",
            ADDED_TO_WISHLIST_MESSAGE = "Added to your wishlist.";

    private final SelenideElement
            pageTitle = $(".title_block"),
            firstCart = $(".product_img_link"),
            okMessage = $("h2"),
            addedToWishList = $(".fancybox-error");

    private final ElementsCollection cartImages = $$(".product_img_link");

    private String itemTitle;

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

    @Step("Move to cart ")
    public WomanPage moveToCart(int num) {
        cartImages.get(num).hover();
        return this;
    }

    @Step("Click Add To Cart")
    public WomanPage clickAddToCart(int num) {
        $(By.xpath("//a[@data-id-product='" + (num + 1) + "']")).click();
        return this;
    }

    @Step("Verify product added message")
    public WomanPage verifyProductAdded() {
        okMessage.shouldHave(text(OK_ADDED_MESSAGE));
        return this;
    }

    @Step("Set product title for future verify")
    public WomanPage setItemTitle(int num) {
        itemTitle = cartImages.get(num).getAttribute("title");
        return this;
    }

    @Step("Get product title")
    public String getItemTitle() {
        return this.itemTitle;
    }

    @Step("Add to wishlist")
    public WomanPage addToWishList(int num) {
        $(".addToWishlist.wishlistProd_" + (num + 1)).click();
        return this;
    }

    @Step("Verify added in wishlist message")
    public WomanPage verifyAddedToWishListMessage() {
        addedToWishList.shouldHave(text(ADDED_TO_WISHLIST_MESSAGE));
        return this;
    }
}
