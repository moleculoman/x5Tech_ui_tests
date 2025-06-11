package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutUsPageAnchor {

    public void checkAboutUsAnchorText(String expectedText) {
        $(By.xpath("//span[contains(text(), '" + expectedText + "')]")).shouldHave(text(expectedText));
    }
    public void checkAboutSearchingText(String jobCondition) {
        $$("button:nth-child(6)")
                .findBy(text(jobCondition))
                .shouldBe(visible).scrollTo()
                .shouldHave(text(jobCondition));
    }

}
