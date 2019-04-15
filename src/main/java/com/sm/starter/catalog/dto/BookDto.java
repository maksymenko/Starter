package com.sm.starter.catalog.dto;

import javax.validation.constraints.Min;
import java.util.Objects;

public class BookDto {
    private long id;
    private String title;
    private String author;
    @Min(1)
    private long price;

    public BookDto() {
    }

    public BookDto(long id, String title, String author, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id && price == bookDto.price && Objects.equals(title, bookDto.title) && Objects.equals(author, bookDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price);
    }

    @Override
    public String toString() {
        return "BookDto{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", price=" + price + '}';
    }
}
