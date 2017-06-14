/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemUserDao;
import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.service.JwSystemUserService;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jwSystemUserService")
public class JwSystemUserServiceImpl implements JwSystemUserService {
	@Resource
	private JwSystemUserDao jwSystemUserDao;

	@Transactional(rollbackFor = {Exception.class})
	public void doAdd(JwSystemUser jwSystemUser, List<String> roleIds) {
		this.jwSystemUserDao.add(jwSystemUser);
		if (roleIds != null && roleIds.size() > 0) {
			Iterator i$ = roleIds.iterator();

			while (i$.hasNext()) {
				String roleId = (String) i$.next();
				this.jwSystemUserDao.insertUserRoleRel(jwSystemUser.getUserId(), roleId);
			}
		}

	}

	@Transactional(rollbackFor = {Exception.class})
	public void doEdit(JwSystemUser jwSystemUser, List<String> roleIds) {
		this.jwSystemUserDao.update(jwSystemUser);
		this.jwSystemUserDao.deleteRolesByUserId(jwSystemUser.getUserId());
		if (roleIds != null && roleIds.size() > 0) {
			Iterator i$ = roleIds.iterator();

			while (i$.hasNext()) {
				String roleId = (String) i$.next();
				this.jwSystemUserDao.insertUserRoleRel(jwSystemUser.getUserId(), roleId);
			}
		}

	}

	@Transactional(rollbackFor = {Exception.class})
	public void doDelete(Long id) {
		JwSystemUser jwSystemUser = (JwSystemUser) this.jwSystemUserDao.get(id);
		if ("admin".equals(jwSystemUser.getUserId())) {
			throw new RuntimeException("admin用户不能删除");
		} else {
			this.jwSystemUserDao.deleteRolesByUserId(jwSystemUser.getUserId());
			this.jwSystemUserDao.delete(id);
		}
	}

	public JwSystemUser queryById(Long id) {
		JwSystemUser jwSystemUser = (JwSystemUser) this.jwSystemUserDao.get(id);
		return jwSystemUser;
	}

	public PageList<JwSystemUser> queryPageList(PageQuery<JwSystemUser> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemUserDao.count(pageQuery);
		List list = this.jwSystemUserDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<String> queryUserRoles(String userId) {
		return this.jwSystemUserDao.queryUserRoles(userId);
	}

	public List<Menu> queryUserMenuAuth(List<String> roleIds) {
		return this.jwSystemUserDao.queryUserMenuAuth(roleIds);
	}

	public LoginUser queryUserByUserId(String userId) {
		return this.jwSystemUserDao.queryUserByUserId(userId);
	}
}