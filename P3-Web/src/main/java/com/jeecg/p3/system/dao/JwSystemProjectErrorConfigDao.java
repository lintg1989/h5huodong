/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemProjectErrorConfig;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemProjectErrorConfigDao extends GenericDao<JwSystemProjectErrorConfig> {
	Integer count(PageQuery<JwSystemProjectErrorConfig> arg0);

	List<JwSystemProjectErrorConfig> queryPageList(PageQuery<JwSystemProjectErrorConfig> arg0, Integer arg1);
}