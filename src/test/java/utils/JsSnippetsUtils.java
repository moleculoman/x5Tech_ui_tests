package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippetsUtils {
    public static void removeBanners() {
        executeJavaScript("document.querySelector('body > div.overflow-x-clip > div > section > div').remove();");
    }
}
