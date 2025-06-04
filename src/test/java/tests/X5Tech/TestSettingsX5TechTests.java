package tests.X5Tech;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestSettingsX5TechTests {
    static String SELENOID_URL = System.getProperty("selenoid.url");
    static String SELENOID_LOGIN = System.getProperty("selenoid.login");
    static String SELENOID_PASSWORD = System.getProperty("selenoid.password");
    @BeforeAll
    static void settingsForBrowserMegaMarketTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://x5.tech/";
        Configuration.pageLoadStrategy = "eager";
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
}
