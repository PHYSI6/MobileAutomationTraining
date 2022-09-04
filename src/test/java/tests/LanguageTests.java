package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.apps.EnterPage;

@DisplayName("Language tests")
public class LanguageTests extends BaseTest {
    EnterPage enterPage = new EnterPage();
    @DisplayName("Change language in Enter page test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @CsvSource({
            "Russian, Russian, Русский, Вход, Регистрация, Поддержка",
            "English, English, English, Sign In, New Customer, Support",
            "German, German, Deutsch, Einloggen, Anmeldung, Hilfe",
            "Turkish, Turkish, Türkçe, Oturum Aç, Yeni Müşteri, Destek",
            "French, French, Français, Se connecter, Inscription, Soutien",
            "Italian, Italian, Italiano, Accedi, Registrazione, Supporto",
            "Chinese, Chinese, 中文 , 登录, 新客户, 拥护",
            "Italian, Spanish, Español, Iniciar sesión, Registrar, Soporte"} )
    void languageInEnterPageTest(String languageToScroll,String language, String changeLanguageText, String sigInText, String newCustomerText, String supportText) {
    enterPage
            .clickOkButton()
            .verifyIfWelcomePageIsOpen()
            .clickButtonChangeLanguage()
            .verifyIfChooseLanguagePageIsOpen()
            .scrollToLanguage(languageToScroll)
            .selectLanguage(language)
            .clickDoneButton()
            .verifyIfWelcomePageIsOpen()
            .verifyIfLanguageChangedToSelected(changeLanguageText, sigInText, newCustomerText, supportText);
    }
}
