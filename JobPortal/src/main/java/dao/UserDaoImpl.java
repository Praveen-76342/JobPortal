package dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
		User user =new User();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String sql="select * from user where username='"+ login.getUsername() + "' and password='"+login.getPassword()+"'";
		List<User> list=jdbcTemplate.query(sql,new UserMapper());
		System.out.println(user.getPassword());
		System.out.println(login.getPassword());
		if(encoder.matches(user.getPassword(),login.getPassword()))
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

}
class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user =new User();
		Login login=new Login();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//if(encoder.matches(pass,securepass);
		String pass=login.getPassword();
		String securepass=rs.getString(2);
		user.setUsername(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setFullname(rs.getString(3));
		user.setNumber(rs.getString(4));
		user.setEmail(rs.getString(5));
		return user;
	}
	
	

	}


