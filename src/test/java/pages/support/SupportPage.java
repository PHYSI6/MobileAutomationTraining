package pages.support;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SupportPage {
    private final SelenideElement faq =
            $(AppiumBy.xpath("//*[@text='FAQ']"));
    private final SelenideElement chat =
            $(AppiumBy.xpath("(//android.view.View[2]/android.view.View[2])[4]"));

    @Step("Verify that Support page is open")
    public SupportPage verifyIfWelcomePageIsOpen() {
        assertTrue(faq.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }

    @Step("Click button \"FAQ\"")
    public FAQPage clickFAQ() {
        faq.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new FAQPage();
    }

    @Step("Click button \"CHAT\"")
    public ChatPage clickChat() {
        chat.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new ChatPage();
    }
}

