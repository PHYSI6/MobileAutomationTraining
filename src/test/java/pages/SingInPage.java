package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingInPage {
    private final SelenideElement selectCountry =
            $(AppiumBy.xpath("(//android.view.View[2]/android.view.View[1])[5]"));
    private final SelenideElement phoneCode =
            $(AppiumBy.xpath("//*[@resource-id='LoginPage-phoneCodeInput']/android.widget.EditText"));
    private final SelenideElement singInButton =
            $(AppiumBy.xpath("(//android.widget.Button)[2]"));
    private final SelenideElement phoneNumberField =
            $(AppiumBy.xpath("//*[@resource-id='LoginPage-phoneTextInput']/android.widget.EditText"));

    private final SelenideElement phoneNumberFieldErrorMessage =
            $(AppiumBy.xpath("//*[@resource-id='LoginPage-phoneTextInput']/following-sibling::android.widget.TextView"));


    @Step("Click field \"Select Country\"")
    public SelectCountryPage clickSelectCountry() {
        selectCountry.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new SelectCountryPage();
    }

    @Step("Click phone number field")
    public SingInPage clickPhoneNumberField() {
        phoneNumberField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return this;
    }

    @Step("Click  \"Sign In\" ")
    public ConfirmationPage clickSignIn() {
        singInButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new ConfirmationPage();
    }

    @Step("Click  \"Sign In\" ")
    public SingInPage clickSignIn(boolean status) {
        singInButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return this;
    }

    @Step("Input phone number {0}")
    public SingInPage inputPhoneNumber(String number) {
        phoneNumberField.sendKeys(number);

        return this;
    }
    @Step("Verify that SignIn page is open")
    public SingInPage verifyIfSignPageIsOpen() {
        assertTrue(phoneNumberField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }

    @Step("Verify that phone code is belong to the selected country")
    public SingInPage verifyIfPhoneCodeCorrect(String expectedCode) {
        assertEquals(expectedCode, phoneCode.getText());

        return this;
    }

    @Step("Verify that phone filed have an error message")
    public SingInPage verifyIfPhoneFieldHaveErrorMessage() {
        assertTrue(phoneNumberField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }
}