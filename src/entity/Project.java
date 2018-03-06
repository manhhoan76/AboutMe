package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Project {
	private int id_project;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String preview_text;
	@NotEmpty(message="Không được để trống")
	private String detail;
	@NotEmpty(message="Không được để trống")
	private String link;
	@NotEmpty(message="Không được để trống")
	private String time;
	private String picture;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Project(int id_project, String name, String preview_text, String detail, String link, String time,
			String picture, Timestamp date_create, Timestamp date_edit) {
		super();
		this.id_project = id_project;
		this.name = name;
		this.preview_text = preview_text;
		this.detail = detail;
		this.link = link;
		this.time = time;
		this.picture = picture;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Project() {
		super();
	}
	public int getId_project() {
		return id_project;
	}
	public void setId_project(int id_project) {
		this.id_project = id_project;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
