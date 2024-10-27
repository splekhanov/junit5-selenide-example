package com.youtube.base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.youtube.objects.User;
import com.youtube.pages.GoogleLoginPage;
import com.youtube.pages.YoutubeMainPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.collect.MoreCollectors.onlyElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestClass {

    protected static User user1;
    private static List<User> users;
    private static String startUrl;
    private static Properties properties;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BaseTestClass.class));
    protected YoutubeMainPage youtubeMainPage;

    @BeforeAll
    static void setUpAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @BeforeEach
    public void setUp() {
        setProperties();
        selenideConfig();
        openStartPage(startUrl);
        youtubeMainPage = new YoutubeMainPage();
    }

    @AfterEach
    public void tearDown() {
        SelenideLogger.removeListener("Allure Selenide");
    }

    @Step("Open page {startUrl}")
    private void openStartPage(String startUrl) {
        open(startUrl);
    }

    @Step("Login as {user}")
    public void login(User user) {
        GoogleLoginPage googleLoginPage = youtubeMainPage.getMastheadWidgetPage().clickLoginButton();
        googleLoginPage.login(user.getLogin(), user.getPassword());
    }

    @Step("Logout")
    public void logout() {
        youtubeMainPage.getMastheadWidgetPage().logout();
    }

    private static void selenideConfig() {
        Configuration.browser = "com.youtube.browser.CustomChromeDriverProvider";

        // Local chromedriver configuration
        final URL location = BaseTestClass.class.getClassLoader().getResource("chromedriver.exe");
        String uriPath = location.getPath();
        final Path path = Paths.get(uriPath.substring(1));
        System.setProperty("webdriver.chrome.driver", path.toString());

        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "target/reports";
        SelenideLogger.addListener("Allure Selenide", new AllureSelenide());
    }

    private static void setProperties() {
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(Objects.requireNonNull(BaseTestClass.class.getClassLoader().getResourceAsStream("local.properties")), StandardCharsets.UTF_8));
        } catch (IOException e) {
            LOGGER.warning("Can't load 'config.properties'");
        }
        startUrl = properties.getProperty("startUrl");
        /* Initialize user 1 */
        user1 = new User(properties.getProperty("userId"),
                properties.getProperty("userName"),
                properties.getProperty("userLogin"),
                properties.getProperty("userPass"));
        users = new ArrayList<>();
        users.add(user1);
    }

    public static User getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).collect(onlyElement());
    }

    @Step("Check {descr}")
    public static void checkTrue(String descr, boolean value) {
        assertTrue(value);
    }

    @Step("Chech that every element contains text {text}")
    public static void checkElementsCollectionContainText(ElementsCollection collection, String text) {
        collection.forEach(selenideElement -> selenideElement.should(Condition.text(text)));
    }

    @Step("Chech that first {elementsToCheck} elements contain text {text}")
    public static void checkElementsCollectionContainText(ElementsCollection collection, String text, int elementsToCheck) {
        collection.first(elementsToCheck).forEach(selenideElement -> selenideElement.should(Condition.text(text)));
    }

    @Step("Check that elements amount greater or equal {expectedSize}")
    public static void checkElementsCollectionSizeGreaterOrEqual(ElementsCollection collection, int expectedSize) {
        collection.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(expectedSize));
    }

    @Step("Check that elements amount is {expectedSize}")
    public static void checkElementsCollectionSize(ElementsCollection collection, int expectedSize) {
        collection.shouldBe(CollectionCondition.size(expectedSize));
    }
}
