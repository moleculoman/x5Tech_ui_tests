package tests;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static utils.JsSnippetsUtils.removeBanners;


public class X5TechTests extends TestSettingsX5TechTests {
    private MainPage mainPage;
    private AboutUsPageAnchor aboutUsAnchorPage;
    private PublicationsPageAnchor publicationsAnchorPage;
    private TechnologiesPageAnchor technologiesAnchorPage;
    private SearchFieldAnchor searchAnchorField;
    @BeforeEach
    public void setUp() {
        mainPage = MainPage.openPage();
        removeBanners();
        aboutUsAnchorPage = new AboutUsPageAnchor();
        publicationsAnchorPage = new PublicationsPageAnchor();
        technologiesAnchorPage = new TechnologiesPageAnchor();
        searchAnchorField = new SearchFieldAnchor();
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("TC_1: Проверка на то, что сайт работает и открывается")
    void siteShouldBeFunctional() {
        mainPage.mainStructureElementsExist();
    }

    @ValueSource(strings = {
            "удаленно"
    })
    @ParameterizedTest(name = "В категории должно быть значение {0}")
    @Tag("MAJOR")
    @DisplayName("TC_2: Проверка наличия возможности работать удаленно среди условий работы")

    void shouldHaveRemoteWork(String jobCondition) {
        mainPage.clickAboutUs();
        aboutUsAnchorPage.checkAboutUsAnchorText("О нас");
        aboutUsAnchorPage.checkAboutSearchingText(jobCondition);
        //Таймер, чтобы успеть сделать скрин для отчёта
        sleep(1000);
    }

    @CsvSource(value = {
            "Backend, Все, Java, Python",
            "Mobile, Все, Android, iOS"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и разделы со значениями {1},{2},{3}")
    @Tag("MAJOR")
    @DisplayName("TC_3: Проверка наличия определенной вкладки в навигационном меню - \"Технологии и Решения\"")
    void siteShouldHaveCertainSections(String section, String generalSubSection,
                                               String firstSubSection, String secondSubSection)
    {
        mainPage.clickTechnologies();
        technologiesAnchorPage.checkTechnologiesPageAnchorText("Технологии и решения");
        technologiesAnchorPage.checkMainSection(section);
        technologiesAnchorPage.clickOnMainSection(section);

        technologiesAnchorPage.getGeneralSubSectionElement(generalSubSection);
        technologiesAnchorPage.checkGeneralSubSection(generalSubSection);
        technologiesAnchorPage.clickOnGeneralSubSection(generalSubSection);

        technologiesAnchorPage.getFirstSubSectionElement(firstSubSection);
        technologiesAnchorPage.checkFirstSubSection(firstSubSection);
        technologiesAnchorPage.clickOnFirstSubSection(firstSubSection);

        technologiesAnchorPage.getSecondSubSectionElement(secondSubSection);
        technologiesAnchorPage.checkSecondSubSection(secondSubSection);
        technologiesAnchorPage.clickOnSecondSubSection(secondSubSection);
        //Таймер, чтобы успеть сделать скрин для отчёта
        sleep(1000);

    }

    @ValueSource(strings = {
            "DevOps",
            "Data"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0} и со значением {1}")
    @Tag("MINOR")
    @DisplayName("TC_4: Проверка наличия выбранного направления во вкладке - \"Публикации\"")
    void siteShouldHaveCertainPublications(String direction)
    {
        mainPage.clickPublications();
        publicationsAnchorPage.checkPublicationsAnchorTextTest("Публикации");
        //Таймер для ожидания полной загрузки списка направлений Публикаций (иначе тест Flaky становится)
        sleep(3000);
        publicationsAnchorPage.getPublicationsButton();
        publicationsAnchorPage.clickOnPublicationsButton();

        publicationsAnchorPage.getPublicationsButtonWithSearchingDirection(direction);
        publicationsAnchorPage.checkPublicationsButtonWithSearchingDirection(direction);
        publicationsAnchorPage.clickOnPublicationsButtonWithSearchingPublication(direction);
        publicationsAnchorPage.checkAmountOfPublications();
        //Таймер, чтобы успеть сделать скрин для отчёта
        sleep(1000);
    }

    @ValueSource(strings = {
            "тестированию",
            "аналитик"
    })
    @ParameterizedTest(name = "Должна быть вкладка со значением {0}")
    @Tag("MINOR")
    @DisplayName("TC_5: Проверка поисковой строки по логическому совпадению наименования вакансии")
    void siteShouldHaveVacancy(String vacancyName)
    {
        mainPage.clickSearch();
        searchAnchorField.checkSearchFieldAnchorTextTest("Поиск");
        searchAnchorField.setSearchFieldValue(vacancyName);
        searchAnchorField.checkResults(vacancyName);
        //Таймер, чтобы успеть сделать скрин для отчёта
        sleep(1000);
    }
}