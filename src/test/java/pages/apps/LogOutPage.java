package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogOutPage {
    private final SelenideElement logOutConfirm =
            $(AppiumBy.xpath("(//android.view.View/android.view.View[4]/android.widget.Button)[2]"));

    @Step("Verify that Log Out page is open")
    public LogOutPage verifyLogOutPageIsOpen() {
        assertTrue(logOutConfirm.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Confirm \"Log Out\"")
    public EnterPage confirmLogOut() {
        logOutConfirm.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new EnterPage();
    }
}
