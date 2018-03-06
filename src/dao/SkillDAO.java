package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Skill;
import entity.User;

@Repository
public class SkillDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Skill> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM skills order by skills.id_skill desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count },
				new BeanPropertyRowMapper<Skill>(Skill.class));
	}

	public List<Skill> getItems() {
		String sql = "SELECT * FROM skills  order by skills.id_skill desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Skill>(Skill.class));
	}

	public int delItem(int idUser) {
		String sql = "delete from skill	where id_skill=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumSkill() {
		String sql = "SELECT COUNT(*) AS sumSkill FROM skills ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int addItem(Skill objSkill) {
		String sql = "insert into skills (name, percent) values (?,?) ";
		return jdbcTemplate.update(sql, new Object[] { objSkill.getName(), objSkill.getPercent() });
	}
	/*
	 * public List<NumberLands> countUserByCid() { String sql =
	 * "SELECT categories.cid,categories.cname,COUNT(lands.cid) AS number FROM lands INNER JOIN categories ON lands.cid=categories.cid GROUP BY categories.cid ORDER BY number DESC"
	 * ; return jdbcTemplate.query(sql, new
	 * BeanPropertyRowMapper<NumberLands>(NumberLands.class)); }
	 * 
	 * public int editItem(User objNew) { String sql =
	 * "update lands set lname =?, description =?, date_create =?, cid =?, picture =?, area =?, address =?, is_slide=?	where lid=? "
	 * ; return jdbcTemplate.update(sql, new Object[] { objNew.getLname(),
	 * objNew.getDescription(), objNew.getDate_create(), objNew.getCid(),
	 * objNew.getPicture(), objNew.getArea(), objNew.getAddress(),
	 * objNew.getIs_slide(), objNew.getLid() }); }
	 * 
	 * public User getItem(int idUser) { String sql =
	 * "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lid=?"
	 * ; return jdbcTemplate.queryForObject(sql, new Object[] { idUser }, new
	 * BeanPropertyRowMapper<User>(User.class)); }
	 * 
	 * 
	 * }
	 */

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
