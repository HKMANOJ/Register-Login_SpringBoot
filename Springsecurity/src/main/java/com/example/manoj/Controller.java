package com.example.manoj;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;






@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private Repository repo;

	@Autowired
	private UserServiceImp ser;


	@RequestMapping("/")
	public String Home() {
		return "home.html";
	}

	@RequestMapping("/regi")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "NewFile.html";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute User user) {
		//  User us=new User();
		ser.saveData(user);

		return new ModelAndView("redirect:/logins");
	}
	@RequestMapping("/users")
	public String listUsers() {

		return "Welcome.html";
	}

	@RequestMapping("/login")
	public String Checklogin(@RequestParam("username") String username,@RequestParam("password") String password,Model model) {
		User u=null;
		try {
			u=repo.findByUsernamePassword(username, password);
		} catch (Exception e) {
			System.out.println("Not Found......!");
			return ("redirect:/logins");
		}
		if(u!=null) {
			model.addAttribute("username", username);
			return ("redirect:/addform");
		}
		return ("redirect:/logins");
		
	}
	@RequestMapping("/addform")
	public String Welcome() {
		return "Welcome.html";
	}

	@RequestMapping("/logins")
	public String Login() {
		return "login.html";
	}

	


}
