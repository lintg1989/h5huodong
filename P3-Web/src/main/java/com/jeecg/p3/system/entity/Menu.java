/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String authId;
	private String authName;
	private String authContr;
	private String parentAuthId;
	private String authType;
	private List<Menu> childMenu;
	private boolean selected;
	private String authDesc;
	private String roleId;
	private String roleName;

	public String getAuthDesc() {
		return this.authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getAuthType() {
		return this.authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public List<Menu> getChildMenu() {
		return this.childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String toString() {
		return "Menu [userId=" + this.userId + ", authId=" + this.authId + ", authName=" + this.authName
				+ ", authContr=" + this.authContr + ", parentAuthId=" + this.parentAuthId + ", authType="
				+ this.authType + ", childMenu=" + this.childMenu + ", selected=" + this.selected + ", authDesc="
				+ this.authDesc + ", roleId=" + this.roleId + ", roleName=" + this.roleName + "]";
	}
}