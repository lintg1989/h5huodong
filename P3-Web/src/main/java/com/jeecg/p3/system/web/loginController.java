/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.web;

import com.jeecg.p3.system.entity.JwSystemLogoTitle;
import com.jeecg.p3.system.entity.JwSystemUser;
import com.jeecg.p3.system.entity.JwWebJwid;
import com.jeecg.p3.system.service.JwSystemAuthService;
import com.jeecg.p3.system.service.JwSystemLogoTitleService;
import com.jeecg.p3.system.service.JwSystemUserService;
import com.jeecg.p3.system.service.JwWebJwidService;
import com.jeecg.p3.system.util.JwHttpUtil;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.jeecgframework.p3.core.util.MD5Util;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/system"})
public class loginController extends BaseController {
	public static final Logger LOG = LoggerFactory.getLogger(loginController.class);
	@Autowired
	private JwWebJwidService jwidService;
	@Autowired
	private JwSystemAuthService jwSystemAuthService;
	@Autowired
	private JwSystemLogoTitleService jwSystemLogoTitleService;
	@Autowired
	private JwSystemUserService jwSystemUserService;
	@Value("#{sysconfig[\'sys.jwsso.flg\']}")
	private String sysJwssoFlag;

	@RequestMapping(value = {"/noAuth"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void noAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "base/back/common/error.vm";
		VelocityContext velocityContext = new VelocityContext();
		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/toLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		LoginUser user = (LoginUser) request.getSession().getAttribute("OPERATE_WEB_LOGIN_USER");
		JwSystemLogoTitle logoTitle = (JwSystemLogoTitle) this.jwSystemLogoTitleService.queryLogoTitle().get(0);
		velocityContext.put("logoTitle", logoTitle);
		if (user != null) {
			velocityContext.put("jwidname", (String) request.getSession().getAttribute("jwidname"));
			velocityContext.put("userid", user.getUserId());

			try {
				LinkedHashMap viewName2 = this.jwSystemAuthService.getSubMenuTree(user.getUserId(), (String) null);
				velocityContext.put("OPERATE_WEB_MENU_TREE", viewName2);
				String viewName1 = "base/back/main/index.vm";
				ViewVelocity.view(request, response, viewName1, velocityContext);
			} catch (Exception arg7) {
				arg7.printStackTrace();
			}

		} else {
			String viewName = "base/back/common/login.vm";
			ViewVelocity.view(request, response, viewName, velocityContext);
		}
	}

	@RequestMapping(value = {"/checkUser"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson checkUser(String username, String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AjaxJson j = new AjaxJson();

		try {
			LoginUser e = this.jwSystemUserService.queryUserByUserId(username);
			boolean isAuth = false;
			String passwordEncode = MD5Util.MD5Encode(password, "utf-8");
			if (e != null) {
				if (passwordEncode != null && passwordEncode.equals(e.getPassword())
						&& "NORMAL".equals(e.getUserStat())) {
					isAuth = true;
				} else {
					LOG.info("登录验证失败：用户【" + username + "】登录信息验证不通过");
				}
			} else if ("Y".equals(this.sysJwssoFlag)) {
				e = this.jwSSO(username, password);
				if (e != null) {
					JwSystemUser jwSystemUser = new JwSystemUser();
					jwSystemUser.setUserId(username);
					jwSystemUser.setUserName(e.getUserName());
					jwSystemUser.setPassword(passwordEncode);
					jwSystemUser.setCreateDt(new Date());
					jwSystemUser.setUserStat("NORMAL");
					ArrayList roleIds = new ArrayList();
					roleIds.add("01");
					this.jwSystemUserService.doAdd(jwSystemUser, roleIds);
					isAuth = true;
				} else {
					LOG.info("登录验证失败：用户【" + username + "】捷微平台权限验证不通过");
				}
			} else {
				LOG.info("登录验证失败：用户【" + username + "】不存在");
			}

			if (isAuth) {
				LOG.info("登录验证成功：用户【" + username + "】权限验证通过");
				j.setSuccess(true);
				j.setMsg("登录验证成功");
				return j;
			}

			LOG.info("登录验证失败：用户【" + username + "】权限验证不通过");
			j.setSuccess(false);
			j.setMsg("登录验证失败");
		} catch (Exception arg10) {
			LOG.info("登录验证失败：用户【" + username + "】" + arg10.getMessage());
			j.setSuccess(false);
			j.setMsg("登录验证失败");
		}

		return j;
	}

	@RequestMapping(value = {"/preLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void preLogin(String username, String password, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "base/back/common/prelogin.vm";

		try {
			LoginUser e = this.jwSystemUserService.queryUserByUserId(username);
			boolean isAuth = false;
			String passwordEncode = MD5Util.MD5Encode(password, "utf-8");
			if (e != null) {
				if (passwordEncode != null && passwordEncode.equals(e.getPassword())
						&& "NORMAL".equals(e.getUserStat())) {
					isAuth = true;
				} else {
					LOG.info("登录验证失败：用户【" + username + "】登录信息验证不通过");
				}
			}

			Object jwids = new ArrayList();
			if (isAuth) {
				jwids = this.jwidService.queryJwWebJwidByUserId(username);
			} else {
				LOG.info("登录验证失败：用户【" + username + "】权限验证不通过");
			}

			velocityContext.put("jwids", jwids);
			velocityContext.put("sysJwssoFlag", this.sysJwssoFlag);
		} catch (Exception arg10) {
			LOG.info("登录验证失败：用户【" + username + "】" + arg10.getMessage());
		}

		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	private LoginUser jwSSO(String username, String password) {
		return JwHttpUtil.jwSSO(username, password);
	}

	private void syncUserJwid(String username) {
		List jwidList = JwHttpUtil.getJwids(username);
		this.jwidService.syncJwid(username, jwidList);
	}

	@RequestMapping(value = {"/syncJwid"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void syncJwid(String username, String password, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "base/back/common/prelogin.vm";

		try {
			this.syncUserJwid(username);
			List e = this.jwidService.queryJwWebJwidByUserId(username);
			if (e != null && e.size() > 0) {
				velocityContext.put("jwid_select_flag", "jwid_select_flag_success");
			} else {
				velocityContext.put("jwid_select_flag", "jwid_select_flag_fail");
			}

			velocityContext.put("jwids", e);
		} catch (Exception arg7) {
			LOG.info("同步微信公众号失败：用户【" + username + "】" + arg7.getMessage());
		}

		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	@RequestMapping(value = {"/login"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void login(String jwid, String username, String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = "base/back/common/login.vm";
		VelocityContext velocityContext = new VelocityContext();

		try {
			LoginUser e = (LoginUser) request.getSession().getAttribute("OPERATE_WEB_LOGIN_USER");
			JwSystemLogoTitle logoTitle = (JwSystemLogoTitle) this.jwSystemLogoTitleService.queryLogoTitle().get(0);
			velocityContext.put("logoTitle", logoTitle);
			if (e != null) {
				viewName = "base/back/main/index.vm";
				velocityContext.put("jwidname", (String) request.getSession().getAttribute("jwidname"));
				velocityContext.put("userid", e.getUserId());

				try {
					LinkedHashMap passwordEncode1 = this.jwSystemAuthService.getSubMenuTree(e.getUserId(),
							(String) null);
					velocityContext.put("OPERATE_WEB_MENU_TREE", passwordEncode1);
					ViewVelocity.view(request, response, viewName, velocityContext);
				} catch (Exception arg13) {
					arg13.printStackTrace();
				}

				return;
			}

			this.validateLoginParam(jwid, username, password);
			e = this.jwSystemUserService.queryUserByUserId(username);
			if (e != null) {
				String passwordEncode = MD5Util.MD5Encode(password, "utf-8");
				if (passwordEncode != null && passwordEncode.equals(e.getPassword())
						&& "NORMAL".equals(e.getUserStat())) {
					JwWebJwid jw = this.jwidService.queryJwidByJwidAndUserId(jwid, username);
					if (jw != null) {
						request.getSession().setAttribute("jwid", jwid);
						request.getSession().setAttribute("jwidname", jw.getName());
						request.getSession().setAttribute("OPERATE_WEB_LOGIN_USER", e);
						velocityContext.put("jwidname", jw.getName());
						velocityContext.put("userid", e.getUserId());

						try {
							LinkedHashMap e1 = this.jwSystemAuthService.getSubMenuTree(e.getUserId(), (String) null);
							velocityContext.put("OPERATE_WEB_MENU_TREE", e1);
							viewName = "base/back/main/index.vm";
							ViewVelocity.view(request, response, viewName, velocityContext);
						} catch (Exception arg12) {
							arg12.printStackTrace();
						}

						return;
					}

					LOG.info("登录失败：jwid【" + jwid + "】不属于用户【" + username + "】");
				}
			} else {
				LOG.info("登录失败：用户【" + username + "】不存在");
			}
		} catch (Exception arg14) {
			LOG.info("登录失败：用户【" + username + "】" + arg14.getMessage());
		}

		ViewVelocity.view(request, response, viewName, velocityContext);
	}

	private void validateLoginParam(String jwid, String username, String password) {
		if (StringUtils.isEmpty(username)) {
			throw new RuntimeException("登录用户为空");
		} else if (StringUtils.isEmpty(password)) {
			throw new RuntimeException("用户密码为空");
		} else if (StringUtils.isEmpty(jwid)) {
			throw new RuntimeException("微信公众号为空");
		}
	}

	@RequestMapping(value = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void logout(String jwid, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "base/back/common/login.vm";
		VelocityContext velocityContext = new VelocityContext();
		JwSystemLogoTitle logoTitle = (JwSystemLogoTitle) this.jwSystemLogoTitleService.queryLogoTitle().get(0);
		velocityContext.put("logoTitle", logoTitle);
		request.getSession().removeAttribute("jwid");
		request.getSession().removeAttribute("jwidname");
		request.getSession().removeAttribute("OPERATE_WEB_LOGIN_USER");
		ViewVelocity.view(request, response, viewName, velocityContext);
	}
}