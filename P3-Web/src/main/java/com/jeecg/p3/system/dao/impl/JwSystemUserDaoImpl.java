/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwSystemUserDao;
import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.HashMap;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemUserDao")
public class JwSystemUserDaoImpl extends GenericDaoDefault<JwSystemUser> implements JwSystemUserDao {
	public Integer count(PageQuery<JwSystemUser> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemUser> queryPageList(PageQuery<JwSystemUser> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public List<String> queryUserRoles(String userId) {
		return super.query("queryUserRoles", new Object[]{userId});
	}

	public List<Menu> queryUserMenuAuth(List<String> roleIds) {
		return super.query("queryUserMenuAuth", new Object[]{roleIds});
	}

	public void insertUserRoleRel(String userId, String roleId) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("roleId", roleId);
		super.getSqlSession().insert(this.getStatementId("insertUserRoleRel"), map);
	}

	public void deleteRolesByUserId(String userId) {
		this.delete("deleteRolesByUserId", new Object[]{userId});
	}

	public LoginUser queryUserByUserId(String userId) {
		return (LoginUser) super.queryOne("queryUserByUserId", new Object[]{userId});
	}
}