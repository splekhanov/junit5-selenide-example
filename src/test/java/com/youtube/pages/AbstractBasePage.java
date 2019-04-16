package com.youtube.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.youtube.exceptions.PageNotLoadedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.youtube.lib.Timeout.loading;
import static com.youtube.lib.Timeout.short_wait;

public abstract class AbstractBasePage {

    private static SelenideElement redNavigationProgressBar = $x("//yt-page-navigation-progress");

    AbstractBasePage() {
        waitForPageToLoad();
        checkLoaded();
    }

    protected abstract void assertLoaded();

    protected void assertDisplayed(SelenideElement... lctrs) {
        if (lctrs.length != 0) {
            List<SelenideElement> notDisplayedElements = getNotDisplayed(lctrs);
            if (notDisplayedElements.size() > 0) {
                throw new AssertionError("Were not displayed: " + notDisplayedElements);
            }
        }
    }

    private List<SelenideElement> getNotDisplayed(SelenideElement[] lctrs) {
        List<SelenideElement> notDisplayed = new ArrayList<>();
        for (SelenideElement element : lctrs) {
            if (!element.isDisplayed()) {
                notDisplayed.add(element);
            }
        }
        return notDisplayed;
    }

    private void checkLoaded() {
        try {
            assertLoaded();
        } catch (AssertionError ae) {
            throw new PageNotLoadedException(getDetailMsg(ae));
        }
    }

    String getPageName() {
        return this.getClass().getSimpleName();
    }

    private String getDetailMsg(Throwable thr) {
        String pcName = getPageName();
        return pcName + "\n" + thr.getMessage();
    }

    protected void waitForPageToLoad() {
        waitFor(new DOMreadyStateReached(), loading);
    }

    private <T> void waitFor(ExpectedCondition<T> condition, long timeOutInSeconds) {
        new WebDriverWait(getWebDriver(), timeOutInSeconds)
                .ignoring(NotFoundException.class, NoSuchWindowException.class)
                .until(condition);
    }

    private static class DOMreadyStateReached implements ExpectedCondition<Boolean> {

        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document['readyState']").equals("complete");
        }

        @Override
        public String toString() {
            return "DOM 'ready' state reached";
        }
    }

    protected boolean isVisible(SelenideElement elem) {
        if (elem.waitUntil(visible, 4000).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
