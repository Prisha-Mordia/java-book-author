package com.example.javabookauthor.controller;

import com.example.javabookauthor.entity.Author;
import com.example.javabookauthor.entity.Book;
import com.example.javabookauthor.service.AuthorService;
import com.example.javabookauthor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    // List all books
    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list-books";
    }

    // Show add book form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "add-book";
    }

    // Handle new book form submission
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Show edit book form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getAllBooks().stream()
                               .filter(b -> b.getId().equals(id))
                               .findFirst()
                               .orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "update-book";
    }

    // Handle update book form submission
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "redirect:/books";\
    }
}
