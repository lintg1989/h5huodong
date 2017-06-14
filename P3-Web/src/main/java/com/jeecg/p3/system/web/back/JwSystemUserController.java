/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import com.jeecg.p3.system.entity.JwSystemRole;
import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuMutex;
import com.jeecg.p3.system.service.JwSystemAuthMutexService;
import com.jeecg.p3.system.service.JwSystemRoleService;
import com.jeecg.p3.system.service.JwSystemUserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.util.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/system/back/jwSystemUser"})
public class JwSystemUserController extends BaseController {
	@Autowired
	private JwSystemUserService jwSystemUserService;
	@Autowired
	private JwSystemRoleService jwSystemRoleService;
	@Autowired
	private JwSystemAuthMutexService jwSystemAuthMutexService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemUser query, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemUser", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemUserService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemUser-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemUserDetail(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemUser-detail.vm";
		JwSystemUser jwSystemUser = this.jwSystemUserService.queryById(id);
		velocityContext.put("jwSystemUser", jwSystemUser);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemUser-add.vm";
		List roleList = this.jwSystemRoleService.queryAllRoleList();
		velocityContext.put("roleList", roleList);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemUser jwSystemUser,
			@RequestParam(required = false, value = "roleIds") List<String> roleIds) {
		AjaxJson j = new AjaxJson();

		try {
			MenuMutex e = this.checkAuthMutex(roleIds);
			if (e != null) {
				j.setSuccess(false);
				j.setMsg("用户赋角色失败：角色【" + e.getMenu().getRoleName() + "】:【" + e.getMenu().getAuthName() + "】\n 与 角色【"
						+ e.getMutexMenu().getRoleName() + "】:【" + e.getMutexMenu().getAuthName() + "】权限冲突！");
				j.setObj(e);
				return j;
			}

			Date date = new Date();
			jwSystemUser.setCreateDt(date);
			this.jwSystemUserService.doAdd(jwSystemUser, roleIds);
			j.setMsg("保存成功");
		} catch (Exception arg5) {
			log.info(arg5.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemUser jwSystemUser = this.jwSystemUserService.queryById(id);
		List roleIds = this.jwSystemUserService.queryUserRoles(jwSystemUser.getUserId());
		List allRolelist = this.jwSystemRoleService.queryAllRoleList();
		ArrayList checkedRoleList = new ArrayList();
		JwSystemRole role;
		if (allRolelist != null && allRolelist.size() > 0) {
			for (Iterator viewName = allRolelist.iterator(); viewName.hasNext(); checkedRoleList.add(role)) {
				role = (JwSystemRole) viewName.next();
				if (roleIds.contains(role.getRoleId())) {
					role.setIsChecked(Boolean.valueOf(true));
				}
			}
		}

		velocityContext.put("roleList", checkedRoleList);
		velocityContext.put("jwSystemUser", jwSystemUser);
		String viewName1 = "system/back/jwSystemUser-edit.vm";
		ViewVelocity.view(request, response, viewName1, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemUser jwSystemUser,
			@RequestParam(required = false, value = "roleIds") List<String> roleIds) {
		AjaxJson j = new AjaxJson();

		try {
			MenuMutex e = this.checkAuthMutex(roleIds);
			if (e != null) {
				j.setSuccess(false);
				j.setMsg("用户赋角色失败：角色【" + e.getMenu().getRoleName() + "】:【" + e.getMenu().getAuthName() + "】\n 与 角色【"
						+ e.getMutexMenu().getRoleName() + "】:【" + e.getMutexMenu().getAuthName() + "】权限冲突！");
				j.setObj(e);
				return j;
			}

			this.jwSystemUserService.doEdit(jwSystemUser, roleIds);
			j.setMsg("编辑成功");
		} catch (Exception arg4) {
			log.info(arg4.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}

		return j;
	}

	@RequestMapping(value = {"doDelete"}, method = {RequestMethod.GET})
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id") Long id) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemUserService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败:" + arg3.getMessage());
		}

		return j;
	}

	private MenuMutex checkAuthMutex(List<String> roleIds) {
		if (roleIds != null && roleIds.size() > 0) {
			List authMutexList = this.jwSystemAuthMutexService.queryAllAuthMutex();
			List menuList = this.jwSystemUserService.queryUserMenuAuth(roleIds);
			HashMap map = new HashMap();
			MenuMutex result = new MenuMutex();
			if (menuList != null && menuList.size() > 0) {
				Iterator i$ = menuList.iterator();

				while (i$.hasNext()) {
					Menu authMutex = (Menu) i$.next();
					map.put(authMutex.getAuthId(), authMutex);
				}

				i$ = authMutexList.iterator();

				while (i$.hasNext()) {
					JwSystemAuthMutex authMutex1 = (JwSystemAuthMutex) i$.next();
					if (map.containsKey(authMutex1.getAuthId()) && map.containsKey(authMutex1.getMutexAuthId())) {
						Menu menu = (Menu) map.get(authMutex1.getAuthId());
						Menu menuMutex = (Menu) map.get(authMutex1.getMutexAuthId());
						result.setMenu(menu);
						result.setMutexMenu(menuMutex);
						return result;
					}
				}
			}

			return null;
		} else {
			return null;
		}
	}

	@RequestMapping(value = {"toJwidTree"}, method = {RequestMethod.GET})
	public void toPrivilegeTree(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemUser jwSystemuser = this.jwSystemUserService.queryById(id);
		velocityContext.put("jwSystemuser", jwSystemuser);
		String viewName = "system/back/jwSystemUser-jwidtree.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}
}