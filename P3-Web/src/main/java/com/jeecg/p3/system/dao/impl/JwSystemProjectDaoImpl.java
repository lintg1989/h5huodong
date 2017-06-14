/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Maps;
import com.jeecg.p3.system.dao.JwSystemProjectDao;
import com.jeecg.p3.system.entity.JwSystemProject;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemProjectDao")
public class JwSystemProjectDaoImpl extends GenericDaoDefault<JwSystemProject> implements JwSystemProjectDao {
	public Integer count(PageQuery<JwSystemProject> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemProject> queryPageList(PageQuery<JwSystemProject> pageQuery, Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}

	public Boolean validReat(String code, String id) {
		ConcurrentMap param = Maps.newConcurrentMap();
		param.put("code", code);
		if (!StringUtils.isEmpty(id)) {
			param.put("id", id);
		}

		JwSystemProject project = (JwSystemProject) super.queryOne("validReat", new Object[]{param});
		return project == null ? Boolean.valueOf(false) : Boolean.valueOf(true);
	}
}