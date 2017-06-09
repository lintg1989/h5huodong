package com.jeecg.p3.shaketicket.web.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.jeecgframework.p3.core.util.SystemTools;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import com.jeecg.p3.shaketicket.entity.WxActShaketicketConfig;
import com.jeecg.p3.shaketicket.service.WxActShaketicketConfigService;
import org.jeecgframework.p3.core.web.BaseController;

 /**
 * 描述：</b>WxActShaketicketConfigController<br>活动奖项配置表
 * @author pituo
 * @since：2015年12月24日 11时08分29秒 星期四 
 * @version:1.0
 */
@Controller
@RequestMapping("/shaketicket/back/wxActShaketicketConfig")
public class WxActShaketicketConfigController extends BaseController{
  @Autowired
  private WxActShaketicketConfigService wxActShaketicketConfigService;
  
/**
  * 列表页面
  * @return
  */
@RequestMapping(value="list",method = {RequestMethod.GET,RequestMethod.POST})
public void list(@ModelAttribute WxActShaketicketConfig query,HttpServletResponse response,HttpServletRequest request,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
	 	PageQuery<WxActShaketicketConfig> pageQuery = new PageQuery<WxActShaketicketConfig>();
	 	pageQuery.setPageNo(pageNo);
	 	pageQuery.setPageSize(pageSize);
	 	VelocityContext velocityContext = new VelocityContext();
		pageQuery.setQuery(query);
		velocityContext.put("wxActShaketicketConfig",query);
		velocityContext.put("pageInfos",SystemTools.convertPaginatedList(wxActShaketicketConfigService.queryPageList(pageQuery)));
		String viewName = "shaketicket/back/wxActShaketicketConfig-list.vm";
		ViewVelocity.view(request,response,viewName,velocityContext);
}

 /**
  * 详情
  * @return
  */
@RequestMapping(value="toDetail",method = RequestMethod.GET)
public void wxActShaketicketConfigDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "shaketicket/back/wxActShaketicketConfig-detail.vm";
		WxActShaketicketConfig wxActShaketicketConfig = wxActShaketicketConfigService.queryById(id);
		velocityContext.put("wxActShaketicketConfig",wxActShaketicketConfig);
		ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 跳转到添加页面
 * @return
 */
@RequestMapping(value = "/toAdd",method ={RequestMethod.GET, RequestMethod.POST})
public void toAddDialog(HttpServletRequest request,HttpServletResponse response,ModelMap model)throws Exception{
	 VelocityContext velocityContext = new VelocityContext();
	 String viewName = "shaketicket/back/wxActShaketicketConfig-add.vm";
	 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 保存信息
 * @return
 */
@RequestMapping(value = "/doAdd",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doAdd(@ModelAttribute WxActShaketicketConfig wxActShaketicketConfig){
	AjaxJson j = new AjaxJson();
	try {
		wxActShaketicketConfigService.doAdd(wxActShaketicketConfig);
		j.setMsg("保存成功");
	} catch (Exception e) {
		j.setSuccess(false);
		j.setMsg("保存失败");
	}
	return j;
}

/**
 * 跳转到编辑页面
 * @return
 */
@RequestMapping(value="toEdit",method = RequestMethod.GET)
public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 WxActShaketicketConfig wxActShaketicketConfig = wxActShaketicketConfigService.queryById(id);
		 velocityContext.put("wxActShaketicketConfig",wxActShaketicketConfig);
		 String viewName = "shaketicket/back/wxActShaketicketConfig-edit.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
}

/**
 * 编辑
 * @return
 */
@RequestMapping(value = "/doEdit",method ={RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public AjaxJson doEdit(@ModelAttribute WxActShaketicketConfig wxActShaketicketConfig){
	AjaxJson j = new AjaxJson();
	try {
		wxActShaketicketConfigService.doEdit(wxActShaketicketConfig);
		j.setMsg("编辑成功");
	} catch (Exception e) {
		j.setSuccess(false);
		j.setMsg("编辑失败");
	}
	return j;
}


/**
 * 删除
 * @return
 */
@RequestMapping(value="doDelete",method = RequestMethod.GET)
@ResponseBody
public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
		AjaxJson j = new AjaxJson();
		try {
			wxActShaketicketConfigService.doDelete(id);
			j.setMsg("删除成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
}


}

