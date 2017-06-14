/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import java.util.Date;
import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemUser implements Entity<Long> {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userId;
	private String userName;
	private String password;
	private String userErpNo;
	private String userTyp;
	private String opeDepId;
	private String opePhoneNum;
	private String email;
	private String opeEmailAuthinfo;
	private String userIcon;
	private String opeMobileAuthInd;
	private String opeEmailAuthInd;
	private String idNum;
	private String idTyp;
	private String state;
	private String userStat;
	private Date lastLognDttm;
	private String lastLognIp;
	private String opePasswdInd;
	private String delStat;
	private String creator;
	private String editor;
	private Date createDt;
	private Date editDt;
	private Date lastEditDt;
	private String recordVersion;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserErpNo() {
		return this.userErpNo;
	}

	public void setUserErpNo(String userErpNo) {
		this.userErpNo = userErpNo;
	}

	public String getUserTyp() {
		return this.userTyp;
	}

	public void setUserTyp(String userTyp) {
		this.userTyp = userTyp;
	}

	public String getOpeDepId() {
		return this.opeDepId;
	}

	public void setOpeDepId(String opeDepId) {
		this.opeDepId = opeDepId;
	}

	public String getOpePhoneNum() {
		return this.opePhoneNum;
	}

	public void setOpePhoneNum(String opePhoneNum) {
		this.opePhoneNum = opePhoneNum;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpeEmailAuthinfo() {
		return this.opeEmailAuthinfo;
	}

	public void setOpeEmailAuthinfo(String opeEmailAuthinfo) {
		this.opeEmailAuthinfo = opeEmailAuthinfo;
	}

	public String getUserIcon() {
		return this.userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getOpeMobileAuthInd() {
		return this.opeMobileAuthInd;
	}

	public void setOpeMobileAuthInd(String opeMobileAuthInd) {
		this.opeMobileAuthInd = opeMobileAuthInd;
	}

	public String getOpeEmailAuthInd() {
		return this.opeEmailAuthInd;
	}

	public void setOpeEmailAuthInd(String opeEmailAuthInd) {
		this.opeEmailAuthInd = opeEmailAuthInd;
	}

	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getIdTyp() {
		return this.idTyp;
	}

	public void setIdTyp(String idTyp) {
		this.idTyp = idTyp;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserStat() {
		return this.userStat;
	}

	public void setUserStat(String userStat) {
		this.userStat = userStat;
	}

	public Date getLastLognDttm() {
		return this.lastLognDttm;
	}

	public void setLastLognDttm(Date lastLognDttm) {
		this.lastLognDttm = lastLognDttm;
	}

	public String getLastLognIp() {
		return this.lastLognIp;
	}

	public void setLastLognIp(String lastLognIp) {
		this.lastLognIp = lastLognIp;
	}

	public String getOpePasswdInd() {
		return this.opePasswdInd;
	}

	public void setOpePasswdInd(String opePasswdInd) {
		this.opePasswdInd = opePasswdInd;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "JwSystemUser [id=" + this.id + ", userId=" + this.userId + ", userName=" + this.userName
				+ ", userErpNo=" + this.userErpNo + ", userTyp=" + this.userTyp + ", opeDepId=" + this.opeDepId
				+ ", opePhoneNum=" + this.opePhoneNum + ", email=" + this.email + ", opeEmailAuthinfo="
				+ this.opeEmailAuthinfo + ", userIcon=" + this.userIcon + ", opeMobileAuthInd=" + this.opeMobileAuthInd
				+ ", opeEmailAuthInd=" + this.opeEmailAuthInd + ", idNum=" + this.idNum + ", idTyp=" + this.idTyp
				+ ", state=" + this.state + ", userStat=" + this.userStat + ", lastLognDttm=" + this.lastLognDttm
				+ ", lastLognIp=" + this.lastLognIp + ", opePasswdInd=" + this.opePasswdInd + ", delStat="
				+ this.delStat + ", creator=" + this.creator + ", editor=" + this.editor + ", createDt=" + this.createDt
				+ ", editDt=" + this.editDt + ", lastEditDt=" + this.lastEditDt + ", recordVersion="
				+ this.recordVersion + "]";
	}
}