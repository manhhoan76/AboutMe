package entity;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

public class Network {
	private int id_network;
	@NotEmpty(message="Không được để trống")
	private String name;
	@NotEmpty(message="Không được để trống")
	private String link;
	private Timestamp date_create;
	private Timestamp date_edit;
	public Network(int id_network, String name, String link, Timestamp date_create, Timestamp date_edit) {
		super();
		this.id_network = id_network;
		this.name = name;
		this.link = link;
		this.date_create = date_create;
		this.date_edit = date_edit;
	}
	public Network() {
		super();
	}
	public int getId_network() {
		return id_network;
	}
	public void setId_network(int id_network) {
		this.id_network = id_network;
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
