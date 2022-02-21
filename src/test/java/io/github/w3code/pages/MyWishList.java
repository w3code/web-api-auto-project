package io.github.w3code.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyWishList {

    //locators and elements
    private final String PAGE_TITLE = "My wishlists";

    private final SelenideElement
            pageTitle = $(".page-heading"),
            myWishlistLink = $("#mywishlist a"),
            myWishListItemTitle = $("#s_title"),
            removeIcon = $(".wishlist_delete .icon");

    //actions
    @Step("Open My wishlist page")
    public MyWishList openPage() {
        open("/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        return this;
    }

    @Step("Verify My wishlist page")
    public MyWishList verifyMyWishListPage() {
        pageTitle.shouldHave(text(PAGE_TITLE));
        return this;
    }

    @Step("Click on My Wishlist")
    public MyWishList clickOnMyWishlist() {
        myWishlistLink.click();
        return this;
    }

    @Step("Verify product title in My wishlist ")
    public MyWishList verifyMyWishListItemTitle(String title) {
        myWishListItemTitle.shouldHave(text(title));
        return this;
    }

    @Step("Delete My wishlist for start state")
    public MyWishList deleteMyWishList() {
        removeIcon.click();
        confirm();
        return this;
    }

}
