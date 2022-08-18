package pages;

import io.qameta.allure.Step;

import static elements.PinCodeKeyboard.enterPinCode;

public class EnterPinPage {

    @Step("Enter pin")
    public MoneyPage enterPin(String pin) {
        enterPinCode(pin);

        return new MoneyPage();
    }
}
