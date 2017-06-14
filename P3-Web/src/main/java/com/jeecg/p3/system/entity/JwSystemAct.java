/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemAct implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String actCode;
	private String actName;
	private String actDiscribe;
	private String jwid;
	private String jwidName;
	private String type;
	private String creatName;
	private Date creatTime;
	private String updateName;
	private Date updateTime;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActCode() {
		return this.actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActDiscribe() {
		return this.actDiscribe;
	}

	public void setActDiscribe(String actDiscribe) {
		this.actDiscribe = actDiscribe;
	}

	public String getJwid() {
		return this.jwid;
	}

	public void setJwid(String jwid) {
		this.jwid = jwid;
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

	public String getJwidName() {
		return this.jwidName;
	}

	public void setJwidName(String jwidName) {
		this.jwidName = jwidName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "JwSystemAct [id=" + this.id + ", actCode=" + this.actCode + ", actName=" + this.actName
				+ ", actDiscribe=" + this.actDiscribe + ", jwid=" + this.jwid + ", jwidName=" + this.jwidName
				+ ", type=" + this.type + ", creatName=" + this.creatName + ", creatTime=" + this.creatTime
				+ ", updateName=" + this.updateName + ", updateTime=" + this.updateTime + "]";
	}
}