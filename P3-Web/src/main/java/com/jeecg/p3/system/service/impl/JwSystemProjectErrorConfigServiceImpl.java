/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemProjectErrorConfigDao;
import com.jeecg.p3.system.entity.JwSystemProjectErrorConfig;
import com.jeecg.p3.system.service.JwSystemProjectErrorConfigService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service("jwSystemProjectErrorConfigService")
public class JwSystemProjectErrorConfigServiceImpl implements JwSystemProjectErrorConfigService {
	@Resource
	private JwSystemProjectErrorConfigDao jwSystemProjectErrorConfigDao;

	@CacheEvict(value = {"system_error_config"}, allEntries = true)
	public void doAdd(JwSystemProjectErrorConfig jwSystemProjectErrorConfig) {
		this.jwSystemProjectErrorConfigDao.add(jwSystemProjectErrorConfig);
	}

	@CacheEvict(value = {"system_error_config"}, allEntries = true)
	public void doEdit(JwSystemProjectErrorConfig jwSystemProjectErrorConfig) {
		this.jwSystemProjectErrorConfigDao.update(jwSystemProjectErrorConfig);
	}

	@CacheEvict(value = {"system_error_config"}, allEntries = true)
	public void doDelete(String id) {
		this.jwSystemProjectErrorConfigDao.delete(id);
	}

	public JwSystemProjectErrorConfig queryById(String id) {
		JwSystemProjectErrorConfig jwSystemProjectErrorConfig = (JwSystemProjectErrorConfig) this.jwSystemProjectErrorConfigDao
				.get(id);
		return jwSystemProjectErrorConfig;
	}

	public PageList<JwSystemProjectErrorConfig> queryPageList(PageQuery<JwSystemProjectErrorConfig> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemProjectErrorConfigDao.count(pageQuery);
		List list = this.jwSystemProjectErrorConfigDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}
}