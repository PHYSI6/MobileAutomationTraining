package tests;

import config.Configurator;
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
                .inputTextIntoSearchField(Configurator.AppSettings.user.country)
                .selectSearchedCountry(Configurator.AppSettings.user.country)
                .verifyIfSignPageIsOpen()
                .verifyIfPhoneCodeCorrect(Configurator.AppSettings.user.phoneCode)
                .clickPhoneNumberField()
                .inputPhoneNumber(Configurator.AppSettings.user.phoneNumber)
                .clickSignIn();
    }
}
