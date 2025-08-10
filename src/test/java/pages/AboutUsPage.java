package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutUsPage {
    public AboutUsPage checkAboutUsAnchorText(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]")).shouldHave(text(expectedText));
        return this;
    }

    public AboutUsPage checkAboutSearchingText(String jobCondition) {
        $$("button:nth-child(6)")
                .findBy(text(jobCondition))
                .shouldBe(visible).scrollTo()
                .shouldHave(text(jobCondition));
        return this;
    }

    public VacanciesPage clickVacanciesLink() {
        SelenideElement vacanciesLink = $(By.xpath("//span[contains(text(),\"Вакансии\")]"));
        vacanciesLink.shouldBe(visible, clickable).click();
        return new VacanciesPage();
    }

}