import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ui {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Enter number of titles:");
        int nTitles = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.println("Enter the " + nTitles + " titles:");
        ArrayList<String> titles = readLines(nTitles);

        System.out.println("Enter words to ignore seperated by spaces all in one line:");
        ArrayList<String> wordsToIgnore = new ArrayList<String>(Arrays.asList(sc.nextLine().split("\\s+")));

        Logic logic = new Logic(titles, wordsToIgnore);
        ArrayList<String> kwicIndex = logic.computeKwicIndex();
        for (String s : kwicIndex) {
            System.out.println(s);
        }
        sc.close();
    }

    private static ArrayList<String> readLines(int nLines) {
        ArrayList<String> lines = new ArrayList<String>(nLines);
        for (int i = 0; i < nLines; ++i) {
            lines.add(sc.nextLine());
        }
        return lines;
    }
}
