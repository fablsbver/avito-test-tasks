package utils;

import com.ibm.icu.text.Transliterator;

public class TransliteratedValueGenerator {

    public static String generateLatinText(String text) {
        Transliterator transliterator = Transliterator.getInstance("Cyrillic-Latin");
        return transliterator.transliterate(text);

    }
}
