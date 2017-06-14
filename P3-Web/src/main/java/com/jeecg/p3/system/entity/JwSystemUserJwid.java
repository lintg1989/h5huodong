/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemUserJwid implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String userId;
	private String jwid;
	private String name;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJwid() {
		return this.jwid;
	}

	public void setJwid(String jwid) {
		this.jwid = jwid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "JwSystemUserJwid [id=" + this.id + ", userId=" + this.userId + ", jwid=" + this.jwid + ", name="
				+ this.name + "]";
	}
}