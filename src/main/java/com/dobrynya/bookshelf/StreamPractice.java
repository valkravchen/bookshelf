package com.dobrynya.bookshelf;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Spring in Action", "Craig Walls", 2022, 9));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", 2018, 10));
        books.add(new Book(3L, "Clean Code", "Robert Martin", 2008, 8));
        books.add(new Book(4L, "Java Concurrency", "Brian Goetz", 2006, 9));
        books.add(new Book(5L, "Head First Java", "Kathy Sierra", 2005, 7));
        books.add(new Book(6L, "Spring Boot in Action", "Craig Walls", 2016, 8));

        Book book = books.stream()
                .filter(book1 -> book1.getId().equals(3L))
                .findFirst()
                .orElse(null);
        System.out.println("Задание 1: " + book);

        List<Book> craigBooks = books.stream()
                .filter(book1 -> book1.getAuthor().equals("Craig Walls"))
                .toList();
        System.out.println("Задание 2: " + craigBooks);

        List<Book> newBooks = books.stream()
                .filter(book1 -> book1.getYear() > 2010)
                .toList();
        System.out.println("Задание 3: " + newBooks);

        List<String> titles = books.stream()
                .map(b -> b.getTitle())
                .toList();
        System.out.println("Задание 4: " + titles);

        long count = books.stream()
                .filter(book1 -> book1.getRating() >= 9)
                .count();
        System.out.println("Задание 5: " + count);

        boolean exists = books.stream()
                .anyMatch(book1 -> book1.getYear() == 2023);
        System.out.println("Задание 6: " + exists);

        List<String> topNewTitles = books.stream()
                .filter(book1 -> book1.getRating() >= 9 && book1.getYear() > 2010)
                .map(Book::getTitle)
                .toList();
        System.out.println("Задание 7: " + topNewTitles);

        books = books.stream()
                .filter(book1 -> book1.getId() != 2L)
                .toList();
        System.out.println("Задание 8: " + books);
    }

    static class Book {
        private Long id;
        private String title;
        private String author;
        private int year;
        private int rating;

        public Book(Long id, String title, String author, int year, int rating) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
            this.rating = rating;
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return title + " by " + author + " (" + year + ") - " + rating + "/10";
        }
    }
}
