package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacanciesPage {
    private final SelenideElement vacanciesHeader = $(By.xpath("//span[contains(text(),\"Вакансии\")]"));
    private final ElementsCollection vacancyCards = $$("div:nth-child(6)");

    public VacanciesPage verifyVacanciesPageLoaded() {
        vacanciesHeader.shouldBe(visible).shouldHave(text("Вакансии"));
        vacancyCards.shouldHave(sizeGreaterThan(0));
        return this;
    }
}