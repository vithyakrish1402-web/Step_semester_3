package string.class_problems;

public class PalindromeChecker {


    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean checkRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
            return false;
        }
        return checkRecursiveHelper(text, left + 1, right - 1);
    }


    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equalsIgnoreCase(new String(reversed));
    }

    public static void verifyAndPrint(String word) {
        boolean iter = isPalindromeIterative(word);
        boolean recur = isPalindromeRecursive(word);
        boolean rev = isPalindromeArrayReversal(word);

        System.out.println("Input: \"" + word + "\"");
        System.out.println("Iterative: " + (iter ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (recur ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (rev ? "Palindrome" : "Not Palindrome"));
        System.out.println("All Approaches Agree: " + (iter == recur && recur == rev));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== QA Text Verification Toolkit ===");
        verifyAndPrint("madam");
        verifyAndPrint("hello");
        verifyAndPrint("RaceCar");
        verifyAndPrint("step");
    }
}
