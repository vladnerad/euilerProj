package com.company;

/*Мы вычитаем из квадрата суммы сумму квадратов
"Квадрат суммы нескольких слагаемых равен сумме
квадратов всех слагаемых и удвоенных попарных
произведений этих слагаемых."
В уме вычитаем сумму квадратов из квадрата суммы,
раскрыв скобки. Получается нам нужно найти сумму
удвоенных попарных произведений слагаемых из квадрата
суммы*/
public class Task6 implements EulerTask{
    private int quan = 100;
    private int result = 0;

    @Override
    public int getAnswer() {
        for (int i = 1; i<quan+1; i++){
            for (int j = i+1; j<quan+1; j++){
                result+=2*i*j;
            }
        }
        return result;
    }
}
