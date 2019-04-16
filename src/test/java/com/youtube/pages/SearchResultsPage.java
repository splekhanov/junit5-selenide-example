package com.youtube.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage extends AbstractBasePage {

    private static SelenideElement searchResultsContainer = $x("//ytd-search/div[@id='container']");
    private static ElementsCollection resultsElements = $$x("//ytd-video-renderer[div[@id='dismissable']]");
    private static SelenideElement noResultsFoundTitle = $x("//div[contains(@class,'promo-title')]");

    @Override
    @Step("check Search Results Page is loaded")
    protected void assertLoaded() {
        searchResultsContainer.waitUntil(visible, 4000);
        assertDisplayed(searchResultsContainer);
    }

    public ElementsCollection getSearchResults() {
        return resultsElements.filterBy(visible);
    }

    public boolean areAnyResultsFound() {
        return noResultsFoundTitle.isDisplayed();
    }
}
