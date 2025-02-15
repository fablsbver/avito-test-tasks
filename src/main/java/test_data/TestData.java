package test_data;

import static utils.RandomValueGenerator.*;

public class TestData {

    public static class CorrectTestData {
        public static final String CORRECT_NAME = "Плитка керамическая";
        public static final String CORRECT_PRICE = "750";
        public static final String CORRECT_DESCRIPTION = "Керамическая плитка для ванной в ассортименте, доставка по всей России, продажа от 20м2";
        public static final String CORRECT_IMG_URL = "https://azoriceramica.ru/upload/resize_cache/iblock/f20/420_374_2/t8a1zgkzynobzdfjwkuxvijjypn9cbhq.jpg";
    }

    public static class EditTestData {
        public static final String EDIT_NAME = "Плитка керамическая новая";
        public static final String EDIT_PRICE = "900 ₽";
        public static final String EDIT_DESCRIPTION = "Керамическая плитка для ванной в ассортименте, только самовывоз, продажа от 20м2";
        public static final String EDIT_IMG_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTauz6vfjXAAhigh2iJNykPCxi-i1KMI_kvgg&s";
    }

    public static class IncorrectTestData {
        public static final String TOO_LONG_NAME = generateRandomLongName();
        public static final String TOO_LONG_PRICE = generateRandomLongPrice();
        public static final String TOO_LONG_DESCRIPTION = generateRandomLongDescription();

        public static final String TOO_SHORT_NAME = generateRandomShortName();
        public static final String TOO_SHORT_DESCRIPTION = generateRandomShortDescription();

        public static final String PRICE_OF_LETTERS_AND_NUMBERS = generatePriceOfLettersAdnNumbers();
        public static final String PRICE_OF_LETTERS = generatePriceOfLetters();
        public static final String PRICE_WITH_NEGATIVE_VALUE = "-20000";

        public static final String IMG_URL_OF_RANDOM_LETTERS = generateImageUrlOfRandomLetters();
        public static final String IMG_URL_OF_LARGE_FORMAT = "https://img.freepik.com/free-photo/plaid-chalkboard-texture_23-2147664204.jpg?t=st=1739473121~exp=1739476721~hmac=742bbe55b4c3d7c55f4b1a2436900aeb8162bc5191b2ebee8e46a3c82d964a16&w=996";

        public static final String SQL_INJECTION_VALUE = "' OR '1'='1' -- ";
        public static final String XSS_SCRIPT_VALUE = "<script>alert('XSS')</script>";

    }

    public static class ErrorMessages {
        public static final String FIELD_MUST_BE_FILLED_IN_ERROR_MESSAGE = "Поле обязательно для заполнения.";
    }

}
