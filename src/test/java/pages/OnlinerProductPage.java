package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerProductPage extends BasePage{
    private final SelenideElement productTitle = $(".catalog-masthead__title");
    @Override
    protected SelenideElement getPageIdentifier() {
        return productTitle;
    }

    @Step("Check if opened correct product")
    public OnlinerProductPage checkIfOpenedCorrectProduct(String expectedProductTitle){
        assertEquals(expectedProductTitle, productTitle.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).getText(), "Was opened wrong product!");

        return this;
    }
}
