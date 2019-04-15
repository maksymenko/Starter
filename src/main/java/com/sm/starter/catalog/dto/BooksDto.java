package com.sm.starter.catalog.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BooksDto booksDto = (BooksDto) o;
        return Objects.equals(books, booksDto.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "BooksDto{" +
                "books=" + books +
                '}';
    }
}
