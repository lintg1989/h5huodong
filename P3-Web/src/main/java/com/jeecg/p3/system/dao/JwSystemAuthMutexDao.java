/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemAuthMutexDao extends GenericDao<JwSystemAuthMutex> {
	Integer count(PageQuery<JwSystemAuthMutex> arg0);

	List<JwSystemAuthMutex> queryPageList(PageQuery<JwSystemAuthMutex> arg0, Integer arg1);

	List<JwSystemAuthMutex> queryAllAuthMutex();
}