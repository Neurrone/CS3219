package nus.cs3219.KWIC.ADT;

import java.util.ArrayList;

public class CircularShifter {
    /*
     * A circular shift is when the first word in the line is removed and
     * appended to the back. This method exhaustively circularly shifts the
     * supplied line, returning circular shifts who's first word (non
     * case-sensitive) is not in the ignore list. The returned circular shifts
     * will also have their first character capitalized.
     */
    public static ArrayList<String> circularShift(String line, ArrayList<String> wordsToIgnore) {
        String[] words = line.split("\\s+");
        ArrayList<String> circularShifts = new ArrayList<String>(words.length);

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (!isWordIgnored(word, wordsToIgnore)) {
                StringBuilder shift = new StringBuilder();
                shift.append(capitalizeString(word));
                for (int j = (i + 1) % words.length; j != i; j = (j + 1) % words.length) {
                    shift.append(" ");
                    shift.append(words[j]);
                }
                circularShifts.add(shift.toString());
            }
        }

        return circularShifts;
    }

    /*
     * Returns whether a word is in the list of words to ignore by doing a
     * case-insensitive comparison.
     */
    public static boolean isWordIgnored(String word, ArrayList<String> wordsToIgnore) {
        for (String w : wordsToIgnore) {
            if (w.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    private static String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
