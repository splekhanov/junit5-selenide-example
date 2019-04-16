package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleLoginPage extends AbstractBasePage {

    private static final SelenideElement LOGIN_FORM_CONTAINER = $x("//div[@id='initialView']");
    private static final SelenideElement LOGO = $x("//div[@id='logo']");
    private static final SelenideElement PROFILE = $x("//div[@id='profileIdentifier']");
    private static final SelenideElement EMAIL_INPUT = $x("//input[@type='email']");
    private static final SelenideElement PASSWORD_INPUT = $x("//input[@name='password']");
    private static final SelenideElement LOGIN_NEXT_BUTTON = $x("//div[@id='identifierNext']");
    private static final SelenideElement PASSWORD_NEXT_BUTTON = $x("//div[@id='passwordNext']");

    @Override
    protected void assertLoaded() {
        LOGIN_FORM_CONTAINER.waitUntil(visible, 4000);
        assertDisplayed(LOGO);
    }

    public void login(String login, String password) {
        if (!PROFILE.isDisplayed()) {
            EMAIL_INPUT.setValue(login);
            LOGIN_NEXT_BUTTON.click();
            PASSWORD_INPUT.waitUntil(visible, 2000);
        }
        PASSWORD_INPUT.setValue(password);
        PASSWORD_NEXT_BUTTON.click();
        new YoutubeMainPage();
    }
}
