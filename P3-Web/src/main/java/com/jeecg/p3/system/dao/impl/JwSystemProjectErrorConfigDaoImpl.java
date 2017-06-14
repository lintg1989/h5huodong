/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao.impl;

import com.jeecg.p3.system.dao.JwSystemProjectErrorConfigDao;
import com.jeecg.p3.system.entity.JwSystemProjectErrorConfig;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.PageQueryWrapper;
import org.jeecgframework.p3.core.utils.persistence.mybatis.GenericDaoDefault;
import org.springframework.stereotype.Repository;

@Repository("jwSystemProjectErrorConfigDao")
public class JwSystemProjectErrorConfigDaoImpl extends GenericDaoDefault<JwSystemProjectErrorConfig>
		implements
			JwSystemProjectErrorConfigDao {
	public Integer count(PageQuery<JwSystemProjectErrorConfig> pageQuery) {
		return (Integer) super.queryOne("count", new Object[]{pageQuery});
	}

	public List<JwSystemProjectErrorConfig> queryPageList(PageQuery<JwSystemProjectErrorConfig> pageQuery,
			Integer itemCount) {
		PageQueryWrapper wrapper = new PageQueryWrapper(pageQuery.getPageNo(), pageQuery.getPageSize(),
				itemCount.intValue(), pageQuery.getQuery());
		return super.query("queryPageList", new Object[]{wrapper});
	}
}