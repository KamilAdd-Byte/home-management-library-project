package com.libraryproject.homemanagementlibraryproject.controller.impl;

import com.libraryproject.homemanagementlibraryproject.controller.BookController;
import com.libraryproject.homemanagementlibraryproject.entity.BookEntity;
import com.libraryproject.homemanagementlibraryproject.mapper.BookMapper;
import com.libraryproject.homemanagementlibraryproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/")
    public String getAllBooks (Model model){
        model.addAttribute("getAllBooks",bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm (Model model) {
        BookEntity book = new BookEntity();
        model.addAttribute("book",book);
        return "new_book";
    }

    @PostMapping("/save_book")
    public String saveBook (@ModelAttribute ("book") BookEntity bookEntity) {
        bookService.addBook(bookMapper.mapToDto(bookEntity));
        return "new_book";
    }
}
