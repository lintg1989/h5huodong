/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwWebJwid implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String jwid;
	private String name;
	private String applicationType;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getApplicationType() {
		return this.applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String toString() {
		return "JwWebJwid [id=" + this.id + ", jwid=" + this.jwid + ", name=" + this.name + "]";
	}
}