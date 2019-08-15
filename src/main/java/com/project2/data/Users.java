package com.project2.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@NotBlank
	private String username;
	@Column
	@NotBlank
	private String password;
	@Column
	@NotBlank
	private String usertype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getUsertype() {
		return this.usertype;
	}
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype + "]";
	}
	public Users() {
	}
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
