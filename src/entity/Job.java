package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Job {
	private int id_job;
	private String name;
	@NotEmpty(message="Không được để trống")
	private String content;
	@NotEmpty(message="Không được để trống")
	private String time;
	private String picture;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Job(int id_job, String name, String content, String time, String picture, Timestamp date_create,
			Timestamp date_edit) {
		super();
		this.id_job = id_job;
		this.name = name;
		this.content = content;
		this.time = time;
		this.picture = picture;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Job() {
		super();
	}
	public int getId_job() {
		return id_job;
	}
	public void setId_job(int id_job) {
		this.id_job = id_job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
