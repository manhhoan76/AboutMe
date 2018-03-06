package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Cat;
import entity.Network;

@Repository
public class CatDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cat> getItems() {
		String sql = "select * from category where hiden = 0";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cat>(Cat.class));
	}

	public List<Cat> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM category where hiden = 0  order by category.id_cat desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Cat>(Cat.class));
	}

	public int delItem(int idCat) {
		String sql = "delete from category	where id_cat=? ";
		return jdbcTemplate.update(sql, new Object[] { idCat });
	}
	public Cat getItem(int idCat) {
		String sql = "SELECT * FROM category  where id_cat=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idCat }, new BeanPropertyRowMapper<Cat>(Cat.class));
	}
	public Cat getItem(String nameCat) {
		String sql = "SELECT * FROM category  where name like ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { nameCat }, new BeanPropertyRowMapper<Cat>(Cat.class));
	}
	public int editItem(Cat objCat) {
		String sql = "update category set name=?, date_create=? where id_cat=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objCat.getName(), objCat.getDate_create(), objCat.getId_cat()});
	}
	public int addItem(Cat objCat) {
		String sql = "insert into category (name,hiden) values(?,0) ";
		return jdbcTemplate.update(sql, new Object[] { objCat.getName() });
	}
	public int multildel(String result) {
		String sql = "delete from category	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumCat() {
		String sql = "SELECT COUNT(*) AS sumCat FROM category where hiden = 0 ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
