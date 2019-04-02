package com.sm.starter.catalog.dto;

import java.util.ArrayList;
import java.util.List;

public class BooksDto {
    private List<BookDto> books = new ArrayList<>();

    public BooksDto() {
    }

    public BooksDto(List<BookDto> books) {
        this.books = books;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BooksDto{" +
                "books=" + books +
                '}';
    }
}
