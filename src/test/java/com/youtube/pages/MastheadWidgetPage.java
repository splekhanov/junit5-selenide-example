package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MastheadWidgetPage extends AbstractBasePage {

    private static SelenideElement searchField = $x("//input[@id='search']");
    private static SelenideElement submitSearchButton = $x("//button[@id='search-icon-legacy']");
    private static SelenideElement loginButton = $x("//*[@id='masthead']//a[contains(@href,'ServiceLogin')]");
    private static SelenideElement avatarButton = $x("//button[@id='avatar-btn']");
    private static SelenideElement userMenuContainer = $x("//iron-dropdown//div[@id='container']");
    private static SelenideElement logoutLink = $x("//a[contains(@href,'logout')]");

    @Override
    @Step("check Masthead Widget is loaded")
    protected void assertLoaded() {
        assertDisplayed(searchField, submitSearchButton);
    }

    @Step("Searching for {searchRequest}")
    public SearchResultsPage searchFor(String searchRequest){
        searchField.setValue(searchRequest);
        submitSearchButton.click();
        return new SearchResultsPage();
    }

    @Step
    public GoogleLoginPage clickLoginButton(){
        loginButton.click();
        GoogleLoginPage gPage = new GoogleLoginPage();
        return gPage;
    }

    public void logout() {
        avatarButton.click();
        userMenuContainer.waitUntil(visible,1000);
        logoutLink.click();
        new YoutubeMainPage();
        loginButton.waitUntil(visible, 4000);
    }
}
