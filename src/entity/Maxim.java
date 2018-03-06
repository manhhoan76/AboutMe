package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Maxim {
	private int id_maxim;
	@NotEmpty(message="Không được để trống")
	private String author;
	@NotEmpty(message="Không được để trống")
	private String content;
	private String picture;
	private int active;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Maxim(int id_maxim, String author, String content, String picture, int active, Timestamp date_create,
			Timestamp date_edit) {
		super();
		this.id_maxim = id_maxim;
		this.author = author;
		this.content = content;
		this.picture = picture;
		this.active = active;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Maxim() {
		super();
	}
	public int getId_maxim() {
		return id_maxim;
	}
	public void setId_maxim(int id_maxim) {
		this.id_maxim = id_maxim;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	
	
}
