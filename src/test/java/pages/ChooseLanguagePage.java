package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.Configurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseLanguagePage {
    private final SelenideElement doneButton =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[last()]"))
                    .shouldBe(Condition.enabled, Duration.ofSeconds(Configurator.AppSettings.appConfig.waitTimeout));

    @Step("Verify that Choose Language page is open")
    public ChooseLanguagePage verifyIfChooseLanguagePageIsOpen(){
        assertTrue(doneButton.isDisplayed());

        return this;
    }

    @Step("Select \"{0}\" language")
    public ChooseLanguagePage selectLanguage(String language){
        SelenideElement elem = $(By.xpath("//android.widget.RadioButton[contains(@text,'" +  language + "')]"));

        elem.click();
        return this;
    }

    @Step("Click \"Done\"")
    public EnterPage clickDoneButton(){
        doneButton.click();

        return new EnterPage();
    }
}