/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemLogoTitleDao;
import com.jeecg.p3.system.entity.JwSystemLogoTitle;
import com.jeecg.p3.system.service.JwSystemLogoTitleService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;

@Service("jwSystemLogoTitleService")
public class JwSystemLogoTitleServiceImpl implements JwSystemLogoTitleService {
	@Resource
	private JwSystemLogoTitleDao jwSystemLogoTitleDao;

	public void doAdd(JwSystemLogoTitle jwSystemLogoTitle) {
		this.jwSystemLogoTitleDao.add(jwSystemLogoTitle);
	}

	public void doEdit(JwSystemLogoTitle jwSystemLogoTitle) {
		this.jwSystemLogoTitleDao.update(jwSystemLogoTitle);
	}

	public void doDelete(String id) {
		this.jwSystemLogoTitleDao.delete(id);
	}

	public JwSystemLogoTitle queryById(String id) {
		JwSystemLogoTitle jwSystemLogoTitle = (JwSystemLogoTitle) this.jwSystemLogoTitleDao.get(id);
		return jwSystemLogoTitle;
	}

	public PageList<JwSystemLogoTitle> queryPageList(PageQuery<JwSystemLogoTitle> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemLogoTitleDao.count(pageQuery);
		List list = this.jwSystemLogoTitleDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<JwSystemLogoTitle> queryLogoTitle() {
		return this.jwSystemLogoTitleDao.getAll();
	}
}