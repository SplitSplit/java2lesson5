package ru.ponomaryov.se.anagramm;

import java.util.HashSet;
import java.util.Set;

public class Anagramm {

    private static char[] chars;
    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        String word = "cat";
        chars = word.toCharArray();
        getAnagramm(chars.length);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void getAnagramm(int currentSize) {
        if (currentSize == 1) {
            return;
        }

        for (int i = 0; i < currentSize; i++) {
            getAnagramm(currentSize - 1);
//            if (currentSize == 2) {
//                display();
//            }
            result.add(new String(chars));
            rotate(currentSize);
        }
    }

    private static void rotate(int currentSize) {
        int pos = chars.length - currentSize;
        char temp = chars[pos];
        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }

    private static void display() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
