package utils;


import org.apache.commons.lang3.RandomStringUtils;

public class RandomValueGenerator {

    public static final int MAX_POSSIBLE_NAME_FIELD_LIMITATION = 51;
    public static final int MAX_POSSIBLE_PRICE_FIELD_LIMITATION = 21;
    public static final int MAX_POSSIBLE_DESCRIPTION_FIELD_LIMITATION = 2001;
    public static final int MIN_POSSIBLE_NAME_FIELD_LIMITATION = 1;
    public static final int MIN_POSSIBLE_DESCRIPTION_FIELD_LIMITATION = 1;
    public static final int REGULAR_PRICE_FIELD_SIZE = 1000;
    public static final int REGULAR_IMAGE_URL_FIELD_SIZE = 30;
    public static final String CYRILLIC_LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String LATIN_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String generateRandomLetter() {
        return String.valueOf(RandomStringUtils.random(1, CYRILLIC_LETTERS + LATIN_LETTERS).charAt(0));
    }

    public static String generateRandomLongName() {
        return RandomStringUtils.randomAlphabetic(MAX_POSSIBLE_NAME_FIELD_LIMITATION);
    }

    public static String generateRandomLongPrice() {
        return RandomStringUtils.randomNumeric(MAX_POSSIBLE_PRICE_FIELD_LIMITATION);
    }

    public static String generateRandomLongDescription() {
        return RandomStringUtils.randomAlphabetic(MAX_POSSIBLE_DESCRIPTION_FIELD_LIMITATION);
    }

    public static String generateRandomShortName() {
        return RandomStringUtils.randomAlphabetic(MIN_POSSIBLE_NAME_FIELD_LIMITATION);
    }

    public static String generateRandomShortDescription() {
        return RandomStringUtils.randomAlphabetic(MIN_POSSIBLE_DESCRIPTION_FIELD_LIMITATION);
    }

    public static String generatePriceOfLettersAdnNumbers() {
        return RandomStringUtils.randomAlphanumeric(REGULAR_PRICE_FIELD_SIZE);
    }

    public static String generatePriceOfLetters() {
        return RandomStringUtils.randomAlphabetic(REGULAR_PRICE_FIELD_SIZE);
    }

    public static String generateImageUrlOfRandomLetters() {
        return RandomStringUtils.randomAlphabetic(REGULAR_IMAGE_URL_FIELD_SIZE);
    }
}

