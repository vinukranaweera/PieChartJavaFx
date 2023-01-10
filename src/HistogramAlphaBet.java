/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HistogramAlphaBet {
    private HashMap < Character, Integer > frequencys;
    private Scanner scans;
    private final String FILE;

    public HistogramAlphaBet(String fileNames) {
        frequencys = new HashMap < > ();
        FILE = fileNames;
        for (char temps = 'a'; temps <= 'z'; ++temps) {
            frequencys.put(temps, 0);
        }
    }
    public void openFile() {
        try {
            scans = new Scanner(Paths.get(FILE));
        } catch (IOException exception) {
            System.out.println("Unable to open file");
        }
    }
    public void closeFile() {
        if (scans != null) scans.close();
    }
    public HashMap frequencyOfLetters() {
        openFile();
        String lines;
        Character letters;
        try {
            while (scans.hasNext()) {
                lines = scans.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
                for (int i = 0; i < lines.length(); ++i) {
                    letters = lines.charAt(i);
                    frequencys.put(letters, frequencys.get(letters) + 1);
                }
            }
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.out.println(exception);
        }
        closeFile();
        return frequencys;
    }
}
