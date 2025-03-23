package com.fsofter.home.controller;


import com.fsofter.home.Exception.UserNotFoundException;
import com.fsofter.home.model.User;
import com.fsofter.home.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("Không tìm thấy user với ID: " + id);
        }
        model.addAttribute("user", user);
        return "edit_form"; // Trả về form cập nhật
    }

    @PostMapping("/user/edit/confirm")
    public String confirmUpdate(@Valid @ModelAttribute("user") User user,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit_form"; // Quay lại form nếu có lỗi
        }
        model.addAttribute("user", user);
        return "edit_confirm"; // Chuyển đến trang xác nhận
    }
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttrs) throws UserNotFoundException {
        userService.updateUser(user);
        redirectAttrs.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/users"; // Chuyển về danh sách user
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("message", "User "+id+" đã được xóa thành công!");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", "User "+id+" không tồn tại!");
        }
        return "redirect:/users";
    }
}
