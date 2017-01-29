package nus.cs3219.KWIC.ADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ui {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.print("Input words to ignore (all on one line): ");
        ArrayList<String> wordsToIgnore = new ArrayList<String>(Arrays.asList(sc.nextLine().split("\\s+")));

        System.out.println("Input titles (one per line; end with empty line):");
        ArrayList<String> titles = new ArrayList<String>();
        while (sc.hasNextLine()) {
            String title = sc.nextLine();
            if (title.isEmpty()) {
                break;
            }
            titles.add(title);
        }

        Logic logic = new Logic(titles, wordsToIgnore);
        ArrayList<String> kwicIndex = logic.computeKwicIndex();
        printKwicIndex(kwicIndex);
        sc.close();
    }

    public static void printKwicIndex(ArrayList<String> kwicIndex) {
        System.out.println("KWIC-index:");
        for (String s : kwicIndex) {
            System.out.println(capitalizeString(s));
        }
    }
    
    private static String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
