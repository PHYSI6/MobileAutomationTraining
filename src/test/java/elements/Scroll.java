package elements;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

public class Scroll {

    public static void horizontalScrollToElement(String text, WebDriver driver){
         driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

    }
}
