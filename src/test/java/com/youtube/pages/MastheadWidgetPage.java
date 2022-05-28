package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MastheadWidgetPage extends AbstractBasePage {

    private SelenideElement searchField = $x("//input[@id='search']");
    private SelenideElement submitSearchButton = $x("//button[@id='search-icon-legacy']");
    private SelenideElement loginButton = $x("//*[@id='masthead']//a[contains(@href,'ServiceLogin')]");
    private SelenideElement avatarButton = $x("//button[@id='avatar-btn']");
    private SelenideElement userMenuContainer = $x("//iron-dropdown//div[@id='container']");
    private SelenideElement logoutLink = $x("//a[contains(@href,'logout')]");

    MastheadWidgetPage() {
        checkPageLoaded(searchField, submitSearchButton);
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
        userMenuContainer.shouldBe(visible);
        logoutLink.click();
        new YoutubeMainPage();
        loginButton.shouldBe(visible);
    }
}
