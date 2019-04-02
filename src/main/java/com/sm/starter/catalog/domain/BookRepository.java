package com.sm.starter.catalog.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<BookModel, Long> {

    List<BookModel> findByTitle(String title);

    List<BookModel> findByAuthor(String author);

    @Query("select b from BookModel b where b.title = :title and b.author = :author")
    List<BookModel> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
}
