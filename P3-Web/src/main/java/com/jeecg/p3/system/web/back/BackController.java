/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/system/back"})
public class BackController extends BaseController {
	@RequestMapping(value = {"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void home(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		try {
			this.LOG.info(request, " back home");
			VelocityContext e = new VelocityContext();
			String viewName = "system/back/home.vm";
			ViewVelocity.view(request, response, viewName, e);
		} catch (Exception arg5) {
			arg5.printStackTrace();
		}

	}
}