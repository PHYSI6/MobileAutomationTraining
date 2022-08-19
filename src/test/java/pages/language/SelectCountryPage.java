package pages.language;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pages.login.SingInPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectCountryPage {
    private final SelenideElement searchField =
            $(AppiumBy.xpath("(//android.widget.EditText)[3]"));

    @Step("Click field \"Search\"")
    public SelectCountryPage clickSearchField() {
        searchField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return this;
    }

    @Step("Select \"{0}\"")
    public SingInPage selectSearchedCountry(String text ) {
        $(AppiumBy.xpath("//android.view.View[@text='" + text + "']"))
                .shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();

        return new SingInPage();
    }

    @Step("Verify that Select Country page is open")
    public SelectCountryPage verifySelectCountryPageIsOpen() {
        assertTrue(searchField.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout))
                .isDisplayed());

        return this;
    }

    @Step("Input text  {0} into field \"Search\"")
    public SelectCountryPage inputTextIntoSearchField(String text) {
        searchField.sendKeys(text);

        return this;
    }
}