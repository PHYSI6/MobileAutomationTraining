package tests;

import config.configurators.JsonConfigurator;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.apps.EnterPage;

@DisplayName("Settings tests")
public class SettingsTests extends BaseTest {
    EnterPage enterPage = new EnterPage();
    @DisplayName("Log Out test")
    @Owner("Daniil Borisevich")
    @Test
    void logOutTest() {
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
                .verifyMoneyPageIsOpen()
                .clickSettings()
                .verifySettingsPageIsOpen()
                .clickButtonLogOut()
                .verifyLogOutPageIsOpen()
                .confirmLogOut()
                .verifyIfWelcomePageIsOpen();
    }

    @DisplayName("Personal info test")
    @Owner("Daniil Borisevich")
    @Test
    void personalInfoTest() {
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
                .verifyMoneyPageIsOpen()
                .clickSettings()
                .clickPersonalInfoButton()
                .verifyPersonalInfoPageIsOpen()
                .verifyPersonalInfoIsCorrect(JsonConfigurator.AppSettings.user.phoneNumber);
    }
}
