package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import drivers.LocalMobileDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfirmationPage {
    private final SelenideElement confirmationTitle =
            $(AppiumBy.xpath("//android.view.View[@text='Confirmation']"));
    private final SelenideElement background =
            $(AppiumBy.xpath("//*[@resource-id='background-content']"));
    private final SelenideElement inputField =
            $(AppiumBy.xpath("//android.view.View[3]/android.view.View[1]/android.view.View"));

    @Step("Verify that Confirmation page is open")
    public ConfirmationPage verifyConfirmationPageIsOpen() {
        assertTrue(confirmationTitle.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Enter one-time password")
    public EnterPinPage enterOneTimePassword(String password) {
        Map<Character, AndroidKey> mapKeys = Map.of
                       ('0', AndroidKey.DIGIT_0,
                        '1', AndroidKey.DIGIT_1,
                        '2', AndroidKey.DIGIT_2,
                        '3', AndroidKey.DIGIT_3,
                        '4', AndroidKey.DIGIT_4,
                        '5', AndroidKey.DIGIT_5,
                        '6', AndroidKey.DIGIT_6,
                        '7', AndroidKey.DIGIT_7,
                        '8', AndroidKey.DIGIT_8,
                        '9', AndroidKey.DIGIT_9
                );

        for(int i = 0;i < password.length(); i++){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                LocalMobileDriver.getDriver().pressKey(new KeyEvent(mapKeys.get(password.charAt(i))));
            }
        }

        return new EnterPinPage();
    }
}
