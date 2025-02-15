package functionalities.ads.search;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

import java.util.List;

import static test_data.Constants.SORT_BY_ASC;
import static test_data.Constants.SORT_BY_DESC;
import static test_data.TestData.CorrectTestData.CORRECT_NAME;

public class PositiveTest extends BaseTest {

    @Story("Поиск объявления")
    @Description("Тест-кейс 1: Поиск объявления по валидному названию")
    @Test
    public void checkAdSearchByName() {
        new MainPage()
                .openPage()
                .searchAd(CORRECT_NAME);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 2: Поиск объявления по названию в верхнем регистре")
    @Test
    public void checkAdSearchByNameToUpperCase() {
        new MainPage()
                .openPage()
                .searchAd(CORRECT_NAME.toUpperCase());
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 3: Поиск объявления по названию в нижнем регистре")
    @Test
    public void checkAdSearchByNameToLowerCase() {
        new MainPage()
                .openPage()
                .searchAd(CORRECT_NAME.toLowerCase());
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 4: Проверка работы фильтра отображения определенного количества товаров на странице")
    @ParameterizedTest
    @CsvSource({
            "0, 5",
            "1, 10",
            "2, 15",
            "3,20",
            "4,25"
    })
    public void checkIsCorrectNumbersOfItemsDisplayed(int input, int expected) {
        new MainPage()
                .openPage()
                .clickItemsOnPage()
                .selectNumberOfItems(input)
                .checkAmountOfItems(expected);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 5: Проверка работы фильтра сортировки товаров по возрастанию цены")
    @Test
    public void sortItemsByAscPrice() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByPrice()
                .clickOrderMenu()
                .clickFilterByAsc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsPrices();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsPrices(SORT_BY_ASC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 6: Проверка работы фильтра сортировки товаров по убыванию цены")
    @Test
    public void sortItemsByDescPrice() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByPrice()
                .clickOrderMenu()
                .clickFilterByDesc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsPrices();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsPrices(SORT_BY_DESC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 7: Проверка работы фильтра сортировки товаров по возрастанию просмотров")
    @Test
    public void sortItemsByAscViews() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByViews()
                .clickOrderMenu()
                .clickFilterByAsc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsViews();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsViews(SORT_BY_ASC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 8: Проверка работы фильтра сортировки товаров по убыванию просмотров")
    @Test
    public void sortItemsByDescViews() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByViews()
                .clickOrderMenu()
                .clickFilterByDesc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsViews();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsViews(SORT_BY_DESC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 9: Проверка работы фильтра сортировки товаров по возрастанию лайков")
    @Test
    public void sortItemsByAscLikes() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByLikes()
                .clickOrderMenu()
                .clickFilterByAsc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsLikes();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsLikes(SORT_BY_ASC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

    @Story("Поиск объявления")
    @Description("Тест-кейс 10: Проверка работы фильтра сортировки товаров по убыванию лайков")
    @Test
    public void sortItemsByDescLikes() {
        MainPage mainPage = new MainPage();
        mainPage
                .openPage()
                .clickParametersMenu()
                .clickFilterByLikes()
                .clickOrderMenu()
                .clickFilterByDesc();

        List<String> actualSortedListOfItems = mainPage.getActualListOfItemsLikes();
        List<String> expectedSortedListOfItems = mainPage.getExpectedListOfItemsLikes(SORT_BY_DESC);

        Assertions.assertEquals(actualSortedListOfItems, expectedSortedListOfItems);
    }

}
