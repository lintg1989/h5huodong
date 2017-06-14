/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemRole implements Entity<Long> {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String roleId;
	private String roleName;
	private String crtOperator;
	private Date crtDt;
	private String roleTyp;
	private String delStat;
	private String creator;
	private String editor;
	private Date createDt;
	private Date editDt;
	private Date lastEditDt;
	private String recordVersion;
	private Boolean isChecked;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCrtOperator() {
		return this.crtOperator;
	}

	public void setCrtOperator(String crtOperator) {
		this.crtOperator = crtOperator;
	}

	public Date getCrtDt() {
		return this.crtDt;
	}

	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}

	public String getRoleTyp() {
		return this.roleTyp;
	}

	public void setRoleTyp(String roleTyp) {
		this.roleTyp = roleTyp;
	}

	public String getDelStat() {
		return this.delStat;
	}

	public void setDelStat(String delStat) {
		this.delStat = delStat;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getEditDt() {
		return this.editDt;
	}

	public void setEditDt(Date editDt) {
		this.editDt = editDt;
	}

	public Date getLastEditDt() {
		return this.lastEditDt;
	}

	public void setLastEditDt(Date lastEditDt) {
		this.lastEditDt = lastEditDt;
	}

	public String getRecordVersion() {
		return this.recordVersion;
	}

	public void setRecordVersion(String recordVersion) {
		this.recordVersion = recordVersion;
	}

	public Boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public String toString() {
		return "JwSystemRole [id=" + this.id + ", roleId=" + this.roleId + ", roleName=" + this.roleName
				+ ", crtOperator=" + this.crtOperator + ", crtDt=" + this.crtDt + ", roleTyp=" + this.roleTyp
				+ ", delStat=" + this.delStat + ", creator=" + this.creator + ", editor=" + this.editor + ", createDt="
				+ this.createDt + ", editDt=" + this.editDt + ", lastEditDt=" + this.lastEditDt + ", recordVersion="
				+ this.recordVersion + "]";
	}
}