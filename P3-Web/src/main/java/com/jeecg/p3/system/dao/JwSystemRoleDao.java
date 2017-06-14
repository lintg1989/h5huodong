/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemRole;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemRoleDao extends GenericDao<JwSystemRole> {
	Integer count(PageQuery<JwSystemRole> arg0);

	List<JwSystemRole> queryPageList(PageQuery<JwSystemRole> arg0, Integer arg1);

	List<JwSystemRole> queryAllRoleList();
}