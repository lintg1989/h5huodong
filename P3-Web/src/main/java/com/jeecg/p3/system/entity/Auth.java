/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.io.Serializable;

public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String authId;
	private String authContr;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthContr() {
		return this.authContr;
	}

	public void setAuthContr(String authContr) {
		this.authContr = authContr;
	}

	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String toString() {
		return "Auth [userId=" + this.userId + ", authId=" + this.authId + ", authContr=" + this.authContr + "]";
	}
}