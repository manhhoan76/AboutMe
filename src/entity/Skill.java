package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Skill {
	private int id_skill;
	@NotEmpty(message="Không được để trống")
	private String name;
	private int percent;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Skill(int id_skill, String name, int percent, Timestamp date_create, Timestamp date_edit) {
		super();
		this.id_skill = id_skill;
		this.name = name;
		this.percent = percent;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Skill() {
		super();
	}
	public int getId_skill() {
		return id_skill;
	}
	public void setId_skill(int id_skill) {
		this.id_skill = id_skill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
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
