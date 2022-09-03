package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsPage {
    private final SelenideElement personalInformationButton =
            $(AppiumBy.xpath("//android.view.View[1]/android.view.View[2]/android.widget.Button"));

    private final SelenideElement logOutButton =
            $(AppiumBy.xpath("//android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button"));

    private final SelenideElement settings =
            $(AppiumBy.xpath("//*[@resource-id='tab-button-profile']"));

    @Step("Verify that Settings page is open")
    public SettingsPage verifySettingsPageIsOpen() {
        assertTrue(settings.shouldBe(Condition.selected, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Click button \"Personal Info\"")
    public PersonalInfoPage clickPersonalInfoButton() {
        personalInformationButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new PersonalInfoPage();
    }

    @Step("Click button \"Log Out\"")
    public LogOutPage clickButtonLogOut() {
        logOutButton.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new LogOutPage();
    }
}
