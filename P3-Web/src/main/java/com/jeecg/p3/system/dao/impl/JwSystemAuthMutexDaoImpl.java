/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwSystemAuthMutexDao;
import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemAuthMutexDao")
public class JwSystemAuthMutexDaoImpl extends GenericDaoDefault<JwSystemAuthMutex> implements JwSystemAuthMutexDao {
	public Integer count(PageQuery<JwSystemAuthMutex> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemAuthMutex> queryPageList(PageQuery<JwSystemAuthMutex> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public List<JwSystemAuthMutex> queryAllAuthMutex() {
		return super.query("queryAllAuthMutex", new Object[0]);
	}
}