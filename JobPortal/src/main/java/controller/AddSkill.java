package controller;


	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;



	import service.UserService;

	@Controller
	public class AddSkill {
		@Autowired
		UserService userService;
		@RequestMapping(value="/addskill", method=RequestMethod.GET)
		public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav=new ModelAndView("addskill");
			return mav;
		}
	}
