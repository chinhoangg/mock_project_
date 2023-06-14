package com.example.mock_project.controller;

import com.example.mock_project.entities.Book;
import com.example.mock_project.entities.BookCase;
import com.example.mock_project.entities.User;
import com.example.mock_project.repository.UserRepository;
import com.example.mock_project.security.MyUserDetail;
import com.example.mock_project.service.BookCaseService;
import com.example.mock_project.service.BookService;
import com.example.mock_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
@Controller
public class BookCaseController {
    @Autowired
    private BookCaseService bookCaseService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/my-book-case")
    public String showAllBookCase(@AuthenticationPrincipal MyUserDetail userDetail, Model model) {
        User users = userDetail.getUser();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUserName(auth.getName());
        List<BookCase> bookCases = bookCaseService.getBookCaseByUserId(user.getId());
        ArrayList<String> listTitle = new ArrayList<>();
        for (BookCase bookCase:bookCases
             ) {
            listTitle.add(bookCase.getName());
        }
        bookService.getListBookByBookTitle(listTitle);
        model.addAttribute("listBooks", bookService.getListBookByBookTitle(listTitle));
        model.addAttribute("users", user);
        model.addAttribute("user", users);
        return "my_bookcase";
    }

    @GetMapping("/my-book-case/add/{id}")
    public String addToBookcase(@PathVariable("id") Integer bookId) {
        Book myBooks = bookService.getBookById(bookId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUserName(auth.getName());
        BookCase bookCase = new BookCase();
        bookCase.setName(myBooks.getBookTitle());
        bookCase.setUserId(user.getId());
        bookCaseService.addBookCaseItem(bookCase);
        myBooks.addBookCase(bookCase);
        bookService.saveBook(myBooks);
        return "redirect:/product";
    }

    @GetMapping("/my-book-case/delete/{name}")
    public String deleteBookCase(@PathVariable("name") String  bookName) {
        bookCaseService.deleteBookCaseByName(bookName);
        return "redirect:/my-book-case";
    }
}
