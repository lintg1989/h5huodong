/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemActTxt implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String content;
	private String discribe;
	private String actCode;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getActCode() {
		return this.actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
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

	public String getDiscribe() {
		return this.discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String toString() {
		return "JwSystemActTxt [id=" + this.id + ", code=" + this.code + ", content=" + this.content + ", discribe="
				+ this.discribe + ", actCode=" + this.actCode + ", creatName=" + this.creatName + ", creatTime="
				+ this.creatTime + ", updateName=" + this.updateName + ", updateTime=" + this.updateTime + "]";
	}
}