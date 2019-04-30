package dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Login;
import model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void register(User user) {
		String sql="insert into user values(?,?,?,?,?)";
		String securepass=user.getPassword();
		String hashpass=pass(securepass);
		jdbcTemplate.update(sql,new Object[] {user.getUsername(), hashpass, user.getFullname(), user.getNumber(), user.getEmail()});
	}
	private static String pass(String securepass) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(securepass);
		System.out.println(hashedPassword);
		return hashedPassword;
	}
	public User validateUser(Login login) {

		String sql="select * from user where username='"+ login.getUsername() + "'";
		List<User> list=jdbcTemplate.query(sql,new UserMapper());
		
		if(list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	public User apply(HttpServletRequest request, HttpServletResponse response)
	           throws IOException, ServletException {

		HttpSession session = request.getSession();
		String uname=(String) session.getAttribute("id");
		String sql="select * from user where username='"+ uname + "'";
		return null;
	}
	@Override
	public User apply() {
		// TODO Auto-generated method stub
		return null;
	}

}
class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user =new User();
		user.setUsername(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setFullname(rs.getString(3));
		user.setNumber(rs.getString(4));
		user.setEmail(rs.getString(5));
		
		return user;
	}
	
	

	}


