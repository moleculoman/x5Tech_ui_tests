package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PublicationsPage {
    public PublicationsPage checkPublicationsAnchorTextTest(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]")).shouldHave(text(expectedText));
        return this;
    }

    public SelenideElement getPublicationsButton() {
        return $(By.xpath("//span[text()='Все направления']")).shouldBe(clickable, Duration.ofSeconds(5));
    }

    public PublicationsPage clickOnPublicationsButton() {
        getPublicationsButton().shouldBe(clickable).click();
        return this;
    }

    public SelenideElement getPublicationsButtonWithSearchingDirection(String direction) {
        return $(By.xpath("//span[contains(text(), '" + direction + "')]"));
    }

    public PublicationsPage checkPublicationsButtonWithSearchingDirection(String direction) {
        SelenideElement button = getPublicationsButtonWithSearchingDirection(direction);
        button.shouldBe(visible, clickable).shouldHave(text(direction));
        return this;
    }

    public PublicationsPage clickOnPublicationsButtonWithSearchingPublication(String direction) {
        SelenideElement button = getPublicationsButtonWithSearchingDirection(direction);
        button.click();
        return this;
    }

    public PublicationsPage checkAmountOfPublications() {
        SelenideElement publicationsCountElement = $(By.xpath("//h1[text()='Публикации']/following-sibling::span"));
        String publicationsCountText = publicationsCountElement.getText();
        int publicationsCount = Integer.parseInt(publicationsCountText);
        Assertions.assertTrue(publicationsCount > 0, "Количество публикаций должно быть больше нуля");
        return this;
    }
}