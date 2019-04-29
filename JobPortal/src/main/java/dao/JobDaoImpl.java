package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Job;
import model.User;

public  class JobDaoImpl implements JobDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public Job search(Job job) {
		String sql="select * from jobs";
List<Job> list=jdbcTemplate.query(sql,new JobMapper());
		
		if(list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

}
class JobMapper implements RowMapper<Job>{

	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
		Job job =new Job();
		job.setName(rs.getString(1));
		job.setDescription(rs.getString(2));
		job.setSkills(rs.getString(3));

		
		return job;
	}
	
	
	}


