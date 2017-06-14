/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwSystemAuthDao;
import com.jeecg.p3.system.entity.Auth;
import com.jeecg.p3.system.entity.JwSystemAuth;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuFunction;
import java.util.HashMap;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemAuthDao")
public class JwSystemAuthDaoImpl extends GenericDaoDefault<JwSystemAuth> implements JwSystemAuthDao {
	public Integer count(PageQuery<JwSystemAuth> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemAuth> queryPageList(PageQuery<JwSystemAuth> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public List<MenuFunction> queryMenuAndFuncAuth() {
		return super.query("queryMenuAndFuncAuth", new Object[0]);
	}

	public List<MenuFunction> queryMenuAndFuncAuthByRoleId(String roleId) {
		return super.query("queryMenuAndFuncAuthByRoleId", new Object[]{roleId});
	}

	public Menu queryMenuByAuthId(String authId) {
		return (Menu) super.queryOne("queryMenuByAuthId", new Object[]{authId});
	}

	public void deleteRoleAuthRels(String roleId) {
		super.delete("deleteRoleAuthRels", new Object[]{roleId});
	}

	public void insertRoleAuthRels(String roleId, String authId) {
		HashMap map = new HashMap();
		map.put("roleId", roleId);
		map.put("authId", authId);
		super.getSqlSession().insert(this.getStatementId("insertRoleAuthRels"), map);
	}

	public List<Menu> queryMenuByUserIdAndParentAuthId(String userId, String parentAuthId) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("parentAuthId", parentAuthId);
		return super.query("queryMenuByUserIdAndParentAuthId", new Object[]{map});
	}

	public List<Auth> queryAuthByUserId(String userId) {
		return super.query("queryAuthByUserId", new Object[]{userId});
	}

	public List<Auth> queryAuthByAuthContr(String authContr) {
		return super.query("queryAuthByAuthContr", new Object[]{authContr});
	}

	public List<Auth> queryAuthByUserIdAndAuthContr(String userId, String authContr) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("authContr", authContr);
		return super.query("queryAuthByUserIdAndAuthContr", new Object[]{map});
	}
}