package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findBookByISBN(book.getISBN());

        if (optionalBook.isPresent()){
            throw new IllegalStateException("ISBN already present in the system.");
        }

        bookRepository.save(book);
    }

    public void deleteBook(Long isbn) {
        boolean exists = bookRepository.existsById(isbn);
        if (!exists){
            throw new IllegalStateException(
                    "Book with ISBN " + isbn + " does not exist.");
        }

        bookRepository.deleteById(isbn);
    }
}
