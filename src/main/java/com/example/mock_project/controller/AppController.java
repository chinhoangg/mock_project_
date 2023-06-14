package com.example.mock_project.controller;

import com.example.mock_project.entities.User;
import com.example.mock_project.security.MyUserDetail;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Admin
 */
@Controller
public class AppController {
    @GetMapping("/")
    public String viewHome(@AuthenticationPrincipal MyUserDetail userDetail, Model model) {
        User user = userDetail.getUser();
        model.addAttribute("user",user);
        return "home-page";
    }

    @GetMapping("/login")
    public String loginPage() {
        //prevent user return back to login page if they already login to the system
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/process_register")
    public String createNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up";
    }
}
