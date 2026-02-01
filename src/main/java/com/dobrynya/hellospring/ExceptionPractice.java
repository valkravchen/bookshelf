package com.dobrynya.hellospring;

public class ExceptionPractice {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введён индекс вне границ массива");
        }

        task2(null);
        task2("hello");
    }

    public static void task2(String text) {
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Получен null");
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }
    }
}
