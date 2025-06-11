package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PublicationsPageAnchor {

    public void checkPublicationsAnchorTextTest(String expectedText) {
        $(By.xpath("//span[text()=  '" + expectedText + "']")).shouldHave(text(expectedText));
    }

    public SelenideElement getPublicationsButton() {
        return $(By.xpath("//span[text()='Все направления']")).shouldBe(clickable, Duration.ofSeconds(5));
    }

    public void clickOnPublicationsButton() {
        getPublicationsButton().click();
    }
    public SelenideElement getPublicationsButtonWithSearchingDirection(String direction) {
        return $(By.xpath("//span[text()='" + direction + "']")).shouldBe(clickable, Duration.ofSeconds(5));
    }

    public void checkPublicationsButtonWithSearchingDirection(String direction)
    {
        getPublicationsButtonWithSearchingDirection(direction);
    }
    public void clickOnPublicationsButtonWithSearchingPublication(String direction) {
        getPublicationsButtonWithSearchingDirection(direction).click();
    }

    public void checkAmountOfPublications() {
        SelenideElement publicationsCountElement = $(By.xpath("//h1[text()='Публикации']/following-sibling::span"));
        String publicationsCountText = publicationsCountElement.getText();
        int publicationsCount = Integer.parseInt(publicationsCountText);
        Assertions.assertTrue(publicationsCount > 0, "Количество публикаций должно быть больше нуля");
    }
}
