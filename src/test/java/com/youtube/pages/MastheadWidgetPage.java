package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MastheadWidgetPage extends AbstractBasePage {

    private final SelenideElement searchField = $x("//input[@id='search']");
    private final SelenideElement submitSearchButton = $x("//button[@id='search-icon-legacy']");
    private final SelenideElement loginButton = $x("//*[@id='masthead']//a[contains(@href,'ServiceLogin')]");
    private final SelenideElement avatarButton = $x("//button[@id='avatar-btn']");
    private final SelenideElement userMenuContainer = $x("//iron-dropdown//div[@id='container']");
    private final SelenideElement logoutLink = $x("//a[contains(@href,'logout')]");

    MastheadWidgetPage() {
        checkPageLoaded(searchField, submitSearchButton);
    }

    @Step("Searching for {searchRequest}")
    public SearchResultsPage searchFor(String searchRequest) {
        searchField.setValue(searchRequest);
        submitSearchButton.click();
        return new SearchResultsPage();
    }

    @Step
    public GoogleLoginPage clickLoginButton() {
        loginButton.click();
        return new GoogleLoginPage();
    }

    public void logout() {
        avatarButton.click();
        userMenuContainer.shouldBe(visible);
        logoutLink.click();
        new YoutubeMainPage();
        loginButton.shouldBe(visible);
    }
}
