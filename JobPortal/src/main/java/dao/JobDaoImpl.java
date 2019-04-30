package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Job;
import model.Recruiter;
import model.User;

public  class JobDaoImpl implements JobDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	RecruiterDao recruiterDao;
	public List<Job> jobList() {
		String sql="select * from jobs";
		
		List<Job> list=jdbcTemplate.query(sql,new RowMapper<Job>() {
			
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setCname(rs.getString(1));
				job.setName(rs.getString(2));
				job.setDescription(rs.getString(3));
				job.setSkills(rs.getString(4));
				System.out.println(job.getName());
				return job;
				}
		}); 
	return list;
	}
	
	
	public Job addJob(Job job) {
		//String c = sess();
		System.out.println(job.getCname());
		String sql1="insert into jobs values(?,?,?,?)";
		jdbcTemplate.update(sql1,new Object[] {job.getCname(), job.getName(),job.getDescription(),job.getSkills()});
		
		return null;
	}

//	private String sess(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		 String c = (String) session.getAttribute("id");
//			return c;
//	}


	
	
}




