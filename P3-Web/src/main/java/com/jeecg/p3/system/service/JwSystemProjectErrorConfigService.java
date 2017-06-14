/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemProjectErrorConfig;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemProjectErrorConfigService {
	void doAdd(JwSystemProjectErrorConfig arg0);

	void doEdit(JwSystemProjectErrorConfig arg0);

	void doDelete(String arg0);

	JwSystemProjectErrorConfig queryById(String arg0);

	PageList<JwSystemProjectErrorConfig> queryPageList(PageQuery<JwSystemProjectErrorConfig> arg0);
}