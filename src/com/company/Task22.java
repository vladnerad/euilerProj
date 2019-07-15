package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Task22 {
    private File namesFile = new File("/home/vladik/java/javaProj/sources/euilerProj/src/com/company/inputs/names.txt");
    private String fileName = "/home/vladik/java/javaProj/sources/euilerProj/src/com/company/inputs/names.txt";

    private String[] getNamesFromFile(String fileName){

        try {
//            String[] array = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(s -> s.split(",")).sorted().collect();
//            String[] array = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).toArray(String[]::new);
            String[] array =  Arrays.stream(Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8).toArray(String[]::new)).map(s -> s.split(",")).collect(String[]::new);
            System.out.println(array.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        String[] result;
//        try(FileReader fr = new FileReader(namesFile)){
//
//            return result;
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
    }

    public int getAnswer(){
        getNamesFromFile(fileName);
        return 0;
    }
}
