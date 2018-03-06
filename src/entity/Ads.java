package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Ads {
	private int id_ads;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String link;
	private String picture;
	private int active;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Ads(int id_ads, String name, String link, String picture, int active, Timestamp date_create,
			Timestamp date_edit) {
		super();
		this.id_ads = id_ads;
		this.name = name;
		this.link = link;
		this.picture = picture; 
		this.active = active;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Ads() {
		super();
	}
	public int getId_ads() {
		return id_ads;
	}
	public void setId_ads(int id_ads) {
		this.id_ads = id_ads;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
