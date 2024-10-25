package com.example.javabookauthor.service;

import com.example.javabookauthor.entity.Author;
import com.example.javabookauthor.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            author.setNationality(updatedAuthor.getNationality());
            return authorRepository.save(author);
        }).orElseThrow(() -> new RuntimeException("Author not found"));
    }
}
