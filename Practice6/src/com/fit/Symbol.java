package com.fit;

public class Symbol {
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'а' || c == 'о' ||
                c == 'и' || c == 'е' ||
                c == 'ё' || c == 'э' ||
                c == 'ы' || c == 'у' ||
                c == 'ю' || c == 'я';
    }
}
