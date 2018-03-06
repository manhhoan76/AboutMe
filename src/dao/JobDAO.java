package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Ads;
import entity.Job;
import entity.News;
import entity.User;

@Repository
public class JobDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Job> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM job order by job.id_job desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Job>(Job.class));
	}
	public List<Job> getItems() {
		String sql = "SELECT * FROM job order by job.id_job";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Job>(Job.class));
	}
	public Job getItem(int idJob) {
		String sql = "SELECT * FROM job  where id_job=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idJob }, new BeanPropertyRowMapper<Job>(Job.class));
	}
	public int editItem(Job objJob) {
		String sql = "update job set name=?,content=?, time=?, picture=?,date_create=? where id_job=? ";
		return jdbcTemplate.update(sql,
				new Object[] {objJob.getName(), objJob.getContent(), objJob.getTime(), objJob.getPicture(), objJob.getDate_create(), objJob.getId_job()});
	}
	public int addItem(Job objJob) {
		String sql = "insert into job (content, time, picture) values (?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { objJob.getContent(), objJob.getTime(), objJob.getPicture() });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in ("+result+")";
		return jdbcTemplate.update(sql);
	}
	
	public int countSumjob() {
		String sql = "SELECT COUNT(*) AS sumjob FROM job ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public int active(Timestamp date, int idUser) {
		String sql = "update users set enable=1,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}

	public int delItem(int idJob) {
		String sql = "delete from job	where id_job=? ";
		return jdbcTemplate.update(sql, new Object[] { idJob });
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
