package class_problems;

public class FirstNonRepeatingCharacter {


    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }


        int[] freq = new int[256];


        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void test(String input) {
        char result = findFirstNonRepeatingChar(input);
        System.out.print("Input: \"" + input + "\" -> ");
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        test("swiss");
        test("aabbcc");
        test("developer");
        test("success");
    }
}