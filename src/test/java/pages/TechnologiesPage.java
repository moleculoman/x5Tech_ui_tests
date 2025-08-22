// pages/TechnologiesPage.java
package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TechnologiesPage {
        private final SelenideElement simplebarContent = $("div.simplebar-content");

        public TechnologiesPage checkTechnologiesPageAnchorText(String expectedText) {
            SelenideElement anchorElement = $(By.xpath("//span[contains(text(), '" + expectedText + "')]"));
            anchorElement.shouldHave(text(expectedText));
            return this;
        }

        public SelenideElement getMainSectionElement(String section) {
            return simplebarContent.find(By.xpath(".//span[text()='" + section + "']"));
        }

        public TechnologiesPage checkMainSection(String section) {
            getMainSectionElement(section).shouldHave(text(section));
            return this;
        }

        public TechnologiesPage clickOnMainSection(String section) {
            getMainSectionElement(section).click();
            return this;
        }

        public SelenideElement getGeneralSubSectionElement(String generalSubSection) {
            return $(By.xpath("//label[contains(text(), '" + generalSubSection + "')]"));
        }

        public TechnologiesPage checkGeneralSubSection(String generalSubSection) {
            getGeneralSubSectionElement(generalSubSection).shouldHave(text(generalSubSection));
            return this;
        }

        public TechnologiesPage clickOnGeneralSubSection(String generalSubSection) {
            getGeneralSubSectionElement(generalSubSection).click();
            return this;
        }

        public SelenideElement getFirstSubSectionElement(String firstSubSection) {
            return $(By.xpath("//label[contains(text(), '" + firstSubSection + "')]"));
        }

        public TechnologiesPage checkFirstSubSection(String firstSubSection) {
            getFirstSubSectionElement(firstSubSection).shouldHave(text(firstSubSection));
            return this;
        }

        public TechnologiesPage clickOnFirstSubSection(String firstSubSection) {
            getFirstSubSectionElement(firstSubSection).click();
            return this;
        }

        public SelenideElement getSecondSubSectionElement(String secondSubSection) {
            return $(By.xpath("//label[contains(text(), '" + secondSubSection + "')]"));
        }

        public TechnologiesPage checkSecondSubSection(String secondSubSection) {
            getSecondSubSectionElement(secondSubSection).shouldHave(text(secondSubSection));
            return this;
        }

        public TechnologiesPage clickOnSecondSubSection(String secondSubSection) {
            getSecondSubSectionElement(secondSubSection).click();
            return this;
        }
}