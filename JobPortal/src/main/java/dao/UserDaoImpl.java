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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String sql="select * from user where username='"+ login.getUsername() + "' and password='"+login.getPassword()+"'";
		List<User> user=jdbcTemplate.query(sql,new UserMapper());
		return user.size() > 0 ? user.get(0) : null;
	}

}
class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user =new User();
		Login login=new Login();
		user.setUsername(rs.getString("username"));
		String hashpass=rs.getString("password");
		System.out.println("hashedpass"+hashpass);
		String origpass=login.getPassword();
		String password=depass(hashpass,origpass);
		System.out.println("origpass"+origpass);
		user.setPassword(password);
		user.setFullname(rs.getString("fullname"));
		user.setNumber(rs.getString("number"));
		user.setEmail(rs.getString("email"));
		return user;
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
