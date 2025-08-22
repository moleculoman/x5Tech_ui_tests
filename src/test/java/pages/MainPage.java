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
    private final SelenideElement pageDiv = $("div#page");
    private final SelenideElement overflowDiv = $("div.overflow-x-clip");
    private final SelenideElement footer = $("footer");

    public static MainPage openPage() {
        MainPage page = open("https://x5.tech  ", MainPage.class);
        removeBanners();
        return page;
    }

    public MainPage mainStructureElementsExist() {
        pageDiv.shouldBe(exist);
        overflowDiv.shouldBe(exist);
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
        SelenideElement emailLink = footer.find(By.xpath(".//a[contains(@href, 'mailto:') and contains(text(), '" + expectedEmail + "')]"));
        emailLink.shouldBe(visible).shouldHave(attribute("href", "mailto:" + expectedEmail));
        return this;
    }
}