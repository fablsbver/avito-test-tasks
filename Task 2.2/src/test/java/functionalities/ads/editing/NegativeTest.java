package functionalities.ads.editing;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.AdPage;
import pages.MainPage;

import static test_data.TestData.CorrectTestData.CORRECT_NAME;
import static test_data.TestData.IncorrectTestData.*;

public class NegativeTest extends BaseTest {

    @Story("Редактирование объявления")
    @Description("Тест-кейс 2: Редактирование объявления, удаление данных из всех полей")
    @Test
    public void editAdWithEmptyFields() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .deleteImageUrl()
                .deleteName()
                .deletePrice()
                .deleteDescription()
                .clickSaveAd();
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 3: Редактирование объявления с добавлением некорректного значения в поле \"Ссылка на изображение\"")
    @Test
    public void editImageUrlWithIncorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editImageUrl(IMG_URL_OF_RANDOM_LETTERS)
                .clickSaveAd()
                .checkIsImgUrlIsNotEdited(IMG_URL_OF_RANDOM_LETTERS);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 4: Редактирование объявления с добавлением некорректного значения в поле \"Название\"")
    @Test
    public void editNameWithIncorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editName(TOO_LONG_NAME)
                .clickSaveAd()
                .checkIsNameIsEdited(TOO_LONG_NAME);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 5: Редактирование объявления с добавлением некорректного значения в поле \"Цена\"")
    @Test
    public void editPriceWithIncorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editPrice(PRICE_WITH_NEGATIVE_VALUE)
                .clickSaveAd()
                .checkIsPriceIsNotEdited(PRICE_WITH_NEGATIVE_VALUE);
    }

    @Story("Редактирование объявления")
    @Description(" Тест-кейс 6: Редактирование объявления с добавлением некорректного значения в поле \"Описание")
    @Test
    public void editDescriptionWithIncorrectData() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editDescription(TOO_SHORT_DESCRIPTION)
                .clickSaveAd()
                .checkIsDescriptionIsNotEdited(TOO_SHORT_DESCRIPTION);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 7: Редактирование объявления с добавлением SQL скрипта в поле \"Ссылка на изображение\"")
    @Test
    public void checkImageUrlFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editImageUrl(SQL_INJECTION_VALUE)
                .clickSaveAd()
                .checkIsImgUrlIsNotEdited(SQL_INJECTION_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 8: Редактирование объявления с добавлением SQL скрипта в поле \"Название\"")
    @Test
    public void checkNameFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editName(SQL_INJECTION_VALUE)
                .clickSaveAd()
                .checkIsNameIsNotEdited(SQL_INJECTION_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 9: Редактирование объявления с добавлением SQL скрипта в поле \"Цена\"")
    @Test
    public void checkPriceFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editPrice(SQL_INJECTION_VALUE)
                .clickSaveAd()
                .checkIsPriceIsNotEdited(SQL_INJECTION_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 10: Редактирование объявления с добавлением SQL скрипта в поле \"Цена\"")
    @Test
    public void checkDescriptionFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editDescription(SQL_INJECTION_VALUE)
                .clickSaveAd()
                .checkIsDescriptionIsNotEdited(SQL_INJECTION_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 11: Редактирование объявления с добавлением XSS скрипта в поле \"Ссылка на изображение\"")
    @Test
    public void checkImageUrlFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editImageUrl(XSS_SCRIPT_VALUE)
                .clickSaveAd()
                .checkIsImgUrlIsNotEdited(XSS_SCRIPT_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 12: Редактирование объявления с добавлением XSS скрипта в поле \"Название\"")
    @Test
    public void checkNameFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editName(XSS_SCRIPT_VALUE)
                .clickSaveAd()
                .checkIsNameIsNotEdited(XSS_SCRIPT_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 13: Редактирование объявления с добавлением XSS скрипта в поле \"Цена\"")
    @Test
    public void checkPriceXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editPrice(XSS_SCRIPT_VALUE)
                .clickSaveAd()
                .checkIsPriceIsNotEdited(XSS_SCRIPT_VALUE);
    }

    @Story("Редактирование объявления")
    @Description("Тест-кейс 14: Редактирование объявления с добавлением XSS скрипта в поле \"Описание\"")
    @Test
    public void checkDescriptionFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();

        AdPage adPage = mainPage
                .searchAd(CORRECT_NAME)
                .clickOnAdCardForEditing();
        adPage
                .clickEdit()
                .editDescription(XSS_SCRIPT_VALUE)
                .clickSaveAd()
                .checkIsDescriptionIsNotEdited(XSS_SCRIPT_VALUE);
    }
}
