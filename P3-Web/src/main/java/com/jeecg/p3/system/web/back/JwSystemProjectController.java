/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import com.jeecg.p3.system.entity.JwSystemProject;
import com.jeecg.p3.system.service.JwSystemProjectService;
import com.jeecg.p3.system.util.ContextHolderUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.util.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping({"/system/back/jwSystemProject"})
public class JwSystemProjectController extends BaseController {
	@Autowired
	private JwSystemProjectService jwSystemProjectService;

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void list(@ModelAttribute JwSystemProject query, HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageNo(pageNo);
		pageQuery.setPageSize(pageSize);
		VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("query", query);
		velocityContext.put("pageInfos",
				SystemTools.convertPaginatedList(this.jwSystemProjectService.queryPageList(pageQuery)));
		String viewName = "system/back/jwSystemProject-list.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"toDetail"}, method = {RequestMethod.GET})
	public void jwSystemProjectDetail(@RequestParam(required = true, value = "id") String id,
			HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemProject-detail.vm";
		JwSystemProject jwSystemProject = this.jwSystemProjectService.queryById(id);
		velocityContext.put("jwSystemProject", jwSystemProject);
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "system/back/jwSystemProject-add.vm";
		ViewVelocity.view(response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doAdd"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JwSystemProject jwSystemProject) {
		AjaxJson j = new AjaxJson();

		try {
			Boolean e = this.jwSystemProjectService.validReat(jwSystemProject.getCode(), jwSystemProject.getId());
			if (e.booleanValue()) {
				j.setSuccess(false);
				j.setMsg("项目编码重复，请重新设置");
			} else {
				this.jwSystemProjectService.doAdd(jwSystemProject);
				j.setMsg("保存成功");
			}
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"toEdit"}, method = {RequestMethod.GET})
	public void toEdit(@RequestParam(required = true, value = "id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		JwSystemProject jwSystemProject = this.jwSystemProjectService.queryById(id);
		velocityContext.put("jwSystemProject", jwSystemProject);
		String viewName = "system/back/jwSystemProject-edit.vm";
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/doEdit"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JwSystemProject jwSystemProject) {
		AjaxJson j = new AjaxJson();

		try {
			Boolean e = this.jwSystemProjectService.validReat(jwSystemProject.getCode(), jwSystemProject.getId());
			if (e.booleanValue()) {
				j.setSuccess(false);
				j.setMsg("项目编码重复，请重新设置");
			} else {
				this.jwSystemProjectService.doEdit(jwSystemProject);
				j.setMsg("编辑成功");
			}
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
			this.jwSystemProjectService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception arg3) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}

		return j;
	}

	@RequestMapping(value = {"/doUpload"}, method = {RequestMethod.POST})
	@ResponseBody
	public AjaxJson doUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		try {
			MultipartFile e = request.getFile("file");
			byte[] bytes = e.getBytes();
			System.out.println(e.getOriginalFilename());
			String uploadDir = ContextHolderUtils.getRequest().getSession().getServletContext()
					.getRealPath("upload/img/system");
			File dirPath = new File(uploadDir);
			if (!dirPath.exists()) {
				dirPath.mkdirs();
			}

			String sep = System.getProperty("file.separator");
			File uploadedFile = new File(uploadDir + sep + e.getOriginalFilename());
			FileCopyUtils.copy(bytes, uploadedFile);
			j.setMsg("保存成功");
		} catch (Exception arg9) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		}

		return j;
	}

	@RequestMapping(value = {"/getProjList"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson recieveState(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		try {
			PageQuery e = new PageQuery();
			JwSystemProject query = new JwSystemProject();
			e.setPageNo(1);
			e.setPageSize(100);
			e.setQuery(query);
			PageList projectList = this.jwSystemProjectService.queryPageList(e);
			JSONArray result = new JSONArray();
			if (projectList != null && projectList.getValues() != null && projectList.getValues().size() > 0) {
				List attrs = projectList.getValues();

				for (int i = 0; i < attrs.size(); ++i) {
					JSONObject jsonParts = new JSONObject();
					jsonParts.put("name", ((JwSystemProject) attrs.get(i)).getName());
					jsonParts.put("img", ((JwSystemProject) attrs.get(i)).getImg());
					result.add(jsonParts);
				}
			}

			HashMap arg10 = new HashMap();
			arg10.put("projectList", result);
			j.setAttributes(arg10);
			j.setSuccess(true);
		} catch (Exception arg9) {
			j.setSuccess(false);
			j.setMsg("访问异常！");
			this.LOG.error("recieveState error:{}", arg9.getMessage());
		}

		return j;
	}
}