package com.fsofter.home.controller;


import com.fsofter.home.model.User;
import com.fsofter.home.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "") String keyword,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size) {
        Page<User> userPage = userService.searchUsers(keyword, page, size);

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "users";
    }

    @GetMapping("/user/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        return "user_form";
    }

    @PostMapping("/confirm")
    public String confirmUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user_form"; // Nếu có lỗi, quay lại form nhập
        }
        model.addAttribute("user", user);
        return "user_confirm"; // Chuyển đến trang xác nhận nếu dữ liệu hợp lệ
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "User đã được lưu thành công!");
        return "redirect:/users"; // Chuyển về danh sách sau khi lưu
    }


}
