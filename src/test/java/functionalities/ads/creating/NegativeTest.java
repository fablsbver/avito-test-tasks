package functionalities.ads.creating;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.CreateAdModal;
import pages.MainPage;

import static test_data.TestData.CorrectTestData.*;
import static test_data.TestData.ErrorMessages.FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE;
import static test_data.TestData.IncorrectTestData.*;

public class NegativeTest extends BaseTest {

    @Story("Создание объявления")
    @Description("Тест-кейс 2: Создание объявления с пустыми полями")
    @Test
    public void createAdWithEmptyFields() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .clickSubmit()
                .checkErrorMessageExist(FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE);
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 3: Создание объявления с пустым полем \"Название\" ")
    @Test
    public void createAdWithEmptyNameField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkErrorMessageExist(FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE);
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 4: Создание объявления с пустым полем \"Цена\"")
    @Test
    public void createAdWithEmptyPriceField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkErrorMessageExist(FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE);
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 5: Создание объявления с пустым полем \"Описание\"")
    @Test
    public void createAdWithEmptyDescriptionField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkErrorMessageExist(FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE);
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 6: Создание объявления с пустым полем \"Ссылка на изображение\"")
    @Test
    public void createAdWithEmptyImageUlrField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .clickSubmit()
                .checkErrorMessageExist(FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE);
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 7: Проверка поле \"Название\" на уязвимость к SQL-injection")
    @Test
    public void checkNameFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(SQL_INJECTION_VALUE)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 8: Проверка поле \"Цена\" на уязвимость к SQL-injection")
    @Test
    public void checkPriceFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(SQL_INJECTION_VALUE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 9: Проверка поле \"Описание\" на уязвимость к SQL-injection")
    @Test
    public void checkDescriptionFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(SQL_INJECTION_VALUE)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 10: Проверка поле \"Ссылка на изображение\" на уязвимость к SQL-injection")
    @Test
    public void checkImageUrlFieldSQLInjectionVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(SQL_INJECTION_VALUE)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 11: Проверка поле \"Название\" на уязвимость к XSS скрипту")
    @Test
    public void checkNameFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(XSS_SCRIPT_VALUE)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 12: Проверка поле \"Цена\" на уязвимость к XSS скрипту")
    @Test
    public void checkPriceFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(XSS_SCRIPT_VALUE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 13: Проверка поле \"Описание\" на уязвимость к XSS скрипту")
    @Test
    public void checkDescriptionFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(XSS_SCRIPT_VALUE)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 14: Проверка поле \"Ссылка на изображение\" на уязвимость к XSS скрипту")
    @Test
    public void checkImageUrlFieldXSSScriptVulnerability() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();
        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(XSS_SCRIPT_VALUE)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 15: Создание объявления с названием, превышающим лимит поля \"Название\"")
    @Test
    public void checkTooManyCharactersEnterInNameField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(TOO_LONG_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("## Тест-кейс 16: Создание объявления с названием, которое меньше по количеству символов, допустимых для поля \"Название\"")
    @Test
    public void checkTooFewCharactersEnterInNameField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(TOO_SHORT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 17: Создание объявления с ценой, превышающим лимит поля \"Цена\"")
    @Test
    public void checkTooManyCharactersEnterInPriceField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(TOO_LONG_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 18: Создание объявления с отрицательным значением в поле \"Цена\"")
    @Test
    public void checkNegativeValueEnterInPriceField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(PRICE_WITH_NEGATIVE_VALUE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 19: Создание объявления с буквенным значением в поле \"Цена\" ")
    @Test
    public void checkLetterValueEnterInPriceField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(PRICE_OF_LETTERS)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 20: Создание объявления с буквенным и числовым значением в поле \"Цена\"")
    @Test
    public void checkLetterAndNumbersValueEnterInPriceField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(PRICE_OF_LETTERS_AND_NUMBERS)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 21: Создание объявления с описанием, превышающим лимит поля \"Описание\"")
    @Test
    public void checkTooManyCharactersEnterInDescriptionField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(TOO_LONG_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 22: Создание объявления с описанием, которое меньше по количеству символов, допустимых для поля \"Описание\"")
    @Test
    public void checkTooFewCharactersEnterInDescriptionField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(TOO_SHORT_DESCRIPTION)
                .enterImageUrl(CORRECT_IMG_URL)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("")
    @Test
    public void checkRandomLettersValueEnterInImgUrlField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(IMG_URL_OF_RANDOM_LETTERS)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }

    @Story("Создание объявления")
    @Description("Тест-кейс 24: Создание объявления с изображением, превышающим допустимое разрешение")
    @Test
    public void checkLinkToLargeImageEnterInImgUrlField() {
        MainPage mainPage = new MainPage()
                .openPage();
        CreateAdModal createAdModal = mainPage
                .clickCreate();

        createAdModal
                .enterName(CORRECT_NAME)
                .enterPrice(CORRECT_PRICE)
                .enterDescription(CORRECT_DESCRIPTION)
                .enterImageUrl(IMG_URL_OF_LARGE_FORMAT)
                .clickSubmit()
                .checkIsCreateModalInteractabal();
    }
}
