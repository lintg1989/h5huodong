/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwWebJwid;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwWebJwidDao extends GenericDao<JwWebJwid> {
	Integer count(PageQuery<JwWebJwid> arg0);

	List<JwWebJwid> queryPageList(PageQuery<JwWebJwid> arg0, Integer arg1);

	List<JwWebJwid> queryJwids();

	JwWebJwid queryJwidNameByJwid(String arg0);

	JwWebJwid queryJwidByJwidAndUserId(String arg0, String arg1);

	List<JwWebJwid> queryJwWebJwidByUserId(String arg0);

	void deleteUserJwidByUserid(String arg0);

	List<JwWebJwid> queryJwidsNotInUser(String arg0);

	void insertUserJwidRels(String arg0, String arg1);
}