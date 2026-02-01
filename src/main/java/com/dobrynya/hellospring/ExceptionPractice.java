package com.dobrynya.hellospring;

public class ExceptionPractice {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введён индекс вне границ массива");
        }
    }
}
