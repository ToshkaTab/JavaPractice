package com.fit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String str =  new String("ТексТ текст. окно; на распашку дверь была открыта\n" +
                "ii init\n" +
                "Небо абракадабра");
        System.out.println(str);
        System.out.println();
        System.out.println("Найденные слова: ");
        print(split(str));
    }
    public static void inByConsole()
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(str);
        System.out.println();
        System.out.println("Найденные слова: ");
        print(split(str));
    }
    public static String[] split(String str)
    {
        return str.split("\\.| |\\,|\\:|\\;|\\n|\\t");
    }
    public static void print(String[] arr)
    {
        for(String word : arr)
        {
            if(word.length() <= 0) continue;
            if(word.charAt(0) == word.charAt(word.length()-1)) {
                System.out.println(word);
            }
        }
    }
}
