/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemUserJwid;
import com.jeecg.p3.system.service.JwSystemUserJwidService;
import com.jeecg.p3.system.service.JwWebJwidService;
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
@RequestMapping({"/system/back/jwSystemUserJwid"})
public class JwSystemUserJwidController extends BaseController {
	@Autowired
	private JwSystemUserJwidService jwSystemUserJwidService;
	@Autowired
	private JwWebJwidService jwWebJwidService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemUserJwid query, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		String userId = query.getUserId();
		VelocityContext velocityContext = new VelocityContext();
		if (StringUtils.isNotEmpty(userId)) {
			PageQuery viewName = new PageQuery();
			viewName.setPageNo(pageNo);
			viewName.setPageSize(pageSize);
			viewName.setQuery(query);
			velocityContext.put("jwSystemUserJwid", query);
			velocityContext.put("pageInfos",
					SystemTools.convertPaginatedList(this.jwSystemUserJwidService.queryPageList(viewName)));
		}

		String viewName1 = "system/back/jwSystemUserJwid-list.vm";
		ViewVelocity.view(request, response, viewName1, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemUserJwidDetail(@RequestParam(required = true, value = "id") String id,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemUserJwid-detail.vm";
		JwSystemUserJwid jwSystemUserJwid = this.jwSystemUserJwidService.queryById(id);
		velocityContext.put("jwSystemUserJwid", jwSystemUserJwid);
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(String userId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("userId", userId);
		List jwidList = this.jwWebJwidService.queryJwidsNotInUser(userId);
		velocityContext.put("jwids", jwidList);
		String viewName = "system/back/jwSystemUserJwid-add.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemUserJwid jwSystemUserJwid) {
		AjaxJson j = new AjaxJson();

		try {
			if (StringUtils.isEmpty(jwSystemUserJwid.getUserId())) {
				throw new Exception("用户编码不能为空");
			}

			this.jwSystemUserJwidService.doAdd(jwSystemUserJwid);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败：" + arg3.getMessage());
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemUserJwid jwSystemUserJwid = this.jwSystemUserJwidService.queryById(id);
		velocityContext.put("jwSystemUserJwid", jwSystemUserJwid);
		String viewName = "system/back/jwSystemUserJwid-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemUserJwid jwSystemUserJwid) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemUserJwidService.doEdit(jwSystemUserJwid);
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
	public AjaxJson doDelete(@RequestParam(required = true, value = "id") String id) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwSystemUserJwidService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}
}