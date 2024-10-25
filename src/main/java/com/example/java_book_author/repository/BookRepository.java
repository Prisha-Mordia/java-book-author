package com.example.javabookauthor.repository;

import com.example.javabookauthor.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query to join Book and Author entities
    @Query("SELECT b FROM Book b JOIN b.author a WHERE a.id = :authorId")
    List<Book> findByAuthorId(@Param("authorId") Long authorId);
}
