package com.example.mock_project.controller;

import com.example.mock_project.service.BookCaseService;
import com.example.mock_project.service.BookService;
import com.example.mock_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCaseService bookCaseService;
    @GetMapping("/admin-home")
    public String viewHomeDashBoards(Model model) {
        long countUser = userService.countUsers();
        long countBook = bookService.countBook();
        long countBookCase = bookCaseService.countBookCase();
        model.addAttribute("countUser",countUser);
        model.addAttribute("countBook",countBook);
        model.addAttribute("countBookCase",countBookCase);
        return "home_dash_boards";
    }
}