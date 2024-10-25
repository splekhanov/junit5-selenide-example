package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class YoutubeMainPage extends AbstractBasePage {

    private final MastheadWidgetPage mastheadWidgetPage;
    private final ContentPage contentPage;

    private final SelenideElement mastheadWidget = $x("//*[@id='masthead']");
    private final SelenideElement guideWidget = $x("//*[@id='guide-renderer' or @id='items']");

    public YoutubeMainPage() {
        mastheadWidget.shouldBe(visible);
        checkPageLoaded(guideWidget);

        mastheadWidgetPage = new MastheadWidgetPage();
        contentPage = new ContentPage();
    }

    public MastheadWidgetPage getMastheadWidgetPage() {
        return mastheadWidgetPage;
    }

    public ContentPage getContentPage() {
        return contentPage;
    }
}
