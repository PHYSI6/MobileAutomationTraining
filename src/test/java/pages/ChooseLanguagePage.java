package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import drivers.LocalMobileDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseLanguagePage {
    private final SelenideElement doneButton =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[last()]"));

    @Step("Verify that Choose Language page is open")
    public ChooseLanguagePage verifyIfChooseLanguagePageIsOpen(){
        assertTrue(doneButton.isDisplayed());

        return this;
    }

    @Step("Select \"{0}\" language")
    public ChooseLanguagePage selectLanguage(String language){
        $(By.xpath("//android.widget.RadioButton[contains(@text,'" +  language + "')]"))
                .shouldBe(Condition.enabled, Duration.ofSeconds(AppConfig.DURATION_OF_WAITING)).click();

        return this;
    }

    @Step("Click \"Done\"")
    public EnterPage clickDoneButton(){
        doneButton.shouldBe(Condition.enabled, Duration.ofSeconds(AppConfig.DURATION_OF_WAITING)).click();

        return new EnterPage();
    }
}