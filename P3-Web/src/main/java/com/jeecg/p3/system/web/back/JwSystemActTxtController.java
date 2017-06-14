/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemActTxt;
import com.jeecg.p3.system.service.JwSystemActTxtService;
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
@RequestMapping({"/system/back/jwSystemActTxt"})
public class JwSystemActTxtController extends BaseController {
	@Autowired
	private JwSystemActTxtService jwSystemActTxtService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemActTxt query, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		String backurl = ContextHolderUtils.getRequest().getParameter("backurl");
		pageQuery.setQuery(query);
		velocityContext.put("jwSystemActTxt", query);
		velocityContext.put("backurl", backurl);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemActTxtService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemActTxt-list.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemActTxtDetail(@RequestParam(required = true, value = "id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemActTxt-detail.vm";
		JwSystemActTxt jwSystemActTxt = this.jwSystemActTxtService.queryById(id);
		velocityContext.put("jwSystemActTxt", jwSystemActTxt);
		String backurl = ContextHolderUtils.getRequest().getParameter("backurl");
		velocityContext.put("backurl", backurl);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(@ModelAttribute JwSystemActTxt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemActTxt-add.vm";
		velocityContext.put("jwSystemActTxt", query);
		String backurl = ContextHolderUtils.getRequest().getParameter("backurl");
		velocityContext.put("backurl", backurl);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemActTxt jwSystemActTxt) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemActTxtService.doAdd(jwSystemActTxt);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("保存失败:" + arg3.getMessage());
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemActTxt jwSystemActTxt = this.jwSystemActTxtService.queryById(id);
		velocityContext.put("jwSystemActTxt", jwSystemActTxt);
		String backurl = ContextHolderUtils.getRequest().getParameter("backurl");
		velocityContext.put("backurl", backurl);
		String viewName = "system/back/jwSystemActTxt-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemActTxt jwSystemActTxt) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemActTxtService.doEdit(jwSystemActTxt);
			j.setMsg("编辑成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("编辑失败:" + arg3.getMessage());
		}

		return j;
	}

	@RequestMapping(value = {"doDelete"}, method = {RequestMethod.GET})
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id") String id) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemActTxtService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("删除失败:" + arg3.getMessage());
		}

		return j;
	}
}