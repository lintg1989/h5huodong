/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.io.Serializable;

public class MenuFunction implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String authName;
	private String authDesc;
	private String authContr;
	private String authId;
	private String authType;
	private String parentAuthId;
	private String leafInd;

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

	public String getAuthType() {
		return this.authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthDesc() {
		return this.authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public String getParentAuthId() {
		return this.parentAuthId;
	}

	public void setParentAuthId(String parentAuthId) {
		this.parentAuthId = parentAuthId;
	}

	public String getLeafInd() {
		return this.leafInd;
	}

	public void setLeafInd(String leafInd) {
		this.leafInd = leafInd;
	}

	public String toString() {
		return "MenuFunction [userId=" + this.userId + ", authName=" + this.authName + ", authDesc=" + this.authDesc
				+ ", authContr=" + this.authContr + ", authId=" + this.authId + ", authType=" + this.authType
				+ ", parentAuthId=" + this.parentAuthId + ", leafInd=" + this.leafInd + "]";
	}
}