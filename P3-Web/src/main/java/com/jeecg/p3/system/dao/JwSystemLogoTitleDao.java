/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.dao;

import com.jeecg.p3.system.entity.JwSystemLogoTitle;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.persistence.GenericDao;

public interface JwSystemLogoTitleDao extends GenericDao<JwSystemLogoTitle> {
	Integer count(PageQuery<JwSystemLogoTitle> arg0);

	List<JwSystemLogoTitle> queryPageList(PageQuery<JwSystemLogoTitle> arg0, Integer arg1);
}