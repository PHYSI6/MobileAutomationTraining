package pages.support;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChatPage {
    private final SelenideElement chatInputField =
            $(AppiumBy.xpath("//*[@resource-id='chatInput']"));

    @Step("Verify that Chat page is open")
    public ChatPage verifyIfChatPageIsOpen() {
        assertTrue(chatInputField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed());

        return this;
    }
}
