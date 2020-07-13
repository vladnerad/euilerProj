package com.company.sixtieths;

import com.company.EulerTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task59 implements EulerTask {
    @Override
    public int getAnswer() {
        // Алфавит в виде массива
        int[] alph = "abcdefghijklmnopqrstuvwxyz".chars().toArray();

        Path cipher = Path.of("C:\\Users\\vpriselkov\\IdeaProjects\\euilerProj\\src\\com\\company\\inputs\\p059_cipher.txt");
        Path wordsPath = Path.of("C:\\Users\\vpriselkov\\IdeaProjects\\euilerProj\\src\\com\\company\\inputs\\words.txt");
        try {
            // Получим 1000 самых частых английских слов из файла
            Set<String> commonWords = Files.lines(wordsPath).collect(Collectors.toSet());
            // Вытаскиваем зашифрованный текст из файла
            int[] ciph = Files.lines(cipher).flatMap(s -> Stream.of(s.split(","))).mapToInt(Integer::parseInt).toArray();
            byte[] cbyte = new byte[ciph.length];
            for (int i = 0; i < cbyte.length; i++) {
                cbyte[i] = (byte) ciph[i];
            }

            int maxCount = 0;
            String strAnsw = "";
            for (int c1 : alph) {
                for (int c2 : alph) {
                    for (int c3 : alph) {
                        String key = String.valueOf((char) c1).concat(String.valueOf((char) c2)).concat(String.valueOf((char) c3));
                        String decoded = decode(cbyte, key);
                        int counter = 0;
                        for (String word : commonWords) {
                            if (decoded.contains(word)) {
                                counter++;
                            }
                        }
                        if (counter > maxCount) {
                            maxCount = counter;
                            strAnsw = decoded;
                        }
                    }
                }
            }
            System.out.println(strAnsw);
            int result = 0;
            for (char c : strAnsw.toCharArray()) {
                result += c;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }
        return new String(res);
    }
}
