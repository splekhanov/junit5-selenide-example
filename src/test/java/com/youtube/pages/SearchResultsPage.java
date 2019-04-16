package com.youtube.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage extends AbstractBasePage {

    private static final SelenideElement SEARCH_RESULTS_CONTAINER = $x("//ytd-search/div[@id='container']");
    private static final ElementsCollection RESULTS_ELEMENTS = $$x("//ytd-video-renderer[div[@id='dismissable']]");
    private static final SelenideElement NO_RESULTS_FOUND_TITLE = $x("//div[contains(@class,'promo-title')]");

    @Override
    @Step("check Search Results Page is loaded")
    protected void assertLoaded() {
        SEARCH_RESULTS_CONTAINER.waitUntil(visible, 4000);
        assertDisplayed(SEARCH_RESULTS_CONTAINER);
    }

    public ElementsCollection getSearchResults() {
        return RESULTS_ELEMENTS.filterBy(visible);
    }

    public boolean areAnyResultsFound() {
        return NO_RESULTS_FOUND_TITLE.isDisplayed();
    }
}
