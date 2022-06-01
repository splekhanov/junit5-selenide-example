package com.youtube.test.search;

import com.codeborne.selenide.junit5.*;
import com.youtube.base.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

@DisplayName("Search Tests : Authorized User")
@Epic("SEARCH ENGINE")
@Feature("Search Feature")
@Story("Main Page Search Validation")
@ExtendWith({SoftAssertsExtension.class})
public class SearchAuthorizedUserTest extends BaseTestClass {

//    @DisplayName("Search videos test : authorized user")
//    @ParameterizedTest(name = "Searching for {0}")
//    @CsvFileSource(resources = "/searchQueries/searchQueriesAuthorized.csv", numLinesToSkip = 1)
//    public void searchTestAuthorized(String searchQuery, int resultsExpected, int userId) {
//        login(getUserById(userId));
//        searchAndCheckResults(youtubeMainPage, searchQuery, resultsExpected);
//        logout();
//    }
}
