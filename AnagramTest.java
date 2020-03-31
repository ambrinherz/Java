package com.ambrin.pdc.string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String firstInput = "apple";
        String secondInput = "banana";
        System.out.println(anagramChecker(firstInput, secondInput));
    }

    public static boolean anagramChecker(String firstInput, String secondInput) {
        if (firstInput == null) {
            return secondInput == null;
        }

        if (secondInput == null) {
            return false;
        }

        if (firstInput.isEmpty()) {
            return secondInput.isEmpty();
        }

        if(secondInput.isEmpty()) {
            return false;
        }

        if ((firstInput.length()) != (secondInput.length())) {
            return false;
        }

        char[] firstInputChars = firstInput.toCharArray();
        Arrays.sort(firstInputChars);
        String sortedFirstInput = new String(firstInputChars);

        char[] SecondInputChars = secondInput.toCharArray();
        Arrays.sort(SecondInputChars);
        String sortedSecondInput = new String(SecondInputChars);

        return sortedFirstInput.equals(sortedSecondInput);
    }


}
