package com.dobrynya.bookshelf.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class BookCreateDTO {

    @NotBlank(message = "Название обязательно")
    @Size(min = 2, max = 200, message = "Название: от 2 до 200 символов")
    private String title;

    @NotEmpty(message = "Укажите хотя бы одного автора")
    private Set<String> authorNames;
    private Set<String> tagNames;

    public BookCreateDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(Set<String> authorNames) {
        this.authorNames = authorNames;
    }

    public Set<String> getTagNames() {
        return tagNames;
    }

    public void setTagNames(Set<String> tagNames) {
        this.tagNames = tagNames;
    }
}
