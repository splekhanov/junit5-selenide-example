package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;
import com.youtube.exceptions.PageNotLoadedException;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractBasePage {

    private final SelenideElement redNavigationProgressBar = $x("//yt-page-navigation-progress");

    protected void checkPageLoaded(SelenideElement... lctrs) {
        try {
            assertDisplayed(lctrs);
        } catch (AssertionError ae) {
            throw new PageNotLoadedException(getDetailMsg(ae));
        }
    }

    protected void assertDisplayed(SelenideElement... lctrs) {
        if (lctrs.length != 0) {
            List<SelenideElement> notDisplayedElements = getNotDisplayed(lctrs);
            if (notDisplayedElements.size() > 0) {
                throw new AssertionError("These elements were not displayed: " + notDisplayedElements);
            }
        }
    }

    private List<SelenideElement> getNotDisplayed(SelenideElement[] lctrs) {
        List<SelenideElement> notDisplayed = new ArrayList<>();
        for (SelenideElement element : lctrs) {
            if (!element.exists()) {
                notDisplayed.add(element);
            }
        }
        return notDisplayed;
    }

    String getPageName() {
        return this.getClass().getSimpleName();
    }

    private String getDetailMsg(Throwable thr) {
        String pcName = getPageName();
        return pcName + "\n" + thr.getMessage();
    }

    protected boolean isVisible(SelenideElement elem) {
        return elem.shouldBe(visible).isDisplayed();
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
