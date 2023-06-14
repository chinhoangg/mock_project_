package com.example.mock_project.controller;

import com.example.mock_project.entities.Book;
import com.example.mock_project.entities.User;
import com.example.mock_project.security.MyUserDetail;
import com.example.mock_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Admin
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/dashboard_book_list")
    public String listBook(Model model){
        List<Book> listBook = bookService.findAll();
        model.addAttribute("listBook",listBook);
        return "dashboard-book-list";
    }

    @GetMapping("/dashboard_book_list/add")
    public String showAddBookForm(Model model){
        model.addAttribute("book",new Book());
        return "dashboard_create_book";
    }

    @PostMapping ("/dashboard_book_list/save")
    public  String saveBookEntity(Book bookEntity){
        bookService.saveBook(bookEntity);
        return "redirect:/dashboard_book_list";

    }
    @GetMapping("/dashboard_book_list/edit/{id}")
    public String showBookEntityById(@PathVariable Integer id, Model model){
        Book bookEntity = bookService.getBookById(id);
        model.addAttribute("bookEntity",bookEntity);
        return "dashboard_edit_book";
    }
    @GetMapping("/dashboard_book_list/delete/{id}")
    public String deleteBookById(@PathVariable Integer id){
        bookService.deleteBookById(id);
        return "redirect:/dashboard_book_list";
    }
    @GetMapping("/detail-b/detail/{id}")
    public String showBookEnById(@PathVariable Integer id, Model model){
        Book bookEntity = bookService.getBookById(id);
        model.addAttribute("bookEntity",bookEntity);
        return "detail-book";
    }

    @PostMapping("/dashboard_book_list/update")
    public String showBookEntityById(Book bookEntity){
        bookService.updateBook(bookEntity.getId(),bookEntity);
        return "redirect:/dashboard_book_list";
    }
    @RequestMapping("/product")
    public String viewHomePage(Model model,@AuthenticationPrincipal MyUserDetail userDetail) {
        String keyword = null;
        return listByPages(model, 1,keyword,userDetail);
    }
    @RequestMapping(value = "/bookdetail", method = RequestMethod.GET)
    public String getBlogDetail(ModelMap modelMap, HttpServletRequest request) {
        //data send to html:ModelMap
        String bookIdStr = request.getParameter("bookid");
        System.out.println(bookIdStr);
        int bookid = Integer.parseInt(bookIdStr);
//        int blogId;
//        if (blogIdStr == null || !StringUtils.hasLength(blogIdStr)) {
//            return "redirect:/blogcontroller";
//        }
//        try {
//            blogId = Integer.parseInt(request.getParameter("blogid"));
//        } catch (NumberFormatException e) {
//            return "redirect:/blogcontroller";
//        }
        Book book = bookService.getBookById(bookid);
        modelMap.addAttribute("bookdetail", book);
     return "detail-book";
//    }
}
    @GetMapping("/page/{pageNumber}")
    public String listByPages(Model model,
                              @PathVariable(name = "pageNumber") int currentPage,
                              @Param("keyword") String keyword,
                              @AuthenticationPrincipal MyUserDetail userDetail) {
        System.out.println("============"+currentPage);
        Page<Book> page = bookService.listAll(currentPage, keyword);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Book> listBook = page.getContent();
        User user = userDetail.getUser();
        model.addAttribute("user",user);

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("listBook",listBook);
        model.addAttribute("keyword", keyword);

        return "products_list_book";
    }






}
