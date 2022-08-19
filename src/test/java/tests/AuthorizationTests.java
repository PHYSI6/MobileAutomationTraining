package tests;

import config.configurators.JsonConfigurator;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.apps.EnterPage;

@DisplayName("Authorization tests")
public class AuthorizationTests extends BaseTest{

    EnterPage enterPage = new EnterPage();
    @DisplayName("Authorization with correct data test")
    @Owner("Daniil Borisevich")
    @Test
    void authorizationWithCorrectDataTest() {
        enterPage
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

    @DisplayName("Authorization with non-correct phone number test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @CsvSource({
            "1", "1234567890", "dddhhhbbbb", "$$$$$$$$$$"
            } )
    void authorizationWithNonCorrectPhoneNumberTest(String nonCorrectPassword) {
        enterPage
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
                .inputPhoneNumber(nonCorrectPassword)
                .clickSignInAndStayOnPage()
                .verifyIfPhoneFieldHaveErrorMessage()
                .verifyIfSignPageIsOpen();
    }

    @DisplayName("Authorization with empty data test")
    @Owner("Daniil Borisevich")
    @Test
    void authorizationWithEmptyData() {
        enterPage
                .clickOkButton()
                .verifyIfWelcomePageIsOpen()
                .clickSigInButton()
                .verifyIfSignPageIsOpen()
                .clickSignInAndStayOnPage()
                .verifyIfPhoneFieldHaveErrorMessage()
                .verifyIfSignPageIsOpen();
    }

    @DisplayName("Authorization with non-correct pin code test")
    @Owner("Daniil Borisevich")
    @Test
    void authorizationWithNonCorrectPinCodeTest() {
        enterPage
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
                .enterOneTimePasswordAndStayOnPage("111111")
                .verifyIfPinCodeFieldHaveErrorMessage()
                .verifyConfirmationPageIsOpen();
    }
}
