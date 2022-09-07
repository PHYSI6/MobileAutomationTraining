package pages;

import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    public Duration waitTimeout =  Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout);
    public void checkPageIsOpened(){
       assertTrue(getPageIdentifier().isDisplayed());
    }
    protected abstract SelenideElement getPageIdentifier();
}
