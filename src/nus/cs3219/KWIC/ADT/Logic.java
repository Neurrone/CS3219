package nus.cs3219.KWIC.ADT;

import java.util.ArrayList;
import java.util.Collections;

public class Logic {
    private ArrayList<String> titles;
    private ArrayList<String> wordsToIgnore;

    public Logic(ArrayList<String> titles, ArrayList<String> ignoreWords) {
        this.titles = titles;
        this.wordsToIgnore = ignoreWords;
    }

    public ArrayList<String> computeKwicIndex() {
        ArrayList<String> circularShifts = new ArrayList<String>();
        for (String title : titles) {
            circularShifts.addAll(CircularShifter.circularShift(title, wordsToIgnore));
        }
        Collections.sort(circularShifts);
        return circularShifts;
    }

}
