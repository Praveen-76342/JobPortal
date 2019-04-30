package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.JobDao;
import model.Job;
@Controller
public class ApplyController {
	
		@Autowired
		JobDao jobDao;
		@RequestMapping(value="/applyjob", method=RequestMethod.GET)
		public ModelAndView applyJob(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav=new ModelAndView("apply");
			return mav;
		}

	}

