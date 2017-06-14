/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemAct;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemActService {
	void doAdd(JwSystemAct arg0);

	void doEdit(JwSystemAct arg0);

	void doDelete(String arg0);

	JwSystemAct queryById(String arg0);

	PageList<JwSystemAct> queryPageList(PageQuery<JwSystemAct> arg0);
}