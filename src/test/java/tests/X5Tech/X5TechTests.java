package tests.X5Tech;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("X5TechTests")

public class X5TechTests extends TestSettingsX5TechTests {
    @BeforeEach
    void setUp() {
        openPage();
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("TC_1: Проверка на то, что сайт работает и открывается")
    void siteShouldBeFunctional() {
        $("div#page").shouldBe();
        $("div.overflow-x-clip").shouldBe(exist);
    }

    @ValueSource(strings = {
            "удаленно"
    })
    @ParameterizedTest(name = "В категории должно быть значение {0}")
    @Tag("MAJOR")
    @DisplayName("TC_2: Проверка наличия возможности работать удаленно среди условий работы")

    void shouldHaveRemoteWork(String jobCondition) {
        $(By.xpath("//span[contains(text(),'О нас')]")).click();
        removeBanners();
        $$("button:nth-child(6)")
                .findBy(text(jobCondition))
                .shouldBe(visible)
                .shouldHave(text(jobCondition));
    }

    @CsvSource(value = {
            "Backend, Все, Java, Python"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и разделы со значениями {1},{2},{3}")
    @Tag("MAJOR")
    @DisplayName("TC_3: Проверка наличия определенной вкладки в навигационном меню - \"Технологии и Решения\"")
    void siteShouldHaveCertainSections(String section, String generalSubSection,
                                               String javaSubSection, String pythonSubSection)
    {
        $(By.xpath("//span[contains(text(), 'Технологии и решения')]")).click();
        removeBanners();
        $(By.xpath("//div[@class='simplebar-content']//span[text()='" + section + "']")).click();
        $(By.xpath("//label[contains(text(), '" + generalSubSection + "')]")).shouldBe(exist).click();
        $(By.xpath("//label[contains(text(), '" + javaSubSection + "')]")).shouldBe(exist).click();
        $(By.xpath("//label[contains(text(), '" + pythonSubSection + "')]")).shouldBe(exist).click();
    }

    @ValueSource(strings = {
            "DevOps"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и со значениями {1}")
    @Tag("MINOR")
    @DisplayName("TC_4: Проверка наличия направления \"DevOps\" во вкладке - \"Публикации\"")
    void siteShouldHaveCertainPublications(String direction)
    {
        $(By.xpath("//span[contains(text(),'Публикации')]")).shouldBe(visible).click();
        sleep(5000);
        $(By.xpath("//span[text()='Все направления']")).shouldBe(exist).click();
        $(By.xpath("//span[text()='" + direction + "']")).shouldBe(visible).click();
        removeBanners();
        SelenideElement publicationsCountElement = $(By.xpath("//h1[text()='Публикации']/following-sibling::span"));
        String publicationsCountText = publicationsCountElement.getText();
        int publicationsCount = Integer.parseInt(publicationsCountText);
        Assertions.assertTrue(publicationsCount > 0, "Количество публикаций должно быть больше нуля");
    }

    @ValueSource(strings = {
            "тестированию"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и разделы со значениями {1},{2},{3}")
    @Tag("MINOR")
    @DisplayName("TC_5: Проверка поисковой строки по логическому совпадению наименования вакансии")
    void siteShouldHaveVacancy(String vacancyName)
    {
        sleep(5000);
        $(By.xpath("//input[@placeholder='Поиск']")).setValue(vacancyName).pressEnter();
        removeBanners();
        $(By.xpath("//a[contains(@title, '" + vacancyName + "')]")).shouldBe(visible);
    }
}