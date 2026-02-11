package com.dobrynya.bookshelf.practice;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringStreamPractice {
    public static void main(String[] args) {
        // Данные из формы
        String title = "Spring in Action";
        String authorInput = "Craig Walls, , Craig Walls";  // дубликат + пустой элемент
        String tagInput = "Java, Spring, , Java";           // дубликат + пустой элемент
        // 1. Авторы — обязательное поле
        Set<String> authors = Arrays.stream(authorInput.split(","))
                .map(String::trim)
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toSet());

        // 2. Теги — необязательное поле
        Set<String> tags = null;
        if (tagInput!= null && !tagInput.isEmpty()) {
            tags = Arrays.stream(tagInput.split(","))
                    .map(String::trim)
                    .filter(string -> !string.isEmpty())
                    .collect(Collectors.toSet());
        }
        System.out.println("Название: " + title);
        System.out.println("Авторы: " + authors);
        System.out.println("Теги: " + tags);
    }
}
