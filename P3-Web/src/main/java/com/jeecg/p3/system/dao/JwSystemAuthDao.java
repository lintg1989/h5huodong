/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.Auth;
import com.jeecg.p3.system.entity.JwSystemAuth;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuFunction;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemAuthDao extends GenericDao<JwSystemAuth> {
	Integer count(PageQuery<JwSystemAuth> arg0);

	List<JwSystemAuth> queryPageList(PageQuery<JwSystemAuth> arg0, Integer arg1);

	List<MenuFunction> queryMenuAndFuncAuth();

	List<MenuFunction> queryMenuAndFuncAuthByRoleId(String arg0);

	Menu queryMenuByAuthId(String arg0);

	void deleteRoleAuthRels(String arg0);

	void insertRoleAuthRels(String arg0, String arg1);

	List<Menu> queryMenuByUserIdAndParentAuthId(String arg0, String arg1);

	List<Auth> queryAuthByUserId(String arg0);

	List<Auth> queryAuthByAuthContr(String arg0);

	List<Auth> queryAuthByUserIdAndAuthContr(String arg0, String arg1);
}