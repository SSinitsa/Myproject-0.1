package com.ssinitsa.training.culinary.datamodel;

import java.sql.Timestamp;

public class User {
	private Integer id;
	private String login;
	private String password;
	private Integer detailsId;
	private Timestamp registrated;

	public Timestamp getRegistrated() {
		return registrated;
	}

	public void setRegistrated(Timestamp registrated) {
		this.registrated = registrated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

}
