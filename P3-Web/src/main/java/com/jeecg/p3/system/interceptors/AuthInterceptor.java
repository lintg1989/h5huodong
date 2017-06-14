/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.interceptors;

import com.jeecg.p3.system.service.JwSystemAuthService;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {
	public static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	@Autowired
	private JwSystemAuthService jwSystemAuthService;
	private List<String> excludeUrls;
	private String mode;

	public List<String> getExcludeUrls() {
		return this.excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		if ("DEV".equals(this.mode)) {
			return true;
		} else {
			String requestPath = this.getRequestPath(request);
			String basePath = request.getContextPath();
			request.setAttribute("basePath", basePath);
			if (this.excludeUrls.contains(requestPath)) {
				return true;
			} else if (requestPath != null && requestPath.indexOf(".do") > -1) {
				if (requestPath != null && requestPath.indexOf("/back/") > -1) {
					LoginUser user = (LoginUser) request.getSession().getAttribute("OPERATE_WEB_LOGIN_USER");
					if (user == null) {
						String url = basePath + "/system/toLogin.do";
						response.sendRedirect(url);
						return false;
					} else if (!this.checkUriAuth(requestPath, user.getUserId())) {
						logger.debug("无操作权限！");
						response.setStatus(401);
						return false;
					} else {
						return true;
					}
				} else {
					return true;
				}
			} else {
				return true;
			}
		}
	}

	private String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length() + 1);
		return requestPath;
	}

	private boolean checkUriAuth(String requestPath, String userId) {
		requestPath = "/" + requestPath;
		List list = this.jwSystemAuthService.queryAuthByAuthContr(requestPath);
		if (list != null && list.size() > 0) {
			List authList = this.jwSystemAuthService.queryAuthByUserIdAndAuthContr(userId, requestPath);
			return authList != null && authList.size() > 0;
		} else {
			return true;
		}
	}
}