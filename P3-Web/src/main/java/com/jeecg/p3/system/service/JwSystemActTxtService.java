/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service;

import com.jeecg.p3.system.entity.JwSystemActTxt;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;

public interface JwSystemActTxtService {
	void doAdd(JwSystemActTxt arg0);

	void doEdit(JwSystemActTxt arg0);

	void doDelete(String arg0);

	JwSystemActTxt queryById(String arg0);

	PageList<JwSystemActTxt> queryPageList(PageQuery<JwSystemActTxt> arg0);
}