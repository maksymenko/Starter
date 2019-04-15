package com.sm.starter.catalog.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.sm.starter.catalog.domain.BookModel;
import com.sm.starter.catalog.domain.BookRepository;
import com.sm.starter.catalog.dto.BookDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


public class CatalogServiceTest {

    @Mock
    private BookRepository bookRepository;

    private CatalogService catalogService;

    @Captor
    private ArgumentCaptor<BookModel> bookModelCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        catalogService = new CatalogService(bookRepository);
    }

    @Test
    public void shouldAddBookSuccessfully() {
        BookDto bookDto = new BookDto(0, "title", "author", 12);
        BookModel bookModel = new BookModel();
        bookModel.setId(3);

        Mockito.when(bookRepository.save(bookModelCaptor.capture())).thenReturn(bookModel);

        long id = catalogService.addBook(bookDto);

        BookModel bookModelActual = bookModelCaptor.getValue();

        assertThat(bookModelActual.getTitle()).isEqualTo(bookDto.getTitle());
        assertThat(bookModelActual.getAuthor()).isEqualTo(bookDto.getAuthor());
        assertThat(bookModelActual.getPrice()).isEqualTo(bookDto.getPrice());
        assertThat(id).isEqualTo(bookModel.getId());
    }
}
