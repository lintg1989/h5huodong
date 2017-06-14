/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemActDao;
import com.jeecg.p3.system.entity.JwSystemAct;
import com.jeecg.p3.system.service.JwSystemActService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;

@Service("jwSystemActService")
public class JwSystemActServiceImpl implements JwSystemActService {
	@Resource
	private JwSystemActDao jwSystemActDao;

	public void doAdd(JwSystemAct jwSystemAct) {
		this.jwSystemActDao.add(jwSystemAct);
	}

	public void doEdit(JwSystemAct jwSystemAct) {
		this.jwSystemActDao.update(jwSystemAct);
	}

	public void doDelete(String id) {
		this.jwSystemActDao.delete(id);
	}

	public JwSystemAct queryById(String id) {
		JwSystemAct jwSystemAct = (JwSystemAct) this.jwSystemActDao.get(id);
		return jwSystemAct;
	}

	public PageList<JwSystemAct> queryPageList(PageQuery<JwSystemAct> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemActDao.count(pageQuery);
		List list = this.jwSystemActDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
}