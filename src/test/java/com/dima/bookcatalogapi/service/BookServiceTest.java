package com.dima.bookcatalogapi.service;

import com.dima.bookcatalogapi.model.Book;
import com.dima.bookcatalogapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGetAllBooks() {
        Book book1 = new Book("Clean Code", "Robert Martin", "Technology", 2008, "9780132350884");
        Book book2 = new Book("The Pragmatic Programmer", "David Thomas", "Technology", 1999, "9780201616224");

        when(bookRepository.findAll()).thenReturn(List.of(book1, book2));

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    void testGetBookByIdFound() {
        Book book = new Book("Clean Code", "Robert Martin", "Technology", 2008, "9780132350884");
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1L);

        assertEquals("Clean Code", result.getTitle());
    }

    @Test
    void testGetBookByIdNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bookService.getBookById(99L));
    }

    @Test
    void testCreateBook() {
        Book book = new Book("Clean Code", "Robert Martin", "Technology", 2008, "9780132350884");
        book.setId(1L);

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book result = bookService.createBook(book);

        assertEquals("Clean Code", result.getTitle());
        assertEquals(1L, result.getId());
    }
}
