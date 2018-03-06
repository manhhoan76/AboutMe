package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Job;
import entity.News;
import entity.Project;

@Repository
public class ProjectDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Project> getItems(int offset, int row_count) {
		String sql = "SELECT * FROM project order by project.id_project desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Project>(Project.class));
	}
	public List<Project> getItems() {
		String sql = "SELECT * FROM project order by project.id_project desc ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Project>(Project.class));
	}
	public Project getItem(int idProject) {
		String sql = "SELECT * FROM project  where id_project=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idProject }, new BeanPropertyRowMapper<Project>(Project.class));
	}
	public int editItem(Project objProject) {
		String sql = "update project set name=?, preview_text=?, detail=?, link=?, time=?, picture=?, date_create=? where id_project=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objProject.getName(), objProject.getPreview_text(), objProject.getDetail(), objProject.getLink(), objProject.getTime(), objProject.getPicture(), objProject.getDate_create(), objProject.getId_project()});
	}
	
	public List<Project> getItemsOther(int id_pro) {
		String sql = "SELECT *  FROM project WHERE project.id_project != ? order by project.id_project DESC limit 4";
		return jdbcTemplate.query(sql, new Object[] { id_pro }, new BeanPropertyRowMapper<Project>(Project.class));
	}

	public int delItem(int idUser) {
		String sql = "delete from project	where id_project=? ";
		return jdbcTemplate.update(sql, new Object[] { idUser });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in ("+result+")";
		return jdbcTemplate.update(sql);
	}
	
	public int countSumProject() {
		String sql = "SELECT COUNT(*) AS sumProject FROM project ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int addItem(Project objProject) {
		String sql = "insert into project	(name, preview_text, detail, link, time, picture) values (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {objProject.getName(), objProject.getPreview_text(), objProject.getDetail(), objProject.getLink(), objProject.getTime(), objProject.getPicture() });
	}


	public int active(Timestamp date, int idUser) {
		String sql = "update users set enable=1,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}

	public int block(Timestamp date, int idUser) {
		String sql = "update users set enable=0,date_create=? where users.id_user=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}

	public int countSumSearch(String key) {
		String sql = "SELECT COUNT(*) AS sumpage FROM lands as l inner join categories as c on c.cid=l.cid where l.lname like '%"+key+"%'  || l.description like '%"+key+"%' ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
