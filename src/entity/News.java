package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class News {
	private int id_news;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String preview_text;
	@NotEmpty(message="Không được để trống")
	private String detail_text;
	private int id_cat;
	private String picture;
	private int count_number;
	private int active;
	private int id_user;
	private int hiden;
	private Timestamp date_create;
	private Timestamp date_edit;
	private String cname;
	public News(int id_news, String name, String preview_text, String detail_text, int id_cat, String picture,
			int count_number, int active, int id_user, int hiden, Timestamp date_create, Timestamp date_edit,
			String cname) {
		super();
		this.id_news = id_news;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.id_cat = id_cat;
		this.picture = picture;
		this.count_number = count_number;
		this.active = active;
		this.id_user = id_user;
		this.hiden = hiden;
		this.date_create = date_create;
		this.date_edit = date_edit;
		this.cname = cname;
	}
	public News() {
		super();
	}
	public int getId_news() {
		return id_news;
	}
	public void setId_news(int id_news) {
		this.id_news = id_news;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview_text() {
		return preview_text;
	}
	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}
	public String getDetail_text() {
		return detail_text;
	}
	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCount_number() {
		return count_number;
	}
	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getHiden() {
		return hiden;
	}
	public void setHiden(int hiden) {
		this.hiden = hiden;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public Timestamp getDate_edit() {
		return date_edit;
	}
	public void setDate_edit(Timestamp date_edit) {
		this.date_edit = date_edit;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
