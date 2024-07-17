package com.LoginPageTask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.LoginPageTask.Entity.User;
import com.LoginPageTask.Service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login(Model m)
	{
		User user = new User();
		m.addAttribute("user", user);
		return "LOGINPAGE/login";
	}
	
	@GetMapping("/register")
	public String register(Model m)
	{
		User user = new User();
		m.addAttribute("user",user);
		return"REGISTERPAGE/register";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user)
	{
		userService.saveUser(user);
		return "redirect:/login";
	}
	
	@PostMapping("/home")
	public String  home(@ModelAttribute User user,Model m)
	
	{
		String mailId = user.getEmailId();
		
		User userDetails = userService.getUserByEmailId(mailId);
		m.addAttribute("userDetails", userDetails);
		return "HOMEPAGE/home";
		
	}
	
	
	

}
