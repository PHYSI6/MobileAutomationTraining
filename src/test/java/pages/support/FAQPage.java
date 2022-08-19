package pages.support;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.configurators.JsonConfigurator;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FAQPage {
    private final SelenideElement faqTitle =
            $(AppiumBy.xpath("(//*[@content-desc='localhost']/following-sibling::android.view.View)[1]"));

    @Step("Verify that FAQ page is open")
    public FAQPage verifyIfFAQPageIsOpen() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(faqTitle.shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).isDisplayed()).isTrue();
        softAssertions.assertThat(faqTitle.getText()).isEqualTo("FAQ");

        softAssertions.assertAll();
        return this;
    }
}
