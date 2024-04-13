package com.tmdt.handmade.controller;

import com.tmdt.handmade.dto.account.UserDTO;
import com.tmdt.handmade.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model){
        if(userService.existsByEmail(user.getEmail())) {
            result.reject("email", null, "There is already an account registered with the same email!");
        }

        // Xử lý lỗi từ phía service (nếu có)
        if(!result.hasErrors()) {
            // Xử lý đăng ký người dùng
            try {
                userService.saveOrUpdate(user);
                return "redirect:/home"; // Nếu đăng ký thành công, chuyển hướng đến trang home
            } catch (Exception e) {
                result.reject("registration.error", e.getMessage()); // Xử lý lỗi nếu có lỗi từ phía service
            }
        }

        // Nếu có lỗi xảy ra, trả về trang đăng ký và hiển thị thông tin lỗi
        model.addAttribute("user",user);
        return "signup";
    }
}
