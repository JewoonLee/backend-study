/*package kr.or.spring.instagram_clone.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession; 

import kr.or.spring.instagram_clone.dto.User;

import kr.or.spring.instagram_clone.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

public AdminController(UserService userService, PasswordEncoder passwordEncoder){
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
}
       @GetMapping(path="/loginform")
		public String loginform() {
			return "loginform";
		}
       @GetMapping("/loginerror")
       public String loginerror(@RequestParam("login_error")String loginError){
           return "/loginerror";
       }

       @GetMapping("/signup")
       public String signup(){
           return "/signup";
       }
           


		
       @PostMapping("/join")
       public String join(@ModelAttribute User user){
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           userService.addUser(user, false);
           return "redirect:/welcome";
       }
		
       @GetMapping(path="/logout")
		public String login(HttpSession session) {
			session.removeAttribute("isAdmin");
			return "redirect:/index";
		}

       }
   }*/
