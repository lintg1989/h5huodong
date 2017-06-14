/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemUserJwid;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemUserJwidDao extends GenericDao<JwSystemUserJwid> {
	Integer count(PageQuery<JwSystemUserJwid> arg0);

	List<JwSystemUserJwid> queryPageList(PageQuery<JwSystemUserJwid> arg0, Integer arg1);
}