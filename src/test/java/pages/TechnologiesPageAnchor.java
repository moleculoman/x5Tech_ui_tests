package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TechnologiesPageAnchor {

    public void checkTechnologiesPageAnchorText(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]")).shouldHave(text(expectedText));
    }

    public SelenideElement getMainSectionElement(String section) {
        return $(By.xpath("//div[@class='simplebar-content']//span[text()='" + section + "']"));
    }

    public void checkMainSection(String section) {
        getMainSectionElement(section).shouldHave(text(section));
    }

    public void clickOnMainSection(String section) {
        getMainSectionElement(section).click();
    }

    public SelenideElement getGeneralSubSectionElement(String generalSubSection) {
        return $(By.xpath("//label[contains(text(), '" + generalSubSection + "')]"));
    }

    public void checkGeneralSubSection(String generalSubSection) {
        getGeneralSubSectionElement(generalSubSection).shouldHave(text(generalSubSection));
    }

    public void clickOnGeneralSubSection(String generalSubSection) {
        getGeneralSubSectionElement(generalSubSection).click();
    }

    public SelenideElement getFirstSubSectionElement(String firstSubSection) {
        return $(By.xpath("//label[contains(text(), '" + firstSubSection + "')]"));
    }

    public void checkFirstSubSection(String firstSubSection) {
        getFirstSubSectionElement(firstSubSection).shouldHave(text(firstSubSection));
    }

    public void clickOnFirstSubSection(String firstSubSection) {
        getFirstSubSectionElement(firstSubSection).click();
    }

    public SelenideElement getSecondSubSectionElement(String secondSubSection) {
        return $(By.xpath("//label[contains(text(), '" + secondSubSection + "')]"));
    }

    public void checkSecondSubSection(String secondSubSection) {
        getSecondSubSectionElement(secondSubSection).shouldHave(text(secondSubSection));
    }

    public void clickOnSecondSubSection(String secondSubSection) {
        getSecondSubSectionElement(secondSubSection).click();
    }
}