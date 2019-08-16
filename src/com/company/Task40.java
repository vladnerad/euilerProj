package com.company;

public class Task40 implements EulerTask {
    @Override
    public int getAnswer() {
        int result = 1;
        int x = 9;
        int[] digits = new int[7];
        int[] position = new int[7];
        for (int i = 0; i < position.length; i++) {
            position[i] = (int) Math.pow(10, i);
        }
        for (int i = 0; i < position.length; i++) {
            int z = position[i];
            int pow = -1;
            int d = 0;
            int z1 = 0;
            while (z > 0) {
                d++;
                pow++;
                z1 = z;
                z = z - x * d * (int) Math.pow(10, pow);
            }
            // Получили количество цифр в числе - d
            int number = ((int) Math.ceil(z1 / d) /*- 1*/) + (int) Math.pow(10, pow);
            int f = z1 % d;
            if (number > 9) {
                digits[i] = Integer.parseInt(String.valueOf(number).split("")[f - 1]);
            } else digits[i] = Integer.parseInt(String.valueOf(number).split("")[0]) - 1;
        }
        for (Integer asd : digits) {
//            System.out.println(asd);
            result *= asd;
        }
        return result;
    }
}
