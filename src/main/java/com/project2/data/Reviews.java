package com.project2.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//reviews(id, rating float, description text, username text, animename text)


@Entity
@Table(name = "reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@NotNull
	private float rating;
	@Column
	@NotBlank
	private String description;
	@Column
	@NotBlank
	private String username;
	@Column
	@NotBlank
	private String animename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAnimename() {
		return animename;
	}
	public void setAnimename(String animename) {
		this.animename = animename;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", rating=" + rating + ", description=" + description + ", username=" + username
				+ ", animename=" + animename + "]";
	}
	
	
}
