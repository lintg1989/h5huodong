/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwWebJwidDao;
import com.jeecg.p3.system.entity.JwWebJwid;
import java.util.HashMap;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwWebJwidDao")
public class JwWebJwidDaoImpl extends GenericDaoDefault<JwWebJwid> implements JwWebJwidDao {
	public Integer count(PageQuery<JwWebJwid> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwWebJwid> queryPageList(PageQuery<JwWebJwid> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public List<JwWebJwid> queryJwids() {
		return super.query("queryJwids", new Object[0]);
	}

	public JwWebJwid queryJwidNameByJwid(String jwid) {
		return (JwWebJwid) super.queryOne("queryJwidNameByJwid", new Object[]{jwid});
	}

	public List<JwWebJwid> queryJwWebJwidByUserId(String userId) {
		return super.query("queryJwWebJwidByUserId", new Object[]{userId});
	}

	public void deleteUserJwidByUserid(String userId) {
		this.delete("deleteUserJwidByUserid", new Object[]{userId});
	}

	public JwWebJwid queryJwidByJwidAndUserId(String jwid, String userId) {
		HashMap paramMap = new HashMap();
		paramMap.put("jwid", jwid);
		paramMap.put("userId", userId);
		return (JwWebJwid) super.queryOne("queryJwidByJwidAndUserId", new Object[]{paramMap});
	}

	public List<JwWebJwid> queryJwidsNotInUser(String userId) {
		return super.query("queryJwidsNotInUser", new Object[]{userId});
	}

	public void insertUserJwidRels(String userId, String jwid) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("jwid", jwid);
		super.getSqlSession().insert(this.getStatementId("insertUserJwidRels"), map);
	}
}