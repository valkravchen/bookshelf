package com.dobrynya.bookshelf.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("Автор с id " + id + " не найден");
    }
}
