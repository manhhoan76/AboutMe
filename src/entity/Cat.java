package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Cat {
	private int id_cat;
	@NotEmpty(message="Không được để trống")
	private String name;
	private Timestamp date_create;
	private int hiden;
	private Timestamp date_edit;
	public Cat(int id_cat, String name, Timestamp date_create, int hiden, Timestamp date_edit) {
		super();
		this.id_cat = id_cat;
		this.name = name;
		this.date_create = date_create;
		this.hiden = hiden;
		this.date_edit = date_edit;
	}
	public Cat() {
		super();
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public int getHiden() {
		return hiden;
	}
	public void setHiden(int hiden) {
		this.hiden = hiden;
	}
	public Timestamp getDate_edit() {
		return date_edit;
	}
	public void setDate_edit(Timestamp date_edit) {
		this.date_edit = date_edit;
	}
	
	
}
