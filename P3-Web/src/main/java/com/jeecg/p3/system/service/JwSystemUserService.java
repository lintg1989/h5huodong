/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemUserService {
	void doAdd(JwSystemUser arg0, List<String> arg1);

	void doEdit(JwSystemUser arg0, List<String> arg1);

	void doDelete(Long arg0);

	JwSystemUser queryById(Long arg0);

	PageList<JwSystemUser> queryPageList(PageQuery<JwSystemUser> arg0);

	List<String> queryUserRoles(String arg0);

	List<Menu> queryUserMenuAuth(List<String> arg0);

	LoginUser queryUserByUserId(String arg0);
}