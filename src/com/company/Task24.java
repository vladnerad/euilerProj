package com.company;

public class Task24 {

    int[] array = {0, 1, 2, 3};

    public String getAnswer(){
        int shuffleCount = 6;

        return null;
    }

    private int[] shuffle(int[] array){
        if (array[array.length-1] < array[array.length-2]){
            int temp = array[array.length-1];
            array[array.length-1] = array[array.length-2];
            array[array.length-2] = temp;
        }
        else {

        }
        return array;
    }
}
