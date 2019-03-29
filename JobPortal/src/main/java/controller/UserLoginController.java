package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Login;
import model.User;
import service.UserService;

@Controller
public class UserLoginController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/userlogin", method=RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("userlogin");
		mav.addObject("login",new Login());
		return mav;
	}
	@RequestMapping(value="/userloginProcess", method=RequestMethod.POST)
	public ModelAndView validUser(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute("login") Login login)
	{
		ModelAndView mav=null;
		User user=userService.validateUser(login);
		if(null !=user)
		{
			mav=new ModelAndView("welcome");
			mav.addObject("message","welcome" + "" +user.getFullname());
		}
		else
		{
			mav= new ModelAndView("userlogin");
			mav.addObject("message","Username or Password is wrong");
		}
		return mav;
		
	}

}
