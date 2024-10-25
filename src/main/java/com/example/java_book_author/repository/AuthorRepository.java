package com.example.javabookauthor.repository;

import com.example.javabookauthor.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
