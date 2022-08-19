package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyPage {
    private final SelenideElement buttonHome =
            $(AppiumBy.xpath("//*[@resource-id='tab-button-home']"));

    @Step("Verify that Money page is open")
    public MoneyPage verifyMoneyPageIsOpen() {
        assertTrue(buttonHome.shouldBe(Condition.selected, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }
}
