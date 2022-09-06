package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerCatalogPage extends BasePage{
    private final SelenideElement catalogNavigationTitle = $(".catalog-navigation > .catalog-navigation__title");
    private final SelenideElement onlinerLogo = $(".b-top-logo");
    @Override
    protected SelenideElement getPageIdentifier() {
        return catalogNavigationTitle;
    }

    @Step("Click main onliner icon")
    public OnlinerMainPage clickOnlinerIcon(){
        onlinerLogo.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new OnlinerMainPage();
    }

    @Step("Check if Catalog page is opened")
    public OnlinerCatalogPage checkIfCatalogPageIsOpen(){
        checkPageIsOpened();
        assertEquals("КаталогВсе суперцены!", catalogNavigationTitle.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).getText());
        return this;
    }
}
