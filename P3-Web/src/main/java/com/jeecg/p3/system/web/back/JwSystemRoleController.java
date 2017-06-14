/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemRole;
import com.jeecg.p3.system.service.JwSystemRoleService;
import java.util.Date;
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
@RequestMapping({"/system/back/jwSystemRole"})
public class JwSystemRoleController extends BaseController {
	@Autowired
	private JwSystemRoleService jwSystemRoleService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemRole query, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemRole", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemRoleService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemRole-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemRoleDetail(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemRole-detail.vm";
		JwSystemRole jwSystemRole = this.jwSystemRoleService.queryById(id);
		velocityContext.put("jwSystemRole", jwSystemRole);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemRole-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemRole jwSystemRole) {
		AjaxJson j = new AjaxJson();

		try {
			jwSystemRole.setDelStat("0");
			jwSystemRole.setCreateDt(new Date());
			this.jwSystemRoleService.doAdd(jwSystemRole);
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
		JwSystemRole jwSystemRole = this.jwSystemRoleService.queryById(id);
		velocityContext.put("jwSystemRole", jwSystemRole);
		String viewName = "system/back/jwSystemRole-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemRole jwSystemRole) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemRoleService.doEdit(jwSystemRole);
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
			JwSystemRole e = this.jwSystemRoleService.queryById(id);
			if ("00".equals(e.getRoleId())) {
				j.setSuccess(false);
				j.setMsg("系统管理员角色不能删除");
			}

			this.jwSystemRoleService.doDelete(id, e.getRoleId());
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}

	@RequestMapping(value = {"toPrivilegeTree"}, method = {RequestMethod.GET})
	public void toPrivilegeTree(@RequestParam(required = true, value = "id") Long id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemRole jwSystemRole = this.jwSystemRoleService.queryById(id);
		velocityContext.put("jwSystemRole", jwSystemRole);
		String viewName = "system/back/jwSystemRole-privilegetree.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}
}