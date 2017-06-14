/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemAuthDao;
import com.jeecg.p3.system.entity.Auth;
import com.jeecg.p3.system.entity.JwSystemAuth;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuFunction;
import com.jeecg.p3.system.service.JwSystemAuthService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jwSystemAuthService")
public class JwSystemAuthServiceImpl implements JwSystemAuthService {
	@Resource
	private JwSystemAuthDao jwSystemAuthDao;

	public void doAdd(JwSystemAuth jwSystemAuth) {
		jwSystemAuth.setDelStat("0");
		this.jwSystemAuthDao.add(jwSystemAuth);
	}

	public void doEdit(JwSystemAuth jwSystemAuth) {
		this.jwSystemAuthDao.update(jwSystemAuth);
	}

	public void doDelete(Long id) {
		this.jwSystemAuthDao.delete(id);
	}

	public JwSystemAuth queryById(Long id) {
		JwSystemAuth jwSystemAuth = (JwSystemAuth) this.jwSystemAuthDao.get(id);
		return jwSystemAuth;
	}

	public PageList<JwSystemAuth> queryPageList(PageQuery<JwSystemAuth> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwSystemAuthDao.count(pageQuery);
		List list = this.jwSystemAuthDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<MenuFunction> queryMenuAndFuncAuth() {
		return this.jwSystemAuthDao.queryMenuAndFuncAuth();
	}

	public List<MenuFunction> queryMenuAndFuncAuthByRoleId(String roleId) {
		return this.jwSystemAuthDao.queryMenuAndFuncAuthByRoleId(roleId);
	}

	public Menu queryMenuByAuthId(String authId) {
		return this.jwSystemAuthDao.queryMenuByAuthId(authId);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void modifyOperateRoleAuthRel(String roleId, List<String> authIds) {
		this.jwSystemAuthDao.deleteRoleAuthRels(roleId);
		if (authIds != null && authIds.size() > 0) {
			Iterator i$ = authIds.iterator();

			while (i$.hasNext()) {
				String authId = (String) i$.next();
				this.jwSystemAuthDao.insertRoleAuthRels(roleId, authId);
			}
		}

	}

	public LinkedHashMap<Menu, ArrayList<Menu>> getSubMenuTree(String userId, String parentAuthId) {
		List allSubMenuList = this.getAllSubMenuList(userId, parentAuthId, new ArrayList());
		LinkedHashMap result = new LinkedHashMap();
		Iterator i$ = allSubMenuList.iterator();

		while (i$.hasNext()) {
			Menu menu = (Menu) i$.next();
			if (this.isParentMenu(menu, allSubMenuList).booleanValue()) {
				ArrayList subMenuList = this.getSubMenuList(allSubMenuList, menu.getAuthId());
				result.put(menu, subMenuList);
			} else if (!this.isSonMenu(menu, allSubMenuList).booleanValue()) {
				result.put(menu, (Object) null);
			}
		}

		return result;
	}

	private List<Menu> getAllSubMenuList(String userId, String parentAuthId, List<Menu> allSubMenu) {
		List curSubMenu = this.jwSystemAuthDao.queryMenuByUserIdAndParentAuthId(userId, parentAuthId);
		if (curSubMenu.size() == 0) {
			return allSubMenu;
		} else {
			Iterator i$ = curSubMenu.iterator();

			while (i$.hasNext()) {
				Menu menu = (Menu) i$.next();
				allSubMenu.add(menu);
				int allNum = allSubMenu.size();
				allSubMenu = this.getAllSubMenuList(userId, menu.getAuthId(), allSubMenu);
				int tmpNum = allSubMenu.size();
				if (allNum == tmpNum) {
					;
				}
			}

			return allSubMenu;
		}
	}

	private Boolean isParentMenu(Menu curMenu, List<Menu> subMenuList) {
		Iterator i$ = subMenuList.iterator();

		Menu menu;
		do {
			if (!i$.hasNext()) {
				return Boolean.valueOf(false);
			}

			menu = (Menu) i$.next();
		} while (!curMenu.getAuthId().equals(menu.getParentAuthId()));

		return Boolean.valueOf(true);
	}

	private Boolean isSonMenu(Menu curMenu, List<Menu> subMenuList) {
		Iterator i$ = subMenuList.iterator();

		Menu menu;
		do {
			if (!i$.hasNext()) {
				return Boolean.valueOf(false);
			}

			menu = (Menu) i$.next();
		} while (!menu.getAuthId().equals(curMenu.getParentAuthId()));

		return Boolean.valueOf(true);
	}

	private ArrayList<Menu> getSubMenuList(List<Menu> subMenuList, String parentId) {
		ArrayList result = new ArrayList();
		Iterator i$ = subMenuList.iterator();

		while (i$.hasNext()) {
			Menu menu = (Menu) i$.next();
			if (parentId.equals(menu.getParentAuthId())) {
				result.add(menu);
			}
		}

		return result;
	}

	public List<Auth> queryAuthByUserId(String userId) {
		return this.jwSystemAuthDao.queryAuthByUserId(userId);
	}

	public List<Auth> queryAuthByAuthContr(String authContr) {
		return this.jwSystemAuthDao.queryAuthByAuthContr(authContr);
	}

	public List<Auth> queryAuthByUserIdAndAuthContr(String userId, String authContr) {
		return this.jwSystemAuthDao.queryAuthByUserIdAndAuthContr(userId, authContr);
	}
}