/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemProjectErrorConfig;
import com.jeecg.p3.system.service.JwSystemProjectErrorConfigService;
import com.jeecg.p3.system.util.ContextHolderUtils;
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
@RequestMapping({"/system/back/jwSystemProjectErrorConfig"})
public class JwSystemProjectErrorConfigController extends BaseController {
	@Autowired
	private JwSystemProjectErrorConfigService jwSystemProjectErrorConfigService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemProjectErrorConfig query, HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		String jwid = ContextHolderUtils.getSession().getAttribute("jwid").toString();
		query.setJwid(jwid);
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemProjectErrorConfig", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemProjectErrorConfigService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemProjectErrorConfig-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemProjectErrorConfigDetail(@RequestParam(required = true, value = "id") String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemProjectErrorConfig-detail.vm";
		JwSystemProjectErrorConfig jwSystemProjectErrorConfig = this.jwSystemProjectErrorConfigService.queryById(id);
		velocityContext.put("jwSystemProjectErrorConfig", jwSystemProjectErrorConfig);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemProjectErrorConfig-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemProjectErrorConfig jwSystemProjectErrorConfig) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemProjectErrorConfigService.doAdd(jwSystemProjectErrorConfig);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemProjectErrorConfig jwSystemProjectErrorConfig = this.jwSystemProjectErrorConfigService.queryById(id);
		velocityContext.put("jwSystemProjectErrorConfig", jwSystemProjectErrorConfig);
		String viewName = "system/back/jwSystemProjectErrorConfig-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemProjectErrorConfig jwSystemProjectErrorConfig) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemProjectErrorConfigService.doEdit(jwSystemProjectErrorConfig);
			j.setMsg("编辑成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}

		return j;
	}

	@RequestMapping(value = {"doDelete"}, method = {RequestMethod.GET})
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id") String id) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemProjectErrorConfigService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}
}