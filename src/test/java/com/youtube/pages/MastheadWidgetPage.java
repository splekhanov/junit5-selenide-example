package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MastheadWidgetPage extends AbstractBasePage {

    private static final SelenideElement SEARCH_FIELD = $x("//input[@id='search']");
    private static final SelenideElement SUBMIT_SEARCH_BUTTON = $x("//button[@id='search-icon-legacy']");
    private static final SelenideElement LOGIN_BUTTON = $x("//*[@id='masthead']//a[contains(@href,'ServiceLogin')]");
    private static final SelenideElement AVATAR_BUTTON = $x("//button[@id='avatar-btn']");
    private static final SelenideElement USER_MENU_CONTAINER = $x("//iron-dropdown//div[@id='container']");
    private static final SelenideElement LOGOUT_LINK = $x("//a[contains(@href,'logout')]");

    @Override
    @Step("check Masthead Widget is loaded")
    protected void assertLoaded() {
        assertDisplayed(SEARCH_FIELD, SUBMIT_SEARCH_BUTTON);
    }

    @Step("Searching for {searchRequest}")
    public SearchResultsPage searchFor(String searchRequest){
        SEARCH_FIELD.setValue(searchRequest);
        SUBMIT_SEARCH_BUTTON.click();
        return new SearchResultsPage();
    }

    @Step
    public GoogleLoginPage clickLoginButton(){
        LOGIN_BUTTON.click();
        GoogleLoginPage gPage = new GoogleLoginPage();
        return gPage;
    }

    public void logout() {
        AVATAR_BUTTON.click();
        USER_MENU_CONTAINER.waitUntil(visible,1000);
        LOGOUT_LINK.click();
        new YoutubeMainPage();
        LOGIN_BUTTON.waitUntil(visible, 4000);
    }
}
