package assigment_problems;

public class StopWordFilteredWordFrequency {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (int i = 0; i < STOP_WORDS.length; i++) {
            if (STOP_WORDS[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", " ")
                .replace(",", " ")
                .replace("!", " ")
                .replace("?", " ")
                .replace(";", " ")
                .replace(":", " ");

        String[] words = cleaned.trim().split("\\s+");

        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int uniqueCount = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }

            int foundIndex = -1;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueWords[j].equals(word)) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex != -1) {
                counts[foundIndex]++;
            } else {
                uniqueWords[uniqueCount] = word;
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = 0; j < uniqueCount - i - 1; j++) {
                if (counts[j] < counts[j + 1]) {
                    int tempCount = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tempCount;

                    String tempWord = uniqueWords[j];
                    uniqueWords[j] = uniqueWords[j + 1];
                    uniqueWords[j + 1] = tempWord;
                }
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueWords[i] + ": " + counts[i]);
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}