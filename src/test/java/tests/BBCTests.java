package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.EnterPage;

@DisplayName("Language tests")
public class BBCTests extends BaseTest {
    EnterPage welcomePage = new EnterPage();
    @DisplayName("Change language to Russian test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @CsvSource({
            "Russian, Русский, Вход, Регистрация, Поддержка",
            "English, English, Sign In, New Customer, Support",
            "German, Deutsch, Einloggen, Anmeldung, Hilfe",
            "French, Français, Se connecter, Inscription, Soutien"} )
    void searchTest(String language, String changeLanguageText, String sigInText, String newCustomerText, String supportText) {
    welcomePage
            .clickOkButton()
            .verifyIfWelcomePageIsOpen()
            .clickButtonChangeLanguage()
            .verifyIfChooseLanguagePageIsOpen()
            .selectLanguage(language)
            .clickDoneButton()
            .verifyIfWelcomePageIsOpen()
            .verifyIfLanguageChangedToSelected(changeLanguageText, sigInText, newCustomerText, supportText);
    }
}
