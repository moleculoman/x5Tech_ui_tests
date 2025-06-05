package tests.X5Tech;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TestSettingsX5TechTests {
    static String SELENOID_URL = System.getProperty("SELENOID_URL");
    static String SELENOID_LOGIN = System.getProperty("SELENOID_LOGIN");
    static String SELENOID_PASSWORD = System.getProperty("SELENOID_PASSWORD");
    @BeforeAll
    static void settingsForBrowserDemoQa() {
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser.version", "128.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://x5.tech";
    }
    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.remote = "https://" + SELENOID_LOGIN + ":" + SELENOID_PASSWORD + "@" + SELENOID_URL + "/wd/hub";
        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = false;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }

    public TestSettingsX5TechTests openPage() {
        open("");
        return this;
    }

    /*public TestSettingsX5TechTests acceptCookies() {
        executeJavaScript(
                "var button = document.querySelector('button:contains(\"Хорошо\")');" +
                        "if (button) { button.click(); }"
        );
        return this;
    }*/
}
