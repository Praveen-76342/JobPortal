package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Job;
import model.Login;
import service.JobService;
import service.UserService;

public class SearchJobsController {
	@Autowired
	JobService jobService;
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("search");
		mav.addObject("job",new Job());
		return mav;
	}

}
