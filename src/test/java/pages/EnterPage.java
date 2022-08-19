package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnterPage {
    private final SelenideElement buttonChangeLanguage =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[1]"));

    private final SelenideElement signInButton =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[2]"));

    private final SelenideElement newCustomerButton =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[3]"));

    private final SelenideElement supportButton =
            $(AppiumBy.xpath("(//*[@class='android.widget.Button'])[4]"));
    private final SelenideElement updateOKButton =
            $(AppiumBy.xpath("(//android.widget.Button)[2]"));

    @Step("Verify that Enter page is open")
    public EnterPage verifyIfWelcomePageIsOpen() {
        assertTrue(buttonChangeLanguage.isDisplayed());

        return this;
    }

    @Step("Click button \"OK\"")
    public EnterPage clickOkButton() {
        updateOKButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return this;
    }

    @Step("Click button \"Support\"")
    public SupportPage clickSupportButton() {
        supportButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new SupportPage();
    }

    @Step("Click button \"Sign In\"")
    public SingInPage clickSigInButton() {
        signInButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new SingInPage();
    }
    @Step("Click button \"Choose your language\"")
    public ChooseLanguagePage clickButtonChangeLanguage() {
        buttonChangeLanguage.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new ChooseLanguagePage();
    }
    @Step("Verify that language was changed to Russian")
    public EnterPage verifyIfLanguageChangedToSelected(String changeLanguageText, String signInText, String newCustomerText, String supportText) {
        SoftAssertions softAssertions = new SoftAssertions();
        buttonChangeLanguage.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout));

        softAssertions.assertThat(buttonChangeLanguage.getText().trim()).isEqualTo(changeLanguageText);
        softAssertions.assertThat(signInButton.getText().trim()).isEqualTo(signInText);
        softAssertions.assertThat(newCustomerButton.getText().trim()).isEqualTo(newCustomerText);
        softAssertions.assertThat(supportButton.getText().trim()).isEqualTo(supportText);

        softAssertions.assertAll();
        return this;
    }

}
