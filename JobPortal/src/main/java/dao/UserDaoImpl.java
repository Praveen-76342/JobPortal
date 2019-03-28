package dao;



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
		jdbcTemplate.update(sql,new Object[] {user.getUsername(), user.getPassword(), user.getFullname(), user.getNumber(), user.getEmail()});
	}

	public User validateUser(Login login) {
		String sql="select * from user where username='"+ login.getUsername() + "' and password='"+login.getPassword()+"'";
		List<User> user=jdbcTemplate.query(sql,new UserMapper());
		return user.size() > 0 ? user.get(0) : null;
	}

}
class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user =new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFullname(rs.getString("fullname"));
		user.setNumber(rs.getString("number"));
		user.setEmail(rs.getString("email"));
		return user;
	}
	
}
