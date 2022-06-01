package com.youtube.test.search;

import com.codeborne.selenide.junit5.*;
import com.youtube.base.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

@DisplayName("Search Tests : Unauthorized User")
@Epic("SEARCH ENGINE")
@Feature("Search Feature")
@Story("Main Page Search Validation")
@ExtendWith({SoftAssertsExtension.class})
public class SearchUnauthorizedUserTest extends BaseTestClass {

//    @DisplayName("Search videos test : guest user")
//    @ParameterizedTest(name = "Searching for {0}")
//    @CsvFileSource(resources = "/searchQueries/searchQueriesUnauthorized.csv", numLinesToSkip = 1)
//    public void searchTestUnauthorized(String searchQuery, int resultsExpected) {
//        searchAndCheckResults(youtubeMainPage, searchQuery, resultsExpected);
//    }
}
