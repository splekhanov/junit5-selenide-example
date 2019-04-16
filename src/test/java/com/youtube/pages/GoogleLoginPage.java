package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleLoginPage extends AbstractBasePage {

    private static SelenideElement loginFormContainer = $x("//div[@id='initialView']");
    private static SelenideElement logo = $x("//div[@id='logo']");
    private static SelenideElement profile = $x("//div[@id='profileIdentifier']");
    private static SelenideElement emailInput = $x("//input[@type='email']");
    private static SelenideElement passwordInput = $x("//input[@name='password']");
    private static SelenideElement loginNextButton = $x("//div[@id='identifierNext']");
    private static SelenideElement passwordNextButton = $x("//div[@id='passwordNext']");

    @Override
    protected void assertLoaded() {
        loginFormContainer.waitUntil(visible, 4000);
        assertDisplayed(logo);
    }

    public void login(String login, String password) {
        if (!profile.isDisplayed()) {
            emailInput.setValue(login);
            loginNextButton.click();
            passwordInput.waitUntil(visible, 2000);
        }
        passwordInput.setValue(password);
        passwordNextButton.click();
        new YoutubeMainPage();
    }
}
