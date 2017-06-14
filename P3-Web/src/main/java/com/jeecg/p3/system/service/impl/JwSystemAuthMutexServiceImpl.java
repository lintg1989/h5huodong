/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemAuthMutexDao;
import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import com.jeecg.p3.system.service.JwSystemAuthMutexService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;

@Service("jwSystemAuthMutexService")
public class JwSystemAuthMutexServiceImpl implements JwSystemAuthMutexService {
	@Resource
	private JwSystemAuthMutexDao jwSystemAuthMutexDao;

	public void doAdd(JwSystemAuthMutex jwSystemAuthMutex) {
		this.jwSystemAuthMutexDao.add(jwSystemAuthMutex);
	}

	public void doEdit(JwSystemAuthMutex jwSystemAuthMutex) {
		this.jwSystemAuthMutexDao.update(jwSystemAuthMutex);
	}

	public void doDelete(String id) {
		this.jwSystemAuthMutexDao.delete(id);
	}

	public JwSystemAuthMutex queryById(String id) {
		JwSystemAuthMutex jwSystemAuthMutex = (JwSystemAuthMutex) this.jwSystemAuthMutexDao.get(id);
		return jwSystemAuthMutex;
	}

	public PageList<JwSystemAuthMutex> queryPageList(PageQuery<JwSystemAuthMutex> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemAuthMutexDao.count(pageQuery);
		List list = this.jwSystemAuthMutexDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<JwSystemAuthMutex> queryAllAuthMutex() {
		return this.jwSystemAuthMutexDao.queryAllAuthMutex();
	}
}