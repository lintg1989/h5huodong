/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwSystemRoleDao;
import com.jeecg.p3.system.entity.JwSystemRole;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemRoleDao")
public class JwSystemRoleDaoImpl extends GenericDaoDefault<JwSystemRole> implements JwSystemRoleDao {
	public Integer count(PageQuery<JwSystemRole> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemRole> queryPageList(PageQuery<JwSystemRole> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public List<JwSystemRole> queryAllRoleList() {
		return super.query("queryAllRoleList", new Object[0]);
	}
}