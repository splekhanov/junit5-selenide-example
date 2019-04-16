package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class YoutubeMainPage extends AbstractBasePage {

    private MastheadWidgetPage mastheadWidgetPage;
    private ContentPage contentPage;

    public YoutubeMainPage() {
        mastheadWidgetPage = new MastheadWidgetPage();
        contentPage = new ContentPage();
    }

    private static final SelenideElement MASTHEAD_WIDGET = $x("//*[@id='masthead']");
    private static final SelenideElement GUIDE_WIDGET = $x("//*[@id='guide-renderer']");

    @Override
    @Step("check Youtube Main Page is loaded")
    protected void assertLoaded() {
        MASTHEAD_WIDGET.waitUntil(visible, 4000);
        assertDisplayed(GUIDE_WIDGET);
    }

    public MastheadWidgetPage getMastheadWidgetPage() {
        return mastheadWidgetPage;
    }

    public ContentPage getContentPage() {
        return contentPage;
    }
}
