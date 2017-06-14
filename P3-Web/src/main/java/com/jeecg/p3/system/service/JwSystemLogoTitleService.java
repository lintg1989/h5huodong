/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemLogoTitle;
import java.util.List;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemLogoTitleService {
	void doAdd(JwSystemLogoTitle arg0);

	void doEdit(JwSystemLogoTitle arg0);

	void doDelete(String arg0);

	JwSystemLogoTitle queryById(String arg0);

	PageList<JwSystemLogoTitle> queryPageList(PageQuery<JwSystemLogoTitle> arg0);

	List<JwSystemLogoTitle> queryLogoTitle();
}