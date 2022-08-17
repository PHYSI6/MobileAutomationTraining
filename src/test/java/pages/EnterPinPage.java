package pages;

import com.codeborne.selenide.Condition;
import config.configurators.JsonConfigurator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EnterPinPage {

    @Step("Enter pin")
    public MoneyPage enterPin(String pin) {
        for(int i =0; i < pin.length(); i++){
            $(By.xpath("//android.widget.Button[@text='" + pin.charAt(i) + "']"))
                    .shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();
        }

        return new MoneyPage();
    }
}
