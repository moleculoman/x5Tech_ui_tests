package tests.X5Tech;

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
        //acceptCookies();
        $(By.xpath("//span[contains(text(),'О нас')]")).click();
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
        //acceptCookies();
        $(By.xpath("//span[contains(text(), 'Технологии и решения')]")).click();
        $(By.xpath("//div[@class='simplebar-content']//span[text()='" + section + "']")).click();
        $(By.xpath("//label[contains(text(), '" + generalSubSection + "')]")).shouldBe(exist);
        $(By.xpath("//label[contains(text(), '" + javaSubSection + "')]")).shouldBe(exist);
        $(By.xpath("//label[contains(text(), '" + pythonSubSection + "')]")).shouldBe(exist);
    }

    @CsvSource(value = {
            "Тестирование, тест"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и со значениями {1}")
    @Tag("MINOR")
    @DisplayName("TC_4: Проверка наличия направления \"Тестирование\" во вкладке - \"Публикации\"")
    void siteShouldHaveCertainPublications(String direction, String keyWord)
    {
        //acceptCookies();
        $(By.xpath("//span[contains(text(),'Публикации')]")).click();
        $(By.xpath("//span[contains(text(),'Все направления')]")).click();
        $(By.xpath("//span[contains(text(), '" + direction + "')]")).click();
        $(By.xpath("//a[contains(text(), '" + keyWord + "')]")).shouldBe(visible);
    }

    @ValueSource(strings = {
            "тестированию"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и разделы со значениями {1},{2},{3}")
    @Tag("MINOR")
    @DisplayName("TC_5: Проверка поисковой строки по логическому совпадению наименования вакансии")
    void siteShouldHaveVacancy(String vacancyName)
    {
        //acceptCookies();
        $(By.xpath("//input[@placeholder='Поиск']")).setValue(vacancyName).pressEnter();
        $(("a[title*='" + vacancyName + "']")).shouldBe(visible);
    }
}