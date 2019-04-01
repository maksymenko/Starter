package com.sm.apistarter.apistarter.catalog;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BookDto {
    private long id;
    private String title;
    private String author;
    @Min(1)
    @Max(10)
    private long price;

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

    @Min(1)
    @Max(10)
    public long getPrice() {
        return price;
    }

    @Min(1)
    @Max(10)
    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
