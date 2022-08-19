package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.EnterPage;

@DisplayName("Language tests")
public class LanguageTests extends BaseTest {
    EnterPage enterPage = new EnterPage();
    @DisplayName("Change language in Enter page test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @CsvSource({
            "Russian, Русский, Вход, Регистрация, Поддержка",
            "English, English, Sign In, New Customer, Support",
            "German, Deutsch, Einloggen, Anmeldung, Hilfe",
            "Turkish, Türkçe, Oturum Aç, Yeni Müşteri, Destek",
            "French, Français, Se connecter, Inscription, Soutien"} )
    void languageInEnterPageTest(String language, String changeLanguageText, String sigInText, String newCustomerText, String supportText) {
    enterPage
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
