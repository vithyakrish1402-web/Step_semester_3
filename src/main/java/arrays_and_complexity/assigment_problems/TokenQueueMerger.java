package arrays_and_complexity.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TokenQueueMerger {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int lenA = (counterA != null) ? counterA.length : 0;
        int lenB = (counterB != null) ? counterB.length : 0;
        int[] merged = new int[lenA + lenB];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lenA && j < lenB) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        while (i < lenA) {
            merged[k++] = counterA[i++];
        }

        while (j < lenB) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lenA = (counterA != null) ? counterA.size() : 0;
        int lenB = (counterB != null) ? counterB.size() : 0;

        while (i < lenA && j < lenB) {
            int valA = counterA.get(i);
            int valB = counterB.get(j);
            if (valA <= valB) {
                merged.add(valA);
                i++;
            } else {
                merged.add(valB);
                j++;
            }
        }

        while (i < lenA) {
            merged.add(counterA.get(i++));
        }

        while (j < lenB) {
            merged.add(counterB.get(j++));
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] counterA1 = {3, 8, 15, 20};
        int[] counterB1 = {5, 8, 12};
        System.out.println(Arrays.toString(mergeTokens(counterA1, counterB1)));

        int[] counterA2 = {};
        int[] counterB2 = {4, 9};
        System.out.println(Arrays.toString(mergeTokens(counterA2, counterB2)));
    }
}
