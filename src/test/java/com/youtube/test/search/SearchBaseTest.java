package com.youtube.test.search;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.youtube.base.BaseTestClass;
import com.youtube.pages.SearchResultsPage;
import com.youtube.pages.YoutubeMainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.AssertionMode.SOFT;

public class SearchBaseTest extends BaseTestClass {

    @Step
    public static void searchAndCheckResults(YoutubeMainPage youtubeMainPage, String searchQuery, int resultsExpected) {
        Configuration.assertionMode = SOFT;
        SearchResultsPage searchResultsPage = youtubeMainPage.getMastheadWidgetPage().searchFor(searchQuery);
        checkSearchResultsRelevance(searchResultsPage, searchQuery, resultsExpected);
    }

    @Step
    public static void checkSearchResultsRelevance(SearchResultsPage searchResultsPage, String searchQuery, int resultsExpected) {
        ElementsCollection searchResults = searchResultsPage.getSearchResults();
        if (resultsExpected == 0) {
            checkTrue("Check that there are no results found", searchResultsPage.areAnyResultsFound());
        } else {
            checkElementsCollectionSizeGreaterOrEqual(searchResults, resultsExpected);
            checkElementsCollectionContainText(searchResults, searchQuery, resultsExpected);
        }
    }
}
