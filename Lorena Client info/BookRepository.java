package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface BookRepository extends JpaRepository<Book,Long> {

        @Query ("SELECT l FROM Book l WHERE l.isbn = ?1")
        Optional<Book> findBookByISBN(Long isbn);
}
