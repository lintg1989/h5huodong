/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemUserJwidDao;
import com.jeecg.p3.system.entity.JwSystemUserJwid;
import com.jeecg.p3.system.service.JwSystemUserJwidService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;

@Service("jwSystemUserJwidService")
public class JwSystemUserJwidServiceImpl implements JwSystemUserJwidService {
	@Resource
	private JwSystemUserJwidDao jwSystemUserJwidDao;

	public void doAdd(JwSystemUserJwid jwSystemUserJwid) {
		this.jwSystemUserJwidDao.add(jwSystemUserJwid);
	}

	public void doEdit(JwSystemUserJwid jwSystemUserJwid) {
		this.jwSystemUserJwidDao.update(jwSystemUserJwid);
	}

	public void doDelete(String id) {
		this.jwSystemUserJwidDao.delete(id);
	}

	public JwSystemUserJwid queryById(String id) {
		JwSystemUserJwid jwSystemUserJwid = (JwSystemUserJwid) this.jwSystemUserJwidDao.get(id);
		return jwSystemUserJwid;
	}

	public PageList<JwSystemUserJwid> queryPageList(PageQuery<JwSystemUserJwid> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemUserJwidDao.count(pageQuery);
		List list = this.jwSystemUserJwidDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
}