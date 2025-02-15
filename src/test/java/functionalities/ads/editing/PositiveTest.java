package functionalities.ads.editing;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.AdPage;
import pages.MainPage;

import static test_data.TestData.CorrectTestData.CORRECT_NAME;
import static test_data.TestData.EditTestData.*;

public class PositiveTest extends BaseTest {

    @Story("Редактирование объявления")
    @Description("Тест-кейс 1: Редактирование объявления с добавлением валидных значений")
    @Test
    public void editAdWithCorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editImageUrl(EDIT_IMG_URL)
                .editName(EDIT_NAME)
                .editPrice(EDIT_PRICE)
                .editDescription(EDIT_DESCRIPTION)
                .clickSaveAd()
                .checkIsImgUrlIsEdited(EDIT_IMG_URL)
                .checkIsNameIsEdited(EDIT_NAME)
                .checkIsPriceIsEdited(EDIT_PRICE)
                .checkIsDescriptionIsEdited(EDIT_DESCRIPTION);

    }
}
