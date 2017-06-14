/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemActTxtDao;
import com.jeecg.p3.system.entity.JwSystemActTxt;
import com.jeecg.p3.system.service.JwSystemActTxtService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service("jwSystemActTxtService")
public class JwSystemActTxtServiceImpl implements JwSystemActTxtService {
	@Resource
	private JwSystemActTxtDao jwSystemActTxtDao;

	@CacheEvict(value = {"txtCache"}, allEntries = true)
	public void doAdd(JwSystemActTxt jwSystemActTxt) {
		this.jwSystemActTxtDao.add(jwSystemActTxt);
	}

	@CacheEvict(value = {"txtCache"}, allEntries = true)
	public void doEdit(JwSystemActTxt jwSystemActTxt) {
		this.jwSystemActTxtDao.update(jwSystemActTxt);
	}

	@CacheEvict(value = {"txtCache"}, allEntries = true)
	public void doDelete(String id) {
		this.jwSystemActTxtDao.delete(id);
	}

	public JwSystemActTxt queryById(String id) {
		JwSystemActTxt jwSystemActTxt = (JwSystemActTxt) this.jwSystemActTxtDao.get(id);
		return jwSystemActTxt;
	}

	public PageList<JwSystemActTxt> queryPageList(PageQuery<JwSystemActTxt> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemActTxtDao.count(pageQuery);
		List list = this.jwSystemActTxtDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
}