/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemRole;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemRoleService {
	void doAdd(JwSystemRole arg0);

	void doEdit(JwSystemRole arg0);

	void doDelete(Long arg0, String arg1);

	JwSystemRole queryById(Long arg0);

	PageList<JwSystemRole> queryPageList(PageQuery<JwSystemRole> arg0);

	List<JwSystemRole> queryAllRoleList();
}