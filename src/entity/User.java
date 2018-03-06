package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id_user;
	@NotEmpty(message="Không được để trống")
	private String username;
	@NotEmpty(message="Không được để trống")
	private String password;
	@NotEmpty(message="Không được để trống")
	private String fullname;
	private int enable;
	@NotEmpty(message="Không được để trống")
	@Email(message="Không đúng định dạng Email")
	private String email;
	private int role_id;
	private String picture;
	private Timestamp date_create;
	private Timestamp date_edit;
	public User(int id_user, String username, String password, String fullname, int enable, String email, int role_id,
			String picture, Timestamp date_create, Timestamp date_edit) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.enable = enable;
		this.email = email;
		this.role_id = role_id;
		this.picture = picture;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public User() {
		super();
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
