/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.Auth;
import com.jeecg.p3.system.entity.JwSystemAuth;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuFunction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemAuthService {
	void doAdd(JwSystemAuth arg0);

	void doEdit(JwSystemAuth arg0);

	void doDelete(Long arg0);

	JwSystemAuth queryById(Long arg0);

	PageList<JwSystemAuth> queryPageList(PageQuery<JwSystemAuth> arg0);

	List<MenuFunction> queryMenuAndFuncAuth();

	List<MenuFunction> queryMenuAndFuncAuthByRoleId(String arg0);

	Menu queryMenuByAuthId(String arg0);

	void modifyOperateRoleAuthRel(String arg0, List<String> arg1);

	LinkedHashMap<Menu, ArrayList<Menu>> getSubMenuTree(String arg0, String arg1);

	List<Auth> queryAuthByUserId(String arg0);

	List<Auth> queryAuthByAuthContr(String arg0);

	List<Auth> queryAuthByUserIdAndAuthContr(String arg0, String arg1);
}