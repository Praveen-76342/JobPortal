package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.JobDao;
import model.Job;

public class JobServiceImpl implements JobService {

	@Autowired
	JobDao jobDao;
	public Job search(Job job) {
		// TODO Auto-generated method stub
		return jobDao.search(job);
	}


}
