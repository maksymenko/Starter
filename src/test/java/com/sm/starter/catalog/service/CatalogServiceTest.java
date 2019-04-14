package com.sm.starter.catalog;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.sm.starter.catalog.domain.BookModel;
import com.sm.starter.catalog.domain.BookRepository;
import com.sm.starter.catalog.dto.BookDto;
import com.sm.starter.catalog.rest.CatalogController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


public class CatalogServiceTest {

    @Mock
    private BookRepository bookRepository;

    private CatalogController.CatalogService catalogService;

    @Captor
    private ArgumentCaptor<BookModel> bookModelCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        catalogService = new CatalogController.CatalogService(bookRepository);
    }

    @Test
    public void shouldAddBookSuccessfully() {
        BookDto bookDto = new BookDto(0, "title", "author", 12);
        BookModel bookModel = new BookModel();
        bookModel.setId(3);

        Mockito.when(bookRepository.save(bookModelCaptor.capture())).thenReturn(bookModel);

        long id = catalogService.addBook(bookDto);

        BookModel bookModelActual = bookModelCaptor.getValue();

        assertThat(bookModelActual.getTitle(), equalTo(bookDto.getTitle()));
        assertThat(bookModelActual.getAuthor(), equalTo(bookDto.getAuthor()));
        assertThat(bookModelActual.getPrice(), equalTo(bookDto.getPrice()));
        assertThat(id, equalTo(bookModel.getId()));
    }
}
