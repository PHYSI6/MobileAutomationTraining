package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalInfoPage {
    private final SelenideElement phoneNumberField =
            $(AppiumBy.xpath("//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View"));

    @Step("Verify that Personal Info page is open")
    public PersonalInfoPage verifyPersonalInfoPageIsOpen() {
        assertTrue(phoneNumberField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Verify that personal Info page is correct")
    public PersonalInfoPage verifyPersonalInfoIsCorrect(String phoneNumber) {

        phoneNumberField.shouldHave(Condition.have(Condition.text(phoneNumber)), Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout/2));
        return this;
    }
}
