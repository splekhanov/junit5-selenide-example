package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ContentPage extends AbstractBasePage {

    private static final SelenideElement CONTENT_PAGE_MANAGER = $x("//*[@id='page-manager']");

    @Override
    @Step("check Content Page is loaded")
    protected void assertLoaded() {
        assertDisplayed(CONTENT_PAGE_MANAGER);
    }
}
