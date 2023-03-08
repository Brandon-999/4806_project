package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.model.BookModel;
import main.repository.BookRepository;
import org.springframework.ui.Model;

@Controller
public class CartController {

    private BookRepository bookRepository;

    @GetMapping("")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    /**
     * Adding a book to database. TO be expanded upon later
     */
    @PostMapping("")
    public String addBook(@ModelAttribute BookModel book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

}
