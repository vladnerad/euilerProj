package com.company.fifthten;

import com.company.EulerTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Task42 implements EulerTask {

    File file = new File("C:\\Users\\vpriselkov\\IdeaProjects\\euilerProj\\src\\com\\company\\inputs\\p042_words.txt");

    @Override
    public int getAnswer() {
        int result = 0;
        String[] words = getWords(file);
        int maxLenth = 0;
        for (String word : words) {
            if (word.length() > maxLenth) maxLenth = word.length();
        }
//        System.out.println(max * 26);
        maxLenth *= 26;
        ArrayList<Integer> triangles = new ArrayList<>();
        int first = 1;
        int counter = 1;
        while (first < maxLenth) {
            triangles.add(first);
            counter++;
            first = counter * (counter + 1) / 2;
        }

        for (String word : words) {
            char[] chars = word.toCharArray();
            int summ = 0;
            for (char c : chars) {
                summ += c;
            }
            summ -= word.length() * 64;
            if (triangles.contains(summ)) result++;
        }
        return result;
    }

    private String[] getWords(File f) {
        try {
            List<String> allWords = Files.readAllLines(file.toPath());
            if (allWords.size() == 1) {
                String[] words = allWords.get(0).split(",");
                for (int i = 0; i < words.length; i++) {
                    words[i] = words[i].replaceAll("\"", "");
                }
                return words;
            } else System.out.println("Error");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
