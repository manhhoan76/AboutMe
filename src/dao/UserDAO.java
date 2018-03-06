package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Ads;
import entity.Job;
import entity.User;
import entity.UserEdit;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM users  order by users.id_user desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<User>(User.class));
	}

	public List<User> getItems() {
		String sql = "SELECT * FROM users   order by id_user desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	public User getItem(int idU) {
		String sql = "SELECT * FROM users  where id_user=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idU }, new BeanPropertyRowMapper<User>(User.class));
	}
	public int editItem(UserEdit objUser) {
		String sql = "update users set  username=?, password=?, fullname=?, email=?, role_id=?, picture=?, date_create=? where id_user=? ";
		return jdbcTemplate.update(sql,
				new Object[] {objUser.getUsername(), objUser.getPassword(), objUser.getFullname(), objUser.getEmail(), objUser.getRole_id(), objUser.getPicture(), objUser.getDate_create(), objUser.getId_user()  });
	}
	public int delItem(int idUser) {
		String sql = "delete from users	where id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in ("+result+")";
		return jdbcTemplate.update(sql);
	}
	
	public int countSumUser() {
		String sql = "SELECT COUNT(*) AS sumUser FROM users   ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public String checkUsername (String username){
		String sql ="select username from users where username=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {username}, String.class);
	}
	public User getItem (String username){
		String sql ="select * from users where username=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {username},new BeanPropertyRowMapper<User>(User.class) );
	}
	public int addItem(User objUser) {
		String sql = "insert into users	(username, password, fullname, enable, email, role_id, picture) values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {objUser.getUsername(), objUser.getPassword(), objUser.getFullname(), objUser.getEnable(), objUser.getEmail(), objUser.getRole_id(), objUser.getPicture()});
	}

	public int active(Timestamp date, int idUser) {
		String sql = "update users set enable=1,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}

	public int block(Timestamp date, int idUser) {
		String sql = "update users set enable=0,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}

	public List<User> getItemsSearch(String key, int offset, int row_count) {
		String sql = "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lands.lname like '%"+key+"%'  || lands.description like '%"+key+"%' order by lid desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count },
				new BeanPropertyRowMapper<User>(User.class));
	}
	public int countSumSearch(String key) {
		String sql = "SELECT COUNT(*) AS sumpage FROM lands as l inner join categories as c on c.cid=l.cid where l.lname like '%"+key+"%'  || l.description like '%"+key+"%' ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
