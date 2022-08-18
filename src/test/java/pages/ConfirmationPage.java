package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static elements.NumberKeyboard.enterNumber;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfirmationPage {
    private final SelenideElement confirmationTitle =
            $(AppiumBy.xpath("(//android.view.View[2]/android.view.View)[2]"));
    private final SelenideElement background =
            $(AppiumBy.xpath("//*[@resource-id='background-content']"));

    private final SelenideElement pinCodeErrorMessage =
            $(AppiumBy.xpath("(//android.view.View/android.view.View[5])[2]"));


    @Step("Verify that Confirmation page is open")
    public ConfirmationPage verifyConfirmationPageIsOpen() {
        assertTrue(confirmationTitle.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Enter one-time password")
    public EnterPinPage enterOneTimePassword(String number) {
        background.click();
        enterNumber(number);

        return new EnterPinPage();
    }

    @Step("Enter one-time password")
    public ConfirmationPage enterOneTimePassword(String number, boolean status) {
        background.click();
        enterNumber(number);

        return this;
    }


    @Step("Verify that pin code field have an error message")
    public ConfirmationPage verifyIfPinCodeFieldHaveErrorMessage() {
        assertTrue(pinCodeErrorMessage.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }
}
