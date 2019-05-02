package com.youtube.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage extends AbstractBasePage {

    private SelenideElement searchResultsContainer = $x("//ytd-search/div[@id='container']");
    private ElementsCollection resultsElements = $$x("//ytd-video-renderer[div[@id='dismissable']]");
    private SelenideElement noResultsFoundTitle = $x("//div[contains(@class,'promo-title')]");

    SearchResultsPage() {
        searchResultsContainer.waitUntil(visible, 4000);
        checkPageLoaded(searchResultsContainer);
    }

    public ElementsCollection getSearchResults() {
        return resultsElements.filterBy(visible);
    }

    public boolean areAnyResultsFound() {
        return noResultsFoundTitle.isDisplayed();
    }
}
