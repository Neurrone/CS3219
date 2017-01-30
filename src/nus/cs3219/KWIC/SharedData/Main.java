package nus.cs3219.KWIC.SharedData;
import java.util.*;

public class Main {

    private static List<String> inputSentences = new ArrayList<>();
    private static Set<String> wordsToIgnore = new HashSet<>();
    private static List<String> kwicIndex = new ArrayList<>();

    public static void main(String[] args) {
        readFromInput();
        circularShift();
        alphabetize();
        writeToOutput();
    }

    private static void readFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input words to ignore (all on one line): ");
        String firstLine = scanner.nextLine();
        for (String word : splitSentenceToWords(firstLine)) {
            wordsToIgnore.add(word.toLowerCase());
        }

        System.out.println("Input titles (one per line; end with empty line):");
        while (scanner.hasNextLine()) {
            String sentence = scanner.nextLine();
            if (sentence.isEmpty()) {
                break;
            }
            inputSentences.add(sentence);
        }
        scanner.close();
    }

    private static void circularShift() {
        for (String inputSentence : inputSentences) {
            List<String> words = splitSentenceToWords(inputSentence);
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                if (wordsToIgnore.contains(word.toLowerCase())) {
                    continue;
                }
                String shiftedSentence = formSentenceFromWords(words, i);
                kwicIndex.add(capitaliseFirstLetter(shiftedSentence));
            }
        }
    }

    private static void alphabetize() {
        Collections.sort(kwicIndex);
    }

    private static void writeToOutput() {
        System.out.println("KWIC-index:");
        for (String sentence : kwicIndex) {
            System.out.println(sentence);
        }
    }

    // Utility methods

    private static List<String> splitSentenceToWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return new ArrayList<>(Arrays.asList(words));
    }

    private static String formSentenceFromWords(List<String> words, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            int idx = (i + offset) % words.size();
            String word = words.get(idx);
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    private static String capitaliseFirstLetter(String str) {
        if (str.length() < 2) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
