package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.JsSnippetsUtils.removeBanners;

public class MainPage {
    private final SelenideElement aboutLink = $(By.xpath("//span[contains(text(),'О нас')]"));
    private final SelenideElement technologiesLink = $(By.xpath("//span[contains(text(), 'Технологии и решения')]"));
    private final SelenideElement publicationsLink = $(By.xpath("//span[contains(text(), 'Публикации')]"));
    private final SelenideElement searchFieldLink = $(By.xpath("//input[@placeholder='Поиск']"));

    public static MainPage openPage() {
        open("https://x5.tech");
        removeBanners();
        return new MainPage();
    }

    public MainPage mainStructureElementsExist() {
        $("div#page").shouldBe(exist);
        $("div.overflow-x-clip").shouldBe(exist);
        return this;
    }

    public AboutUsPage clickAboutUs() {
        aboutLink.shouldBe(exist).click();
        return new AboutUsPage();
    }

    public PublicationsPage clickPublications() {
        publicationsLink.shouldBe(exist).click();
        return new PublicationsPage();
    }

    public TechnologiesPage clickTechnologies() {
        technologiesLink.shouldBe(exist).click();
        return new TechnologiesPage();
    }

    public SearchField clickSearch() {
        searchFieldLink.shouldBe(exist).click();
        return new SearchField();
    }

    public MainPage verifyContactEmailExists(String expectedEmail) {
        $(By.xpath("//footer//a[contains(@href, 'mailto:') and contains(text(), '" + expectedEmail + "')]"))
                .shouldBe(visible).shouldHave(attribute("href", "mailto:" + expectedEmail));
        return this;
    }

}