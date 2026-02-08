package com.dobrynya.bookshelf.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super("Тег с id " + id + " не найден");
    }
}
