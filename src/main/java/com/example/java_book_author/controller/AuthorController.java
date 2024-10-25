package com.example.javabookauthor.controller;

import com.example.javabookauthor.entity.Author;
import com.example.javabookauthor.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // List all authors
    @GetMapping
    public String listAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "list-authors";  // Matches the list-authors.jsp or list-authors.html in templates
    }

    // Show add author form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";  // Matches add-author.jsp or add-author.html in templates
    }

    // Handle new author form submission
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";  // Redirects to the list of authors
    }

    // Show edit author form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.getAllAuthors().stream()
                                     .filter(a -> a.getId().equals(id))
                                     .findFirst()
                                     .orElse(null);
        model.addAttribute("author", author);
        return "update-author";  // Matches update-author.jsp or update-author.html in templates
    }

    // Handle update author form submission
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute Author updatedAuthor) {
        authorService.updateAuthor(id, updatedAuthor);
        return "redirect:/authors";  // Redirects to the list of authors
    }
}
