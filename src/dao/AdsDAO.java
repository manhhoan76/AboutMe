package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Ads;
import entity.News;
import entity.User;

@Repository
public class AdsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Ads> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM ads order by ads.id_ads desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Ads>(Ads.class));
	}

	public List<Ads> getItems() {
		String sql = "SELECT * FROM ads where ads.active=1 order by ads.id_ads desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Ads>(Ads.class));
	}


	public int multildel(String result) {
		String sql = "delete from lands	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumAds() {
		String sql = "SELECT COUNT(*) AS sumAds FROM ads ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public Ads getItem(int idAds) {
		String sql = "SELECT * FROM ads  where id_ads=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idAds }, new BeanPropertyRowMapper<Ads>(Ads.class));
	}
	public int editItem(Ads objAds) {
		String sql = "update ads set name=?, link=?, picture=?, active=?, date_create=? where id_ads=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objAds.getName(), objAds.getLink(), objAds.getPicture(),objAds.getActive(), objAds.getDate_create(), objAds.getId_ads() });
	}
	public int addItem(Ads objAds) {
		String sql = "insert into ads (name, link, picture, active) values (?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { objAds.getName(), objAds.getLink(), objAds.getPicture(), objAds.getActive() });
	}

	public int active(Timestamp date, int idUser) {
		String sql = "update users set enable=1,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}
	public int block(Timestamp date, int idUser) {
		String sql = "update users set enable=0,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}
	public int delItem(int idUser) {
		String sql = "delete from users	where id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
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
