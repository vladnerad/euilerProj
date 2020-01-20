package com.company.sixtieths;

import com.company.EulerTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task54 implements EulerTask {

    private Set<Character> royal = new HashSet<>(Arrays.asList('A', 'K', 'Q', 'J', 'T'));
    private Map<Character, Integer> price;

    private void fillMap(){
        price = new HashMap<>();
        price.put('2', 2);
        price.put('3', 3);
        price.put('4', 4);
        price.put('5', 5);
        price.put('6', 6);
        price.put('7', 7);
        price.put('8', 8);
        price.put('9', 9);
        price.put('T', 10);
        price.put('J', 11);
        price.put('Q', 12);
        price.put('K', 13);
        price.put('A', 14);
    }

    public Task54() {
        fillMap();
    }

    @Override
    public int getAnswer() {
        int result = 0;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\vpriselkov\\IdeaProjects\\euilerProj\\src\\com\\company\\inputs\\p054_poker.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null){
                if (isPlayer1Wins(line)) result++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean isPlayer1Wins(String s){
        String[] match = new String[2];
        match[0] = s.substring(0, 14);
        match[1] = s.substring(15);
        if (match[1].length() != 14) System.out.println(match[1]);
        else {
            if (isRoyalFlush(match[0]) && !isRoyalFlush(match[1])) return true;
            else if (isRoyalFlush(match[0]) && isRoyalFlush(match[1])) {
                System.out.println("Royal flush both");
            }
            else if(!isRoyalFlush(match[0]) && isRoyalFlush(match[1])){ return false; }
            else {
                if (isStraightFlush(match[0]) && !isStraightFlush(match[1])) return true;
                else if (isStraightFlush(match[0]) && isStraightFlush(match[1])) {
                    System.out.println("Straight flush both");
                }
                else if(!isStraightFlush(match[0]) && isStraightFlush(match[1])){ return false; }
                else {
                    if (isFourOfAKind(match[0]) && !isFourOfAKind(match[1])) return true;
                    else if (isFourOfAKind(match[0]) && isFourOfAKind(match[1])) {
                        System.out.println("Four of a kind both");
                    }
                    else if (!isFourOfAKind(match[0]) && isFourOfAKind(match[1])) { return false; }
                    else {
                        if (isFullHouse(match[0]) && !isFullHouse(match[1])) return true;
                        else if (isFullHouse(match[0]) && isFullHouse(match[1])) {
                            System.out.println("isFullHouse both");
                        }
                        else if (!isFullHouse(match[0]) && isFullHouse(match[1])) { return false; }
                        else {
                            if (isFlush(match[0]) && !isFlush(match[1])) return true;
                            else if (isFlush(match[0]) && isFlush(match[1])) {
                                System.out.println("isFlush both");
                            }
                            else if (!isFlush(match[0]) && isFlush(match[1])) { return false; }
                            else {
                                if (isStraight(match[0]) && !isStraight(match[1])) return true;
                                else if (isStraight(match[0]) && isStraight(match[1])) {
                                    System.out.println("isStraight both");
                                }
                                else if (!isStraight(match[0]) && isStraight(match[1])) { return false; }
                                else {
                                    if (isThreeOfAKind(match[0]) && !isThreeOfAKind(match[1])) return true;
                                    else if (isThreeOfAKind(match[0]) && isThreeOfAKind(match[1])) {
                                        System.out.println("isThreeOfAKind both");
                                    }
                                    else if (!isThreeOfAKind(match[0]) && isThreeOfAKind(match[1])) { return false; }
                                    else {
                                        if (isTwoPairs(match[0]) && !isTwoPairs(match[1])) return true;
                                        else if (isTwoPairs(match[0]) && isTwoPairs(match[1])) {
                                            System.out.println("isTwoPairs both");
                                        }
                                        else if (!isTwoPairs(match[0]) && isTwoPairs(match[1])) { return false; }
                                        else {
                                            if (isOnePair(match[0]) && !isOnePair(match[1])) return true;
                                            else if (isOnePair(match[0]) && isOnePair(match[1])) {
//                                                System.out.println("isOnePair both");
                                                if (getPairPrice(match[0]) > getPairPrice(match[1])) return true;
                                                else if (getPairPrice(match[0]) < getPairPrice(match[1])) return false;
                                                else {
                                                    if (getHighCard(match[0]) > getHighCard(match[1])) return true;
                                                    else if (getHighCard(match[0]) < getHighCard(match[1])) return false;
                                                    else System.out.println("da nu nahui");
                                                    System.out.println(match[0] + " ---- " + match[1]);
                                                    System.out.println(getPairPrice(match[0]) + " ---- " + getPairPrice(match[1]));
                                                }
                                            }
                                            else if (!isOnePair(match[0]) && isOnePair(match[1])) return false;
                                            else {
                                                return getHighCard(match[0]) > getHighCard(match[1]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("outside if");
        return false;
    }

    private boolean isRoyalFlush(String s){
        if (isFlush(s)){
            Set<Character> result = new HashSet<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i = i + 3) {
                result.add(chars[i]);
            }
            return result.containsAll(royal);
        }
        return false;
    }

    private boolean isFlush(String s){
        if (s.length() == 14) {
            Set<Character> result = new HashSet<>();
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i = i + 3) {
                result.add(chars[i]);
            }
            return result.size() == 1;
        } else {
            System.out.println(s + " isFlush() error " + s.length());
            return false;
        }
    }

    private Map<Character, Integer> getHandMapWithoutSuit (String s){
        Map <Character, Integer> result = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 3){
            if (!result.containsKey(chars[i])){
                result.put(chars[i], 1);
            }
            else {
                result.replace(chars[i], result.get(chars[i]) + 1);
            }
        }
        return result;
    }

    public boolean isFourOfAKind(String s){
        Map<Character, Integer> map = getHandMapWithoutSuit(s);
        if (map.size() == 2){
            for (Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue() != 1 && entry.getValue() != 4){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private TreeSet<Integer> getSetOfInt(String s) {
        if (s.length() == 14) {
            TreeSet<Integer> result = new TreeSet<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i = i + 3) {
                try {
                    result.add(price.get(chars[i]));
                } catch (NullPointerException e){
                    System.out.println(s);
                    System.out.println(i);
                    e.printStackTrace();
                    System.exit(0);
                }

            }
            return result;
        } else {
            System.out.println("getSetOfInt() error");
            return null;
        }
    }

    private boolean isStraight(String s){
        TreeSet<Integer> set = getSetOfInt(s);
        if (set != null && set.size() == 5){
            return set.last() - set.first() == 4;
        }
        else return false;
    }

    private boolean isStraightFlush(String s){
        return  !isRoyalFlush(s) && isFlush(s) && isStraight(s);
    }

    private boolean isOnePair(String s){
        return getHandMapWithoutSuit(s).size() == 4;
    }

    private boolean isFullHouse(String s){
        return !isFourOfAKind(s) && getHandMapWithoutSuit(s).size() == 2;
    }

    private boolean isThreeOfAKind(String s){
        Map<Character, Integer> map = getHandMapWithoutSuit(s);
        if (map.size() == 3){
            for (Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue() == 3) return true;
            }
        }
        return false;
    }

    private boolean isTwoPairs(String s){
        Map<Character, Integer> map = getHandMapWithoutSuit(s);
        if (map.size() == 3){
            for (Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue() == 3) return false;
            }
            return true;
        }
        return false;
    }

    private int getHighCard(String s){
        return getSetOfInt(s).last();
    }

    private int getPairPrice(String s){
        char card = ' ';
        for (Map.Entry<Character, Integer> entry: getHandMapWithoutSuit(s).entrySet()){
            if (entry.getValue() == 2) card = entry.getKey();
        }
        try {
            return price.get(card);
        } catch (NullPointerException e){
            System.out.println(s);
            System.out.println(card);
            System.out.println(getHandMapWithoutSuit(s));
            System.exit(0);
            return 0;
        }
    }
}
