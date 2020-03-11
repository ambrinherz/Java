package com.ambrin.pdc.string;

//Find the minimum characters to be removed in two given strings to make them anagrams of each other//

public class AnagramTest {

    public static void main(String[] args) {
        String firstInput = "fcrxzwscanmligcvxsym";
        String secondInput = "jxwtrhvujlmrpdoqbisbwgdseratke";
        System.out.println("The minimum deletions required are:" + createAnagram(firstInput, secondInput));
    }

    public static int createAnagram(String firstString,String secondString) {

        int[] characterIndex = new int[26];

        //check first string and for any character (A to Z) found in the string increment the corresponding index//
        for (char c : firstString.toCharArray()) {
            characterIndex[c - 'a']++;
        }

        //check second string and for any character (A to Z) found in the string decrement the corresponding index//
        for (char c : secondString.toCharArray()) {
            characterIndex[c - 'a']--;
        }

        //Add the index values to get the result//
        int result = 0;
        for (int i : characterIndex) {
            result += Math.abs(i);

        }
        return result;
    }
}
