package controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.JobDao;
import model.Job;

@Controller
public class CreateJobController {
	@Autowired
	public JobDao jobDao;
	
	
	@RequestMapping(value="/CreateJob", method=RequestMethod.GET)
	public ModelAndView createjob(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView("AddJob");
		return mav;
		
}
	@RequestMapping(value="/AddJobProcess", method=RequestMethod.GET)
	public ModelAndView addjob(HttpServletRequest request, HttpServletResponse response, Job job) {
		HttpSession session = request.getSession();
		String c = (String) session.getAttribute("id");
		System.out.println(c);
		request.setAttribute("id", c);
		jobDao.addJob(job);
		ModelAndView mav=new ModelAndView("RecruiterHome");
		return mav;
	
	}
}
