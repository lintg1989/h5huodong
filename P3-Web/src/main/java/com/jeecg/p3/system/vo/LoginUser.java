/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.vo;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String password;
	private String userStat;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStat() {
		return this.userStat;
	}

	public void setUserStat(String userStat) {
		this.userStat = userStat;
	}

	public String toString() {
		return "LoginUser [userId=" + this.userId + ", userName=" + this.userName + ", userStat=" + this.userStat + "]";
	}
}