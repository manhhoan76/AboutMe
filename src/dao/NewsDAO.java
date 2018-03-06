package dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entity.News;

@Repository
public class NewsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<News> getItems(int offset, int row_count) {
		String sql = "SELECT id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden = 0  order by news.id_news desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItems() {
		String sql = "SELECT id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden = 0  order by lid desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItemsByCid(int cid) {
		String sql = "SELECT id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden=0 && news.id_cat=? && news.active=1 order by news.id_news desc ";
		return jdbcTemplate.query(sql, new Object[] { cid },
				new BeanPropertyRowMapper<News>(News.class));
	}
	public List<News> getItemsMostView() {
		String sql = "select id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden = 0 && news.active=1   order by news.count_number desc limit 3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}
	public List<News> getNew() {
		String sql = "select id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden = 0 && news.active=1 order by news.id_news desc limit 3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItemsSameCid(int cid, int lid) {
		String sql = "SELECT id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat WHERE news.hiden = 0 and news.id_cat=? and news.id_news != ? order by news.id_news DESC limit 4";
		return jdbcTemplate.query(sql, new Object[] { cid, lid }, new BeanPropertyRowMapper<News>(News.class));
	}

	public int delItem(int idNews) {
		String sql = "delete from news	where id_news=? ";
		return jdbcTemplate.update(sql, new Object[] { idNews });
	}

	public int multildel(String result) {
		String sql = "delete from lands	where lid in (" + result + ")";
		return jdbcTemplate.update(sql);
	}

	public int countSumNews() {
		String sql = "SELECT COUNT(*) AS sumpage FROM news as n inner join category as c on c.id_cat=n.id_cat where n.hiden=0  ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public News getItem(int idNews) {
		String sql = "SELECT id_news,news.name, preview_text, detail_text, news.id_cat, picture, count_number, active, id_user, news.hiden, news.date_create, news.date_edit, category.name AS cname  FROM news INNER JOIN category ON news.id_cat = category.id_cat where id_news=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { idNews }, new BeanPropertyRowMapper<News>(News.class));
	}

	public int editItem(News objNew) {
		String sql = "update news set name=?, preview_text=?, detail_text=?, id_cat=?, picture=?, date_create=? 	where id_news=? ";
		return jdbcTemplate.update(sql,
				new Object[] { objNew.getName(), objNew.getPreview_text(), objNew.getDetail_text(), objNew.getId_cat(), objNew.getPicture(), objNew.getDate_create(), objNew.getId_news() });
	}

	/*
	 * public List<NumberLands> countNewsByCid() { String sql =
	 * "SELECT categories.cid,categories.cname,COUNT(lands.cid) AS number FROM lands INNER JOIN categories ON lands.cid=categories.cid GROUP BY categories.cid ORDER BY number DESC"
	 * ; return jdbcTemplate.query(sql, new
	 * BeanPropertyRowMapper<NumberLands>(NumberLands.class)); }
	 * 
	 * public int editItem(News objNew) { String sql =
	 * "update lands set lname =?, description =?, date_create =?, cid =?, picture =?, area =?, address =?, is_slide=?	where lid=? "
	 * ; return jdbcTemplate.update(sql, new Object[] { objNew.getLname(),
	 * objNew.getDescription(), objNew.getDate_create(), objNew.getCid(),
	 * objNew.getPicture(), objNew.getArea(), objNew.getAddress(),
	 * objNew.getIs_slide(), objNew.getLid() }); }
	 * 
	 * public News getItem(int idNews) { String sql =
	 * "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lid=?"
	 * ; return jdbcTemplate.queryForObject(sql, new Object[] { idNews }, new
	 * BeanPropertyRowMapper<News>(News.class)); }
	 * 
	 * public int addItem(News objNew) { String sql =
	 * "insert into lands	(lname, description, date_create, cid, picture, area, address, count_views, is_slide) values (?,?,?,?,?,?,?,?,?) "
	 * ; return jdbcTemplate.update(sql, new Object[] { objNew.getLname(),
	 * objNew.getDescription(), objNew.getDate_create(), objNew.getCid(),
	 * objNew.getPicture(), objNew.getArea(), objNew.getAddress(),
	 * objNew.getCount_views(), objNew.getIs_slide() }); }
	 */
	public int addItem(News objNew) {
		String sql = "insert into news	(name, preview_text, detail_text, id_cat, picture, count_number, active, id_user, hiden) values (?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { objNew.getName(), objNew.getPreview_text(), objNew.getDetail_text(), objNew.getId_cat(),
						objNew.getPicture(), objNew.getCount_number(), objNew.getActive(), objNew.getId_user(),
						objNew.getHiden() });
	}

	public int active(Timestamp date, int idNews) {
		String sql = "update news set active=1,date_create=? where news.id_news=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idNews });
	}

	public int block(Timestamp date, int idNews) {
		String sql = "update news set active=0,date_create=? where news.id_news=? ";
		return jdbcTemplate.update(sql, new Object[] { date, idNews });
	}


	public int updateView(Timestamp date, int view, int id) {
		String sql = "update news set count_number=?,date_create=? where news.id_news=? ";
		return jdbcTemplate.update(sql, new Object[] { view, date, id });
	}

	public List<News> getItemsSearch(String key, int offset, int row_count) {
		String sql = "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lands.lname like '%"
				+ key + "%'  || lands.description like '%" + key + "%' order by lid desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItemsSearchByCid(String key, int cid, int offset, int row_count) {
		String sql = "SELECT lid, lname, description, date_create, lands.cid, picture, area, address, count_views, is_slide, categories.cname FROM lands INNER JOIN categories ON categories.cid=lands.cid where lands.cid=? && (lands.lname like '%"
				+ key + "%'  || lands.description like '%" + key + "%') order by lid desc limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, row_count }, new BeanPropertyRowMapper<News>(News.class));
	}

	public int countSumSearch(String key) {
		String sql = "SELECT COUNT(*) AS sumpage FROM lands as l inner join categories as c on c.cid=l.cid where l.lname like '%"
				+ key + "%'  || l.description like '%" + key + "%' ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	/*
	 * public int countNewsByCid (int cid){ String sql
	 * ="SELECT COUNT(*) as num FROM lands WHERE cid=?"; return
	 * jdbcTemplate.query(sql,new Object[] {cid}); }
	 */

}
