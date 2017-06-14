/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemProjectDao;
import com.jeecg.p3.system.entity.JwSystemProject;
import com.jeecg.p3.system.service.JwSystemProjectService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;

@Service("jwSystemProjectService")
public class JwSystemProjectServiceImpl implements JwSystemProjectService {
	@Resource
	private JwSystemProjectDao jwSystemProjectDao;

	public void doAdd(JwSystemProject jwSystemProject) {
		this.jwSystemProjectDao.add(jwSystemProject);
	}

	public void doEdit(JwSystemProject jwSystemProject) {
		this.jwSystemProjectDao.update(jwSystemProject);
	}

	public void doDelete(String id) {
		this.jwSystemProjectDao.delete(id);
	}

	public JwSystemProject queryById(String id) {
		JwSystemProject jwSystemProject = (JwSystemProject) this.jwSystemProjectDao.get(id);
		return jwSystemProject;
	}

	public PageList<JwSystemProject> queryPageList(PageQuery<JwSystemProject> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemProjectDao.count(pageQuery);
		List list = this.jwSystemProjectDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public Boolean validReat(String code, String id) {
		return this.jwSystemProjectDao.validReat(code, id);
	}
}