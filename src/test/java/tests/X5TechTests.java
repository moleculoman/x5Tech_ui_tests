package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class X5TechTests extends TestSettingsX5TechTests {

    @Test
    @Tag("BLOCKER")
    @DisplayName("TC_1: Проверка на то, что сайт работает и открывается")
    void siteShouldBeFunctional() {
        step("Проверить функциональность сайта - сайт должен быть доступен", () -> {
            MainPage.openPage().mainStructureElementsExist();
        });
    }

    @Test
    @Tag("NORMAL")
    @DisplayName("TC_2: Проверка наличия контактной информации в подвале сайта")
    void shouldDisplayContactInformation() {
        step("Проверить наличие контактной информации в подвале", () -> {
            MainPage.openPage()
                    .verifyContactEmailExists("x5tech@x5.ru");
        });
    }


    @ValueSource(strings = {
            "удаленно"
    })
    @ParameterizedTest(name = "В категории должно быть значение {0}")
    @Tag("MAJOR")
    @DisplayName("TC_3: Проверка наличия возможности работать удаленно среди условий работы")
    void shouldHaveRemoteWork(String jobCondition) {
        step("Проверить наличие возможности работы удаленно", () -> {
            MainPage.openPage()
                    .clickAboutUs()
                    .checkAboutUsAnchorText("О нас")
                    .checkAboutSearchingText(jobCondition);
            sleep(1000);
        });
    }

    @Test
    @Tag("MAJOR")
    @DisplayName("TC_4: Проверка перехода на страницу вакансий из раздела 'О нас'")
    void shouldNavigateToVacanciesFromAboutUs() {
        step("Проверить переход на страницу вакансий", () -> {
            MainPage.openPage()
                    .clickAboutUs()
                    .clickVacanciesLink()
                    .verifyVacanciesPageLoaded();
        });
    }

    @CsvSource(value = {
            "Backend, Все, Java, Python",
            "Mobile, Все, Android, iOS"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и разделы со значениями {1},{2},{3}")
    @Tag("MAJOR")
    @DisplayName("TC_5: Проверка наличия определенной вкладки в навигационном меню - \"Технологии и Решения\"")
    void siteShouldHaveCertainSections(String section, String generalSubSection,
                                       String firstSubSection, String secondSubSection) {
        step("Проверить наличие определенных секций в навигационном меню 'Технологии и решения'", () -> {
            MainPage.openPage()
                    .clickTechnologies()
                    .checkTechnologiesPageAnchorText("Технологии и решения")
                    .checkMainSection(section)
                    .clickOnMainSection(section)
                    .checkGeneralSubSection(generalSubSection)
                    .clickOnGeneralSubSection(generalSubSection)
                    .checkFirstSubSection(firstSubSection)
                    .clickOnFirstSubSection(firstSubSection)
                    .checkSecondSubSection(secondSubSection)
                    .clickOnSecondSubSection(secondSubSection);
            sleep(1000);
        });
    }

    @ValueSource(strings = {
            "DevOps",
            "Data"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0}")
    @Tag("MINOR")
    @DisplayName("TC_6: Проверка наличия выбранного направления во вкладке - \"Публикации\"")
    void siteShouldHaveCertainPublications(String direction) {
        step("Проверить наличие выбранного направления во вкладке 'Публикации'", () -> {
            MainPage.openPage()
                    .clickPublications()
                    .checkPublicationsAnchorTextTest("Публикации");
            sleep(3000); // Таймер для ожидания загрузки

            MainPage.openPage()
                    .clickPublications()
                    .clickOnPublicationsButton()
                    .checkPublicationsButtonWithSearchingDirection(direction)
                    .clickOnPublicationsButtonWithSearchingPublication(direction)
                    .checkAmountOfPublications();
            sleep(1000);
        });
    }

    @ValueSource(strings = {
            "тестированию",
            "аналитик"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0}")
    @Tag("MINOR")
    @DisplayName("TC_7: Проверка поисковой строки по логическому совпадению наименования вакансии")
    void siteShouldHaveVacancy(String vacancyName) {
        step("Проверить поиск вакансии по ключевому слову: " + vacancyName, () -> {
            MainPage.openPage()
                    .clickSearch()
                    .checkSearchFieldAnchorTextTest("Поиск")
                    .setSearchFieldValue(vacancyName)
                    .checkResults(vacancyName);
            sleep(1000);
        });
    }
}