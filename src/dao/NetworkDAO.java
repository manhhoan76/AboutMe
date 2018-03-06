package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Ads;
import entity.Network;
import entity.User;

@Repository
public class NetworkDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Network> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM network order by network.id_network desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count },
				new BeanPropertyRowMapper<Network>(Network.class));
	}

	public List<Network> getItems() {
		String sql = "SELECT * FROM users WHERE users.enable =1  order by id_user desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Network>(Network.class));
	}

	public int delItem(int idUser) {
		String sql = "delete from network	where id_network=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumNetwork() {
		String sql = "SELECT COUNT(*) AS sumNetwork FROM network ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Network getItem(int idNet) {
		String sql = "SELECT * FROM network  where id_network=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idNet }, new BeanPropertyRowMapper<Network>(Network.class));
	}
	public int editItem(Network objNet) {
		String sql = "update network set name=?, link=?, date_create=? where id_network=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objNet.getName(), objNet.getLink(), objNet.getDate_create(), objNet.getId_network()});
	}
	public int addItem(Network objNet) {
		String sql = "insert into network (name, link) values (?,?) ";
		return jdbcTemplate.update(sql, new Object[] { objNet.getName(), objNet.getLink() });
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
		String sql = "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lands.lname like '%"
				+ key + "%'  || lands.description like '%" + key + "%' order by lid desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<User>(User.class));
	}

	public int countSumSearch(String key) {
		String sql = "SELECT COUNT(*) AS sumpage FROM lands as l inner join categories as c on c.cid=l.cid where l.lname like '%"
				+ key + "%'  || l.description like '%" + key + "%' ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
