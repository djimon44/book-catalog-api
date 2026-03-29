package com.dima.bookcatalogapi.service;

import com.dima.bookcatalogapi.model.Book;
import com.dima.bookcatalogapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    // Fetch all books from the database
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Fetch a single book by ID, throw if not found
    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // Persist a new book and return the saved entity (with generated ID)
    public Book createBook(Book book) {
        return repository.save(book);
    }

    // Find existing book, overwrite its fields, then save
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id); // reuses the not-found exception from above
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setIsbn(bookDetails.getIsbn());
        return repository.save(book);
    }

    // Delete by ID — findById first so we throw if the book doesn't exist
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        repository.delete(book);
    }
}
