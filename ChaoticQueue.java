//Consider people standing in a queue where n=5 represents 5 people in the queue starting from 1 to n. Eg. 1,2,3,4,5
//Every person can bribe the person in front of them but they retain their position stickers. For Eg. 1,2,3,5,4 . Here 5 bribed 4 and they swapped positions.
//Any person can bribe a maximum of 2 people ahead of them. Given a queue find how many swaps occured and if seems like more than 2 bribes occured by the same person just inform the queue is "too chaotic."

//Method 1:

package com.ambrin.pdc.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Chaotic {

static String minimumBribes(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(isChaotic(array[i], i)) {
                return "Too chaotic";
            }

            for (int j = getStartIndex(array[i]); j < i; j++) {
                if (array[j] > array[i]) {
                    count++;
                }
            }
        }
        return Integer.toString(count);
    }

    private static int getStartIndex(int value) {
        return Math.max(0, value - 2);
    }

    private static boolean isChaotic(int value, int index) {
        return value - (index + 1) > 2;
    }
    
    public static void main(String[] args) {
       int[] array = {2,5,1,3,4};
       Chaotic chaotic = new Chaotic();
       System.out.println("Number of swaps "+ chaotic.minimumBribes(array));

    }
}

//Method 2: Using Java 8 Streams

import java.util.Arrays;
import java.util.stream.IntStream;

public class Chaotic {

    private boolean isTooChaotic(int[] array) {
        return IntStream.range(0, array.length).parallel()
                .filter(i -> array[i] - (i + 1) > 2)
                .findFirst()
                .isPresent();
    }

    private long numOfSwaps(int[] array) {
        return IntStream.range(0, array.length).parallel()
                .mapToLong(index -> getNumOfSwaps(index, array))
                .sum();
    }


    private long getNumOfSwaps(int index, int[] array) {
        int currentValue = array[index];
        int numToSkip = Math.max(0, currentValue - 2);
        int limit = Math.max(0, index - numToSkip);

        return Arrays.stream(array).parallel()
                .skip(numToSkip)
                .limit(limit)
                .filter(element -> element > currentValue)
                .count();
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 8, 9, 7, 5, 10};  
        System.out.println("Number of swaps " + chaotic.numOfSwaps(array));
//        System.out.println(chaotic.isTooChaotic(array));
    }
}

