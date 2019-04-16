package com.youtube.test.search;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.youtube.base.BaseTestClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.youtube.test.search.SearchBaseTest.searchAndCheckResults;

@DisplayName("Search Tests : Authorized User")
@Epic("SEARCH ENGINE")
@Feature("Search Feature")
@Story("Main Page Search Validation")
@ExtendWith({SoftAssertsExtension.class})
public class SearchAuthorizedUserTest extends BaseTestClass {

    @DisplayName("Search videos test : authorized user")
    @ParameterizedTest(name = "Searching for {0}")
    @CsvFileSource(resources = "/searchQueries/searchQueriesAuthorized.csv", numLinesToSkip = 1)
    public void searchTestAuthorized(String searchQuery, int resultsExpected, int userId) {
        login(getUserById(userId));
        searchAndCheckResults(youtubeMainPage, searchQuery, resultsExpected);
        logout();
    }
}
