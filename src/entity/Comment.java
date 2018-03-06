package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Comment {
	private int id_comment;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String email;
	@NotEmpty(message="Không được để trống")
	private String content;
	private int parent_id;
	private int id_news;
	private String name_new;
	private Timestamp date_create;
	private int active;
	public Comment(int id_comment, String name, String email, String content, int parent_id, int id_news,
			String name_new, Timestamp date_create, int active) {
		super();
		this.id_comment = id_comment;
		this.name = name;
		this.email = email;
		this.content = content;
		this.parent_id = parent_id;
		this.id_news = id_news;
		this.name_new = name_new;
		this.date_create = date_create;
		this.active = active;
	}
	public Comment() {
		super();
	}
	public int getId_comment() {
		return id_comment;
	}
	public void setId_comment(int id_comment) {
		this.id_comment = id_comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getId_news() {
		return id_news;
	}
	public void setId_news(int id_news) {
		this.id_news = id_news;
	}
	public String getName_new() {
		return name_new;
	}
	public void setName_new(String name_new) {
		this.name_new = name_new;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
}
