/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemUserDao extends GenericDao<JwSystemUser> {
	Integer count(PageQuery<JwSystemUser> arg0);

	List<JwSystemUser> queryPageList(PageQuery<JwSystemUser> arg0, Integer arg1);

	List<String> queryUserRoles(String arg0);

	List<Menu> queryUserMenuAuth(List<String> arg0);

	void insertUserRoleRel(String arg0, String arg1);

	void deleteRolesByUserId(String arg0);

	LoginUser queryUserByUserId(String arg0);
}