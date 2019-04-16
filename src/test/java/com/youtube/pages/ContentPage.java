package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ContentPage extends AbstractBasePage {

    private static SelenideElement contentPageManager = $x("//*[@id='page-manager']");

    @Override
    @Step("check Content Page is loaded")
    protected void assertLoaded() {
        assertDisplayed(contentPageManager);
    }
}
