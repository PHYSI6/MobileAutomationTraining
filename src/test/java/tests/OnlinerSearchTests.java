package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.onliner.OnlinerMainPage;

@DisplayName("Onliner search tests")
public class OnlinerSearchTests extends BaseTest {
    OnlinerMainPage onlinerMainPage = new OnlinerMainPage();

    @DisplayName("Product search test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @ValueSource(strings = {"Iphone XR", "Macbook Pro"})
    public void searchTest(String productName){
        onlinerMainPage
                .open()
                .clickSearchField()
                .inputTextSearchField(productName)
                .checkFirstProductTitle(productName);
    }

    @DisplayName("Product search and navigation test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @ValueSource(strings = {"Macbook Pro", "Apple Watch"})
    public void productNavigationTest(String productName) {
        String productFullName = onlinerMainPage
                .open()
                .clickSearchField()
                .inputTextSearchField(productName).getFirstProductTitle();

        onlinerMainPage.clickFirstProduct().checkIfOpenedCorrectProduct(productFullName);
    }
}
