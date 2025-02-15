package functionalities.ads.search;

import base_test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static test_data.TestData.CorrectTestData.CORRECT_NAME;
import static utils.TransliteratedValueGenerator.generateLatinText;

public class NegativeTest extends BaseTest {

    @Story("Поиск объявления")
    @Description("Тест-кейс 11: Поиск объявления по транслителированному названию")
    @Test
    public void checkAdSearchByTransliteratedName() {
        new MainPage()
                .openPage()
                .checkIsAdNotSearched(generateLatinText(CORRECT_NAME));
    }

}
