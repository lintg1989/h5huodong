/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemUserJwid;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemUserJwidService {
	void doAdd(JwSystemUserJwid arg0);

	void doEdit(JwSystemUserJwid arg0);

	void doDelete(String arg0);

	JwSystemUserJwid queryById(String arg0);

	PageList<JwSystemUserJwid> queryPageList(PageQuery<JwSystemUserJwid> arg0);
}