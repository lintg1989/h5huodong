/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemAuthMutexService {
	void doAdd(JwSystemAuthMutex arg0);

	void doEdit(JwSystemAuthMutex arg0);

	void doDelete(String arg0);

	JwSystemAuthMutex queryById(String arg0);

	PageList<JwSystemAuthMutex> queryPageList(PageQuery<JwSystemAuthMutex> arg0);

	List<JwSystemAuthMutex> queryAllAuthMutex();
}