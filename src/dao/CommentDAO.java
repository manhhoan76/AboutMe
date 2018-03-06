package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.Ads;
import entity.Comment;

@Repository
public class CommentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Comment> getItems() {
		String sql = "SELECT id_comment, comment.name, email, content, parent_id, comment.id_news, comment.date_create, comment.active, news.name as name_new FROM comment INNER JOIN news ON news.id_news = comment.id_news ORDER BY id_comment DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class));
	}
	public List<Comment> getItemsByIdNew( int idNew) {
		String sql = "SELECT id_comment, comment.name, email, content, parent_id, comment.id_news, comment.date_create, comment.active, news.name as name_new FROM comment INNER JOIN news ON news.id_news = comment.id_news where comment.id_news=? && comment.active=1 ORDER BY id_comment DESC";
		return jdbcTemplate.query(sql, new Object[] { idNew }, new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	public Comment getItem(int idCom) {
		String sql = "SELECT * FROM comment  where id_comment=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idCom }, new BeanPropertyRowMapper<Comment>(Comment.class));
	}
	public int active(Timestamp date, int idUser) {
		String sql = "update comment set active=1,date_create=? where comment.id_comment=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}
	public int block(Timestamp date, int idUser) {
		String sql = "update comment set active=0,date_create=? where comment.id_comment=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idUser });
	}
	public List<Comment> getItems(int offset, int row_count) {
		String sql = "SELECT id_comment, comment.name, email, content, parent_id, comment.id_news, comment.date_create, comment.active, news.name as name_new FROM comment INNER JOIN news ON news.id_news = comment.id_news ORDER BY id_comment DESC limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	public int delItem(int idComment) {
		String sql = "delete from comment	where id_comment=? ";
		return jdbcTemplate.update(sql, new Object[] { idComment });
	}

	public int multildel(String result) {
		String sql = "delete from Commentegory	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumComment() {
		String sql = "SELECT COUNT(*) AS sumComment FROM comment ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
