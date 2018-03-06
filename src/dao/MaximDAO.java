package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Maxim;
import entity.User;

@Repository
public class MaximDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Maxim> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM maxim order by maxim.id_maxim desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Maxim>(Maxim.class));
	}

	public List<Maxim> getItems() {
		String sql = "SELECT * FROM maxim  where maxim.active=1 order by maxim.id_maxim desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Maxim>(Maxim.class));
	}

	public Maxim getItem(int idMa) {
		String sql = "SELECT * FROM maxim  where id_maxim=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idMa }, new BeanPropertyRowMapper<Maxim>(Maxim.class));
	}
	public int editItem(Maxim objMa) {
		String sql = "update maxim set author=?, content=?, picture=?, date_create=? where id_maxim=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objMa.getAuthor(), objMa.getContent(), objMa.getPicture(), objMa.getDate_create(), objMa.getId_maxim()});
	}
	public int delItem(int idUser) {
		String sql = "delete from maxim	where id_maxim=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in ("+result+")";
		return jdbcTemplate.update(sql);
	}
	
	public int countSumMaxim() {
		String sql = "SELECT COUNT(*) AS sumMaxim FROM maxim ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int addItem(Maxim objMaxim) {
		String sql = "insert into maxim	(author, content, picture, active) values (?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { objMaxim.getAuthor(), objMaxim.getContent(), objMaxim.getPicture(), objMaxim.getActive() });
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
