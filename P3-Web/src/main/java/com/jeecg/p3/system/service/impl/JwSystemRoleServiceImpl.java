/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemAuthDao;
import com.jeecg.p3.system.dao.JwSystemRoleDao;
import com.jeecg.p3.system.entity.JwSystemRole;
import com.jeecg.p3.system.service.JwSystemRoleService;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jwSystemRoleService")
public class JwSystemRoleServiceImpl implements JwSystemRoleService {
	@Resource
	private JwSystemRoleDao jwSystemRoleDao;
	@Resource
	private JwSystemAuthDao jwSystemAuthDao;

	public void doAdd(JwSystemRole jwSystemRole) {
		this.jwSystemRoleDao.add(jwSystemRole);
	}

	public void doEdit(JwSystemRole jwSystemRole) {
		this.jwSystemRoleDao.update(jwSystemRole);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void doDelete(Long id, String roleId) {
		this.jwSystemAuthDao.deleteRoleAuthRels(roleId);
		this.jwSystemRoleDao.delete(id);
	}

	public JwSystemRole queryById(Long id) {
		JwSystemRole jwSystemRole = (JwSystemRole) this.jwSystemRoleDao.get(id);
		return jwSystemRole;
	}

	public PageList<JwSystemRole> queryPageList(PageQuery<JwSystemRole> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemRoleDao.count(pageQuery);
		List list = this.jwSystemRoleDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<JwSystemRole> queryAllRoleList() {
		return this.jwSystemRoleDao.queryAllRoleList();
	}
}