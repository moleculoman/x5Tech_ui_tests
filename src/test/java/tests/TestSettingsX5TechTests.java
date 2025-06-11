package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attach;

import java.util.Map;


public class TestSettingsX5TechTests {
    static String SELENOID_URL = System.getProperty("SELENOID_URL");
    static String SELENOID_LOGIN = System.getProperty("SELENOID_LOGIN");
    static String SELENOID_PASSWORD = System.getProperty("SELENOID_PASSWORD");
    @BeforeAll
    static void settingsForBrowserDemoQa() {
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        //Configuration.browserVersion = System.getProperty("browser.version", "127.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://x5.tech";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        /*Configuration.remote = "https://" + SELENOID_LOGIN + ":" + SELENOID_PASSWORD + "@" + SELENOID_URL + "/wd/hub";
        Configuration.browserCapabilities = capabilities;*/
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
