package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    public void checkPageIsOpened(){
       assertTrue(getPageIdentifier().shouldBe(Condition.enabled,  Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout/3)).isDisplayed());
    }
    protected abstract SelenideElement getPageIdentifier();
}
