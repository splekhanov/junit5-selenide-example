package com.youtube.browser;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CustomChromeDriverProvider implements WebDriverProvider {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-device-discovery-notifications");
        chromeOptions.addArguments("no-sandbox");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        WebDriverManager.chromedriver().setup();
        return new CustomChromeDriver(getChromeOptions());
    }

    private static class CustomChromeDriver extends ChromeDriver {
        protected CustomChromeDriver(ChromeOptions options) {
            super(options);
        }
    }
}