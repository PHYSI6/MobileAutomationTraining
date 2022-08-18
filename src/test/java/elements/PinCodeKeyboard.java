package elements;

import com.codeborne.selenide.Condition;
import config.configurators.JsonConfigurator;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class PinCodeKeyboard {

    public static void enterPinCode(String pin)
    {
        for(int i =0; i < pin.length(); i++){
            $(By.xpath("//android.widget.Button[@text='" + pin.charAt(i) + "']"))
                    .shouldBe(Condition.enabled, Duration.ofSeconds(JsonConfigurator.AppSettings.appConfig.waitTimeout)).click();
        }
    }
}
