package functionalities.ads.creating;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.CreateAdModal;
import pages.MainPage;

import static test_data.TestData.CorrectTestData.*;

public class PositiveTest extends BaseTest {
    @Story("Создание объявления")
    @Description("Тест-кейс 1: Создание объявления с валидными данными")
    @Test
    public void createAdWithCorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .fillAdForm(CORRECT_NAME, CORRECT_PRICE, CORRECT_DESCRIPTION, CORRECT_IMG_URL)
                .clickSubmit();
        mainPage
                .searchAd(CORRECT_NAME);
    }
}
