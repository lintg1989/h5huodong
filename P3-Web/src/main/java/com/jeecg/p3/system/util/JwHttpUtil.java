/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeecg.p3.system.entity.JwWebJwid;
import com.jeecg.p3.system.vo.LoginUser;
import java.util.ArrayList;
import java.util.List;
import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.jeecgframework.p3.core.util.WeiXinHttpUtil;

public class JwHttpUtil {
	public static final Logger log = LoggerFactory.getLogger(JwHttpUtil.class);

	public static LoginUser jwSSO(String username, String password) {
		LoginUser user = null;

		try {
			String e = WeiXinHttpUtil.getLocalValue("system", "getSSOUserUrl");
			e = e + "&userName=" + username;
			e = e + "&password=" + password;
			JSONObject jsonObj = WeiXinHttpUtil.sendPost(e);
			log.info("捷微平台权限验证response:{}", jsonObj.toJSONString());
			if (jsonObj.containsKey("success")) {
				String success = jsonObj.getString("success");
				if ("true".equals(success)) {
					user = new LoginUser();
					user.setUserId(username);
					user.setUserName(jsonObj.getString("userRealName"));
					return user;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception arg5) {
			log.info("捷微平台权限验证异常:{}", arg5.getMessage());
			return null;
		}
	}

	public static List<JwWebJwid> getJwids(String username) {
		ArrayList jwidList = null;

		try {
			String e = WeiXinHttpUtil.getLocalValue("system", "getJwidsUrl");
			e = e + "&userName=" + username;
			JSONObject jsonObj = WeiXinHttpUtil.sendPost(e);
			log.info("捷微平台获取用户的分配的公众号response:{}", jsonObj.toJSONString());
			if (jsonObj.containsKey("success")) {
				String success = jsonObj.getString("success");
				if ("true".equals(success)) {
					jwidList = new ArrayList();
					JwWebJwid jwWebJwid = null;
					JSONArray array = jsonObj.getJSONArray("jwids");
					if (array != null && array.size() > 0) {
						for (int i = 0; i < array.size(); ++i) {
							JSONObject obj = array.getJSONObject(i);
							jwWebJwid = new JwWebJwid();
							jwWebJwid.setJwid(obj.getString("jwid"));
							jwWebJwid.setName(obj.getString("name"));
							jwidList.add(jwWebJwid);
						}

						return jwidList;
					}
				}
			}
		} catch (Exception arg8) {
			log.info("捷微平台获取用户的分配的公众号异常:{}", arg8.getMessage());
		}

		return null;
	}
}