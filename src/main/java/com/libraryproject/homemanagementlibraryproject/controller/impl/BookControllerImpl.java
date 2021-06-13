package com.libraryproject.homemanagementlibraryproject.controller.impl;

import com.libraryproject.homemanagementlibraryproject.controller.BookController;
import com.libraryproject.homemanagementlibraryproject.dto.BookDto;
import com.libraryproject.homemanagementlibraryproject.enums.BookStatus;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getAll (Model model){
        model.addAttribute("getAllBooks", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/index")
    public String getAllBooks (Model model){
        model.addAttribute("getAllBooks", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm (Model model) {
        BookDto book = new BookDto();
        model.addAttribute("book",book);
        return "new_book";
    }

    @PostMapping("/save_book")
    public String saveBook(@ModelAttribute ("book") BookDto book) {
        book.setStatus(BookStatus.AVAILABLE);
        try {
            bookService.addBook(book);
        } catch (IllegalArgumentException e) {

        }
        return "redirect:/index";
    }
    @GetMapping("/showBookDeleted/{id}")
    public String deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/";
    }
    @GetMapping("/showEditBook/{id}")
    public String editBookById (@PathVariable("id") Long id,Model model){
        BookDto book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "update_book";
    }
}
