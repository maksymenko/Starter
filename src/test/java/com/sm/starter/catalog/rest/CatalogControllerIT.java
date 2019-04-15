package com.sm.starter.catalog.rest;


import com.sm.starter.StarterApplication;

import com.sm.starter.catalog.dto.BookDto;
import com.sm.starter.catalog.dto.BooksDto;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StarterApplication.class, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogControllerIT {
    @LocalServerPort
    private int port;

    private URL base;
    private TestRestTemplate template;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/books/");
        this.template = new TestRestTemplate();
    }

    @Test
    public void shouldReturnList() {
        ResponseEntity<BooksDto> response = template.getForEntity(base.toString(), BooksDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody().getBooks()).isEmpty();


        template.postForEntity(base.toString(), new BookDto(1, "title", "author", 123), BookDto.class);

        response = template.getForEntity(base.toString(), BooksDto.class);

        assertThat(response.getBody().getBooks()).containsAll(asList(
                new BookDto(1, "title", "author", 123)));
    }
}
