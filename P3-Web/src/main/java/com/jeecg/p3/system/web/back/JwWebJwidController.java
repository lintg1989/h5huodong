/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwWebJwid;
import com.jeecg.p3.system.service.JwWebJwidService;
import com.jeecg.p3.system.util.SystemUtil;
import java.util.ArrayList;
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
@RequestMapping({"/system/back/jwWebJwid"})
public class JwWebJwidController extends BaseController {
	@Autowired
	private JwWebJwidService jwWebJwidService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwWebJwid query, HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("query", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwWebJwidService.queryPageList(pageQuery)));
		String viewName = "system/back/jwWebJwid-list.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwWebJwidDetail(@RequestParam(required = true, value = "id") String id, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwWebJwid-detail.vm";
		JwWebJwid jwWebJwid = this.jwWebJwidService.queryById(id);
		velocityContext.put("jwWebJwid", jwWebJwid);
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwWebJwid-add.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwWebJwid jwWebJwid) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwWebJwidService.doAdd(jwWebJwid);
			j.setMsg("保存成功");
		} catch (Exception arg3) {
			arg3.printStackTrace();
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwWebJwid jwWebJwid = this.jwWebJwidService.queryById(id);
		velocityContext.put("jwWebJwid", jwWebJwid);
		String viewName = "system/back/jwWebJwid-edit.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwWebJwid jwWebJwid) {
		AjaxJson j = new AjaxJson();

		try {
			this.jwWebJwidService.doEdit(jwWebJwid);
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
			this.jwWebJwidService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			log.info(arg3.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}

	@RequestMapping(value = {"/initJwid"}, produces = {"text/plain;charset=UTF-8"})
	@ResponseBody
	public String initJwid(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "userId", required = true) String userId) {
		log.info("初始化公众号");
		String tree = "";

		try {
			List e = this.jwWebJwidService.queryJwids();
			List userJwidList = this.jwWebJwidService.queryJwWebJwidByUserId(userId);
			tree = SystemUtil.list2TreeWithCheckToJwid(e, userJwidList);
			log.info("初始化公众号: " + tree);
		} catch (Exception arg6) {
			log.info(arg6.getMessage());
		}

		return tree;
	}

	@RequestMapping(value = {"/editUserJwid"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson editUserJwid(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "checkedNodes", required = true) String checkedNodes,
			@RequestParam(value = "userId", required = true) String userId) {
		AjaxJson j = new AjaxJson();
		log.info("编辑用户公众号");

		try {
			ArrayList e = new ArrayList();
			if (StringUtils.isNotEmpty(checkedNodes)) {
				String[] arr$ = checkedNodes.split(",");
				int len$ = arr$.length;

				for (int i$ = 0; i$ < len$; ++i$) {
					String jwid = arr$[i$];
					e.add(jwid);
				}
			}

			this.jwWebJwidService.modifyOperateUserJwidRel(userId, e);
			j.setSuccess(true);
			j.setMsg("分配成功");
			log.info("编辑用户公众号完成 ");
		} catch (Exception arg10) {
			log.info(arg10.getMessage());
			j.setSuccess(false);
			j.setMsg("分配失败");
		}

		return j;
	}
}