/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemProject;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemProjectService {
	void doAdd(JwSystemProject arg0);

	void doEdit(JwSystemProject arg0);

	void doDelete(String arg0);

	JwSystemProject queryById(String arg0);

	PageList<JwSystemProject> queryPageList(PageQuery<JwSystemProject> arg0);

	Boolean validReat(String arg0, String arg1);
}