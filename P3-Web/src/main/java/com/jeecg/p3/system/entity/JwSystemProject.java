/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemProject implements Entity<String> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String name;
	private String img;
	private String discribe;
	private String hdurl;
	private String applicationType;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDiscribe() {
		return this.discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getHdurl() {
		return this.hdurl;
	}

	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}

	public String getApplicationType() {
		return this.applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
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
}