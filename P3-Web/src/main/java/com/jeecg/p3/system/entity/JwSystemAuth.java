/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemAuth implements Entity<Long> {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String authId;
	private String authName;
	private String isLogs;
	private String authType;
	private String authDesc;
	private String authContr;
	private String parentAuthId;
	private Integer sortNo;
	private String bizLevel;
	private String leafInd;
	private String delStat;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getIsLogs() {
		return this.isLogs;
	}

	public void setIsLogs(String isLogs) {
		this.isLogs = isLogs;
	}

	public String getAuthType() {
		return this.authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthDesc() {
		return this.authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public String getAuthContr() {
		return this.authContr;
	}

	public void setAuthContr(String authContr) {
		this.authContr = authContr;
	}

	public String getParentAuthId() {
		return this.parentAuthId;
	}

	public void setParentAuthId(String parentAuthId) {
		this.parentAuthId = parentAuthId;
	}

	public Integer getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getBizLevel() {
		return this.bizLevel;
	}

	public void setBizLevel(String bizLevel) {
		this.bizLevel = bizLevel;
	}

	public String getLeafInd() {
		return this.leafInd;
	}

	public void setLeafInd(String leafInd) {
		this.leafInd = leafInd;
	}

	public String getDelStat() {
		return this.delStat;
	}

	public void setDelStat(String delStat) {
		this.delStat = delStat;
	}

	public String toString() {
		return "JwSystemAuth [id=" + this.id + ", authId=" + this.authId + ", authName=" + this.authName + ", isLogs="
				+ this.isLogs + ", authType=" + this.authType + ", authDesc=" + this.authDesc + ", authContr="
				+ this.authContr + ", parentAuthId=" + this.parentAuthId + ", sortNo=" + this.sortNo + ", bizLevel="
				+ this.bizLevel + ", leafInd=" + this.leafInd + ", delStat=" + this.delStat + "]";
	}
}