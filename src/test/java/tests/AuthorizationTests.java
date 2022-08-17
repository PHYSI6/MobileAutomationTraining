package tests;

import config.configurators.JsonConfigurator;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.EnterPage;

@DisplayName("Authorization tests")
public class AuthorizationTests extends BaseTest{

    EnterPage welcomePage = new EnterPage();
    @DisplayName("Authorization with correct data test")
    @Owner("Daniil Borisevich")
    @Test
    void authorizationWithCorrectDataTest() {
        welcomePage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSigInButton()
                .verifyIfSignPageIsOpen()
                .clickSelectCountry()
                .verifySelectCountryPageIsOpen()
                .clickSearchField()
                .inputTextIntoSearchField(JsonConfigurator.AppSettings.user.country)
                .selectSearchedCountry(JsonConfigurator.AppSettings.user.country)
                .verifyIfSignPageIsOpen()
                .verifyIfPhoneCodeCorrect(JsonConfigurator.AppSettings.user.phoneCode)
                .clickPhoneNumberField()
                .inputPhoneNumber(JsonConfigurator.AppSettings.user.phoneNumber)
                .clickSignIn()
                .verifyConfirmationPageIsOpen()
                .enterOneTimePassword(JsonConfigurator.AppSettings.user.code)
                .enterPin(JsonConfigurator.AppSettings.user.code)
                .verifyMoneyPageIsOpen();
    }
}
