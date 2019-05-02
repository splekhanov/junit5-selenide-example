package com.youtube.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleLoginPage extends AbstractBasePage {

    private SelenideElement loginFormContainer = $x("//div[@id='initialView']");
    private SelenideElement logo = $x("//div[@id='logo']");
    private SelenideElement profile = $x("//div[@id='profileIdentifier']");
    private SelenideElement emailInput = $x("//input[@type='email']");
    private SelenideElement passwordInput = $x("//input[@name='password']");
    private SelenideElement loginNextButton = $x("//div[@id='identifierNext']");
    private SelenideElement passwordNextButton = $x("//div[@id='passwordNext']");

    GoogleLoginPage() {
        loginFormContainer.waitUntil(visible, 4000);
        checkPageLoaded(logo);
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
