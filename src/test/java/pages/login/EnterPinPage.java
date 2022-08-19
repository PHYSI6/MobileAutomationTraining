package pages.login;

import io.qameta.allure.Step;
import pages.apps.MoneyPage;

import static elements.PinCodeKeyboard.enterPinCode;

public class EnterPinPage {

    @Step("Enter pin")
    public MoneyPage enterPin(String pin) {
        enterPinCode(pin);

        return new MoneyPage();
    }
}
