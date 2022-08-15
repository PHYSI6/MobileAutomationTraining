package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.Configurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingInPage {
    private final SelenideElement selectCountry =
            $(AppiumBy.xpath("//android.view.View[@text = 'Select Country']"));
    private final SelenideElement phoneCode =
            $(AppiumBy.xpath("//*[@resource-id='LoginPage-phoneCodeInput']/android.widget.EditText"));
    private final SelenideElement singInButton =
            $(AppiumBy.xpath("(//android.widget.Button)[2]"));
    private final SelenideElement phoneNumberField =
            $(AppiumBy.xpath("//*[@resource-id='LoginPage-phoneTextInput']/android.widget.EditText"));


    @Step("Click field \"Select Country\"")
    public SelectCountryPage clickSelectCountry() {
        selectCountry.shouldBe(Condition.enabled, Duration.ofSeconds(Configurator.AppSettings.appConfig.waitTimeout)).click();

        return new SelectCountryPage();
    }

    @Step("Click phone number field")
    public SingInPage clickPhoneNumberField() {
        phoneNumberField.shouldBe(Condition.enabled, Duration.ofSeconds(Configurator.AppSettings.appConfig.waitTimeout)).click();

       return this;
    }

    @Step("Click  \"Sign In\" ")
    public SingInPage clickSignIn() {
        singInButton.shouldBe(Condition.enabled, Duration.ofSeconds(Configurator.AppSettings.appConfig.waitTimeout)).click();

        return this;
    }

    @Step("Input phone number {0}")
    public SingInPage inputPhoneNumber(String number) {
        phoneNumberField.sendKeys(number);

        return this;
    }
    @Step("Verify that SignIn page is open")
    public SingInPage verifyIfSignPageIsOpen() {
        assertTrue(singInButton.shouldBe(Condition.enabled, Duration.ofSeconds(Configurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }

    @Step("Verify that phone code is belong to the selected country")
    public SingInPage verifyIfPhoneCodeCorrect(String expectedCode) {
        assertEquals(expectedCode, phoneCode.getText());

        return this;
    }
}
