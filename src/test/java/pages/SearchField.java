package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchField {
    private final SelenideElement searchField = $(By.xpath("//input[@placeholder='Поиск']"));

    public SearchField checkSearchFieldAnchorTextTest(String placeholderName) {
        SelenideElement fieldElement = $(By.xpath("//input[@placeholder=  '" + placeholderName + "']"));
        fieldElement.shouldHave(attribute("placeholder", placeholderName));
        return this;
    }

    public SelenideElement getSearchField() {
        return searchField.shouldBe(clickable, Duration.ofSeconds(5));
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
        SelenideElement resultElement = $(By.xpath("//a[contains(@title, '" + vacancyName + "')]"));
        resultElement.shouldBe(clickable, Duration.ofSeconds(10));
        return this;
    }
}