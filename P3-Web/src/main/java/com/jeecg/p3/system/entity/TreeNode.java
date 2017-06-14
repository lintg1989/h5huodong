/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

public class TreeNode {
	private String id;
	private String pId;
	private String name;
	private boolean open;
	private boolean checked;
	private boolean doCheck;
	private boolean halfCheck;
	private boolean isParent;
	private boolean chkDisabled;
	private boolean nocheck;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return this.pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return this.open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return this.checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isNocheck() {
		return this.nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public boolean isChkDisabled() {
		return this.chkDisabled;
	}

	public void setChkDisabled(boolean chkDisabled) {
		this.chkDisabled = chkDisabled;
	}

	public boolean isParent() {
		return this.isParent;
	}

	public void setParent(boolean parent) {
		this.isParent = parent;
	}

	public boolean isDoCheck() {
		return this.doCheck;
	}

	public void setDoCheck(boolean doCheck) {
		this.doCheck = doCheck;
	}

	public boolean isHalfCheck() {
		return this.halfCheck;
	}

	public void setHalfCheck(boolean halfCheck) {
		this.halfCheck = halfCheck;
	}

	public String toString() {
		return "TreeNode [id=" + this.id + ", pId=" + this.pId + ", name=" + this.name + ", open=" + this.open
				+ ", checked=" + this.checked + ", doCheck=" + this.doCheck + ", halfCheck=" + this.halfCheck
				+ ", isParent=" + this.isParent + ", chkDisabled=" + this.chkDisabled + ", nocheck=" + this.nocheck
				+ "]";
	}
}