package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContentPage extends AbstractBasePage {

    private SelenideElement contentPageManager = $x("//*[@id='page-manager']");

    ContentPage() {
        checkPageLoaded(contentPageManager);
    }
}
