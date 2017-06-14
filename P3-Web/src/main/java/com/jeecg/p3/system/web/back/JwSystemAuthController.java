/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemAuth;
import com.jeecg.p3.system.entity.JwSystemAuthMutex;
import com.jeecg.p3.system.entity.Menu;
import com.jeecg.p3.system.entity.MenuMutex;
import com.jeecg.p3.system.service.JwSystemAuthMutexService;
import com.jeecg.p3.system.service.JwSystemAuthService;
import com.jeecg.p3.system.util.SystemUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.util.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.StringUtils;
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
@RequestMapping({"/system/back/jwSystemAuth"})
public class JwSystemAuthController extends BaseController {
	@Autowired
	private JwSystemAuthService jwSystemAuthService;
	@Autowired
	private JwSystemAuthMutexService jwSystemAuthMutexService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemAuth query, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "100") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemAuth", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemAuthService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemAuth-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemAuthDetail(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemAuth-detail.vm";
		JwSystemAuth jwSystemAuth = this.jwSystemAuthService.queryById(id);
		velocityContext.put("jwSystemAuth", jwSystemAuth);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemAuth-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemAuth jwSystemAuth) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemAuthService.doAdd(jwSystemAuth);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemAuth jwSystemAuth = this.jwSystemAuthService.queryById(id);
		velocityContext.put("jwSystemAuth", jwSystemAuth);
		String viewName = "system/back/jwSystemAuth-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemAuth jwSystemAuth) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemAuthService.doEdit(jwSystemAuth);
			j.setMsg("编辑成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
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
			this.jwSystemAuthService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}

	@RequestMapping(value = {"/initAuth"}, produces = {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String initAuth(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "roleId", required = true) String roleId) {
		log.info("初始化权限");
		String tree = "";

		try {
			List e = this.jwSystemAuthService.queryMenuAndFuncAuth();
			List roleAuthList = this.jwSystemAuthService.queryMenuAndFuncAuthByRoleId(roleId);
			tree = SystemUtil.list2TreeWithCheck(e, roleAuthList);
			log.info("初始化权限: " + tree);
		} catch (Exception arg6) {
			log.info(arg6.getMessage());
		}

		return tree;
	}

	@RequestMapping(value = {"/editRoleAuth"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson editRoleAuth(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "checkedNodes", required = true) String checkedNodes,
			@RequestParam(value = "roleId", required = true) String roleId) {
		AjaxJson j = new AjaxJson();
		log.info("编辑角色权限");

		try {
			ArrayList e = new ArrayList();
			if (StringUtils.isNotEmpty(checkedNodes)) {
				String[] menuMutex = checkedNodes.split(",");
				int len$ = menuMutex.length;

				for (int i$ = 0; i$ < len$; ++i$) {
					String auth = menuMutex[i$];
					e.add(auth);
				}
			}

			MenuMutex arg11 = this.checkAuthMutex(e);
			if (arg11 != null) {
				j.setSuccess(false);
				j.setMsg("角色授权失败：【" + arg11.getMenu().getAuthName() + "】与【" + arg11.getMutexMenu().getAuthName()
						+ "】权限冲突！");
				j.setObj(arg11);
				return j;
			}

			this.jwSystemAuthService.modifyOperateRoleAuthRel(roleId, e);
			j.setSuccess(true);
			j.setMsg("角色授权成功");
			log.info("编辑角色权限完成 ");
		} catch (Exception arg10) {
			log.info(arg10.getMessage());
			j.setSuccess(false);
			j.setMsg("角色授权失败");
		}

		return j;
	}

	private MenuMutex checkAuthMutex(List<String> authIds) {
		if (authIds != null && authIds.size() > 0) {
			List authMutexList = this.jwSystemAuthMutexService.queryAllAuthMutex();
			MenuMutex result = new MenuMutex();
			Iterator i$ = authMutexList.iterator();

			JwSystemAuthMutex authMutex;
			do {
				if (!i$.hasNext()) {
					return null;
				}

				authMutex = (JwSystemAuthMutex) i$.next();
			} while (!authIds.contains(authMutex.getAuthId()) || !authIds.contains(authMutex.getMutexAuthId()));

			Menu menu = this.jwSystemAuthService.queryMenuByAuthId(authMutex.getAuthId());
			Menu menuMutex = this.jwSystemAuthService.queryMenuByAuthId(authMutex.getMutexAuthId());
			result.setMenu(menu);
			result.setMutexMenu(menuMutex);
			return result;
		} else {
			return null;
		}
	}

	@RequestMapping(value = {"/getAuthTree"}, produces = {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String getAuthTree(HttpServletRequest request, HttpServletResponse response) {
		String tree = "";

		try {
			List e = this.jwSystemAuthService.queryMenuAndFuncAuth();
			tree = SystemUtil.listTreeToAuth(e);
			log.info("权限树: " + tree);
		} catch (Exception arg4) {
			log.info(arg4.getMessage());
		}

		return tree;
	}
}