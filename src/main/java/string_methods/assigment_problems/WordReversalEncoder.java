package string_methods.assigment_problems;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            String currentWord = words[i];

            for (int j = currentWord.length() - 1; j >= 0; j--) {
                reversedWord.append(currentWord.charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println(output);

        System.out.println(reverseEachWord("Java programming is fun"));
    }
}
