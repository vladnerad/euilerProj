package com.company;

import java.util.HashMap;

public class Task17 implements EulerTask{
    private String
            one = "one",
            two = "two",
            three = "three",
            four = "four",
            five = "five",
            six = "six",
            seven = "seven",
            eight = "eight",
            nine = "nine",
            ten = "ten",
            eleven = "eleven",
            twelve = "twelve",
            thirteen = "thirteen",
            fourteen = "fourteen",
            fifteen = "fifteen",
            sixteen = "sixteen",
            seventeen = "seventeen",
            eighteen = "eighteen",
            nineteen = "nineteen",
            twenty = "twenty",
            thirty = "thirty",
            fourty = "fourty",
            fifty = "fifty",
            sixty = "sixty",
            seventy = "seventy",
            eighty = "eighty",
            ninety = "ninety",
            hundred = "hundred",
            thousand = "one thousand",
            and = "and";

    private HashMap<Integer, String> units;
    private HashMap<Integer, String> tens;
    private HashMap<Integer, String> hundreds;

    int result = 0;

    public Task17() {
        units = new HashMap<>();
        units.put(1, one);
        units.put(2, two);
        units.put(3, three);
        units.put(4, four);
        units.put(5, five);
        units.put(6, six);
        units.put(7, seven);
        units.put(8, eight);
        units.put(9, nine);
        units.put(10, ten);
        units.put(11, eleven);
        units.put(12, twelve);
        units.put(13, thirteen);
        units.put(14, fourteen);
        units.put(15, fifteen);
        units.put(16, sixteen);
        units.put(17, seventeen);
        units.put(18, eighteen);
        units.put(19, nineteen);


        tens = new HashMap<>();
        tens.put(2, twenty);
        tens.put(3, thirty);
        tens.put(4, fourty);
        tens.put(5, fifty);
        tens.put(6, sixty);
        tens.put(7, seventy);
        tens.put(8, eighty);
        tens.put(9, ninety);

        hundreds = new HashMap<>();
        hundreds.put(1, one+hundred);
        hundreds.put(2, two+hundred);
        hundreds.put(3, three+hundred);
        hundreds.put(4, four+hundred);
        hundreds.put(5, five+hundred);
        hundreds.put(6, six+hundred);
        hundreds.put(7, seven+hundred);
        hundreds.put(8, eight+hundred);
        hundreds.put(9, nine+hundred);
    }

//    @Override
//    public int getAnswer() {
//        int result = 0;
//        for(int i = 1; i<=1000; i++){
//            if (i < 20) result+=units.get(i).length();
//            else if (i < 100){
//                if (i%10==0) result+=tens.get(i/10).length();
//                else result+= tens.get(i/10).length() + units.get(i%10).length();
//            }
//            else if (i < 1000){
//                result+=hundreds.get(i/100).length();
//                if (i%100!=0){
//                    result+=and.length();
//                    if ((i%100) < 20) result+=units.get(i%100).length();
//                    else {
//                        if ((i%100)%10==0) result+=tens.get((i%100)/10).length();
//                        else result+= tens.get((i%100)/10).length() + units.get((i%100)%10).length();
//                    }
//                }
//            }
//            else result+=thousand.length();
//        }
//        return result;
//    }

    @Override
    public int getAnswer() {
        for(int i = 1; i<=1000; i++){
            getNumberLetters(i);
        }
        return result;
    }

    private void getNumberLetters(int number){
        if (number<20) result+=units.get(number).length();
        else if (number < 100){
            if (number%10==0) result+=tens.get(number/10).length();
            else getNumberLetters(number%10);
        }
        else if (number < 1000){
            if (number%100==0) result+=hundreds.get(number/100).length();
            else{
                result+=and.length();
                getNumberLetters(number%100);
            }
        }
        else result+=thousand.length();
    }
}
