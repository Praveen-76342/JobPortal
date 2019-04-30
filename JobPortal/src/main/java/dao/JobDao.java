package dao;

import java.util.List;

import model.Job;

public interface JobDao {
	public List<Job> jobList();
	public Job addJob(Job job);
}
