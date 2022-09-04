package pages.apps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewCustomerPage {
    private final SelenideElement title =
            $(AppiumBy.xpath("//android.view.View[@content-desc='localhost']"));

    private final SelenideElement text =
            $(AppiumBy.xpath("(//android.view.View[@content-desc='localhost']/ following-sibling::android.view.View)[3]"));

    @Step("Verify that New Customer page is open")
    public NewCustomerPage verifyIfNewCustomerPageIsOpen(){
        assertTrue(title.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }

    @Step("Verify that text of the page is correct")
    public NewCustomerPage verifyIfTextOfPageIsCorrect(){
        assertEquals("This document contains basic pre-contractual information (Pre-contractual information) on the " +
                "services provided by us and how to conclude an agreement between you and us governing the possession and use " +
                "of the prepaid Mastercard cards issued by us, and the Account opened by us.",
                text.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).getText());

        return this;
    }
}
