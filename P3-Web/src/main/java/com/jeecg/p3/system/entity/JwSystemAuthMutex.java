/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.entity;

import org.jeecgframework.p3.core.utils.persistence.Entity;

public class JwSystemAuthMutex implements Entity<Long> {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String authId;
	private String mutexAuthId;

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

	public String getMutexAuthId() {
		return this.mutexAuthId;
	}

	public void setMutexAuthId(String mutexAuthId) {
		this.mutexAuthId = mutexAuthId;
	}

	public String toString() {
		return "JwSystemAuthMutex [id=" + this.id + ", authId=" + this.authId + ", mutexAuthId=" + this.mutexAuthId
				+ "]";
	}
}