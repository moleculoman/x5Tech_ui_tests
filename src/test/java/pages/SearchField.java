package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchField {
    public SearchField checkSearchFieldAnchorTextTest(String placeholderName) {
        $(By.xpath("//input[@placeholder=  '" + placeholderName + "']"))
                .shouldHave(attribute("placeholder", placeholderName));
        return this;
    }

    public SelenideElement getSearchField() {
        return $(By.xpath("//input[@placeholder='Поиск']")).shouldBe(clickable, Duration.ofSeconds(5));
    }

    public SelenideElement clickOnSearchField() {
        SelenideElement element = getSearchField();
        element.click();
        return element;
    }

    public SearchField setSearchFieldValue(String vacancyName) {
        clickOnSearchField()
                .setValue(vacancyName)
                .pressEnter();
        return this;
    }

    public SearchField checkResults(String vacancyName) {
        $(By.xpath("//a[contains(@title, '" + vacancyName + "')]")).shouldBe(clickable, Duration.ofSeconds(10));
        return this;
    }
}