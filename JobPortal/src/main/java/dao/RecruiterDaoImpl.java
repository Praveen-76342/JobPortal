package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.RecLogin;
import model.Recruiter;

public class RecruiterDaoImpl implements RecruiterDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void register(Recruiter recruiter) {
		String sql="insert into recruiter values(?,?,?,?,?)";
		String securepass=recruiter.getPassword();
		String hashpass=pass(securepass);
		jdbcTemplate.update(sql,new Object[] {recruiter.getUsername(), hashpass, recruiter.getCname(), recruiter.getNumber(), recruiter.getEmail()});
	}
	private String pass(String securepass) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(securepass);
		System.out.println(hashedPassword);
		return hashedPassword;
	}
	public Recruiter  validateRecruiter(RecLogin reclogin) {
		
		String sql="select * from recruiter where username='"+ reclogin.getUsername() + "' and password='"+reclogin.getPassword()+"'";
		List<Recruiter> recruiter=jdbcTemplate.query(sql,new RecruiterMapper());
		if (recruiter.size() > 0)
			return recruiter.get(0);
		else
			return null;
		
	}
}
class RecruiterMapper implements RowMapper<Recruiter>{

	public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Recruiter recruiter =new Recruiter();
		RecLogin reclogin=new RecLogin();
		recruiter.setUsername(rs.getString("username"));
		String hashpass=rs.getString("password");
		System.out.println("hashedpass"+hashpass);
		String origpass=reclogin.getPassword();
		String password=depass(hashpass,origpass);
		System.out.println("origpass"+origpass);
		recruiter.setPassword(password);
		recruiter.setCname(rs.getString("fullname"));
		recruiter.setNumber(rs.getString("number"));
		recruiter.setEmail(rs.getString("email"));
		return recruiter;
	}
	public static String depass(String hashpass, String origpass)
	{
		
		System.out.println("hashpass");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(hashpass,origpass))
		{
			return origpass;
		}
		else
		{
			return null;
		}


	}

}

