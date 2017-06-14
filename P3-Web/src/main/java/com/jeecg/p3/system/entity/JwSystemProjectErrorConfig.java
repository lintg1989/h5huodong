/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemProjectErrorConfig implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String projectUrl;
	private String name;
	private String redirectUrl;
	private String creatName;
	private Date creatTime;
	private String updateName;
	private Date updateTime;
	private String jwid;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectUrl() {
		return this.projectUrl;
	}

	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRedirectUrl() {
		return this.redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getCreatName() {
		return this.creatName;
	}

	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getJwid() {
		return this.jwid;
	}

	public void setJwid(String jwid) {
		this.jwid = jwid;
	}
}