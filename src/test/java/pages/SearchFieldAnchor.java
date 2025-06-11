package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchFieldAnchor {

    public void checkSearchFieldAnchorTextTest(String placeholderName) {
         $(By.xpath("//input[@placeholder=  '" + placeholderName + "']"))
                .shouldHave(attribute("placeholder", placeholderName));
    }

    public SelenideElement getSearchField() {
        return $(By.xpath("//input[@placeholder='Поиск']")).shouldBe(clickable, Duration.ofSeconds(5));
    }

    public SelenideElement clickOnSearchField() {
        SelenideElement element = getSearchField();
        element.click();
        return element;
    }

    public void setSearchFieldValue(String vacancyName) {
        clickOnSearchField()
                .setValue(vacancyName)
                .pressEnter();
    }

    public void checkResults (String vacancyName){
        $(By.xpath("//a[contains(@title, '" + vacancyName + "')]")).shouldBe(clickable, Duration.ofSeconds(5));
    }
}
