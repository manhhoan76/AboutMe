package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Contact {
	private int id_contact;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String email;
	@NotEmpty(message="Không được để trống")
	private String content;
	private Timestamp date_create;
	private int readed;
	public Contact(int id_contact, String name, String email, String content, Timestamp date_create, int readed) {
		super();
		this.id_contact = id_contact;
		this.name = name;
		this.email = email;
		this.content = content;
		this.date_create = date_create;
		this.readed = readed;
	}
	public Contact() {
		super();
	}
	public int getId_contact() {
		return id_contact;
	}
	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
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
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public int getReaded() {
		return readed;
	}
	public void setReaded(int readed) {
		this.readed = readed;
	}
	
}
