/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemAct;
import com.jeecg.p3.system.service.JwSystemActService;
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
@RequestMapping({"/system/back/jwSystemAct"})
public class JwSystemActController extends BaseController {
	@Autowired
	private JwSystemActService jwSystemActService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemAct query, HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		String jwid = ContextHolderUtils.getSession().getAttribute("jwid").toString();
		query.setJwid(jwid);
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemAct", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemActService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemAct-list.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemActDetail(@RequestParam(required = true, value = "id") String id, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemAct-detail.vm";
		JwSystemAct jwSystemAct = this.jwSystemActService.queryById(id);
		velocityContext.put("jwSystemAct", jwSystemAct);
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemAct-add.vm";
		velocityContext.put("type", request.getParameter("type"));
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemAct jwSystemAct) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemActService.doAdd(jwSystemAct);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemAct jwSystemAct = this.jwSystemActService.queryById(id);
		velocityContext.put("jwSystemAct", jwSystemAct);
		String viewName = "system/back/jwSystemAct-edit.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemAct jwSystemAct) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemActService.doEdit(jwSystemAct);
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
			this.jwSystemActService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}
}