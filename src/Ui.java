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
