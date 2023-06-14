package com.example.mock_project.controller;

import com.example.mock_project.repository.UserRepository;
import com.example.mock_project.security.MyUserDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.mock_project.entities.Role;
import com.example.mock_project.entities.User;
import com.example.mock_project.repository.RoleRepository;
import com.example.mock_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @author Admin
 */
@Controller
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute(name = "user") User user, HttpServletRequest request) throws UnsupportedEncodingException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.findByName("ROLE_USER");
        user.addRole(roleUser);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/user-profile/{id}")
    public String viewUserProfile(@PathVariable Integer id, @AuthenticationPrincipal MyUserDetail userDetail, Model model) {
        User user = userDetail.getUser();
        model.addAttribute("user",user);
        User userByID = userService.getUserByID(id);
        model.addAttribute("userByID", userByID);
        return "user-profile";
    }
    @GetMapping("/user-profile/edit/{id}")
    public String viewUserProfileEdit(@PathVariable Integer id, @AuthenticationPrincipal MyUserDetail userDetail, Model model) {
        User user = userDetail.getUser();
        model.addAttribute("user",user);
        User userByID = userService.getUserByID(id);
        model.addAttribute("userByID", userByID);
        return "edit_user_profile";
    }

    @GetMapping("/user-list-dashboard")
    public String listUser(Model model) {
        List<User> listUser = userService.findAllUser();
        model.addAttribute("listUser", listUser);
        return "user-list-dashboard";
    }
    @PostMapping ("/user-profile/save")
    public  String saveUserEntity(User user){
      userService.updateUserEntity(user.getId(),user);
        return "redirect:/";

    }
}

