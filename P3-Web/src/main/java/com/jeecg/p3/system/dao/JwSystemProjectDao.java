/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemProject;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemProjectDao extends GenericDao<JwSystemProject> {
	Integer count(PageQuery<JwSystemProject> arg0);

	List<JwSystemProject> queryPageList(PageQuery<JwSystemProject> arg0, Integer arg1);

	Boolean validReat(String arg0, String arg1);
}