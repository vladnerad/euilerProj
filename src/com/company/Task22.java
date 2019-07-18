package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Task22 {
    //    private File namesFile = new File("/home/vladik/java/javaProj/sources/euilerProj/src/com/company/inputs/names.txt");
    //    private String fileName = "/home/vladik/java/javaProj/sources/euilerProj/src/com/company/inputs/names.txt";
    private String fileNameW = "C:\\Users\\vpriselkov\\IdeaProjects\\euilerProj\\src\\com\\company\\inputs\\names.txt";

    private String[] getNamesFromFile(String fileName) {

        try {
            String nameStr = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).get(0);
            String[] names = nameStr.split(",");
            names = Arrays.stream(names).map(s -> s.replace("\"", "")).sorted().toArray(String[]::new);
            return names;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getAnswer() {
        String[] names = getNamesFromFile(fileNameW);
        long result = 0;
        for (int i = 0; i < names.length; i++) {
            int nameScore = 0;
            for (char c : names[i].toCharArray()) {
                nameScore += (c - 64);
            }
            result += nameScore * (i + 1);
        }
        return result;
    }
}
