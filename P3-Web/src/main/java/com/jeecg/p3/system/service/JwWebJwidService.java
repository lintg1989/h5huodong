/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwWebJwid;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwWebJwidService {
	void doAdd(JwWebJwid arg0);

	void doEdit(JwWebJwid arg0);

	void doDelete(String arg0);

	JwWebJwid queryById(String arg0);

	PageList<JwWebJwid> queryPageList(PageQuery<JwWebJwid> arg0);

	List<JwWebJwid> queryJwids();

	JwWebJwid queryJwidNameByJwid(String arg0);

	JwWebJwid queryJwidByJwidAndUserId(String arg0, String arg1);

	List<JwWebJwid> queryJwWebJwidByUserId(String arg0);

	void syncJwid(String arg0, List<JwWebJwid> arg1);

	List<JwWebJwid> queryJwidsNotInUser(String arg0);

	void modifyOperateUserJwidRel(String arg0, List<String> arg1);
}