/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.service.impl;

import com.jeecg.p3.system.dao.JwSystemUserJwidDao;
import com.jeecg.p3.system.dao.JwWebJwidDao;
import com.jeecg.p3.system.entity.JwSystemUserJwid;
import com.jeecg.p3.system.entity.JwWebJwid;
import com.jeecg.p3.system.service.JwWebJwidService;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.jeecgframework.p3.core.utils.common.PageList;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.jeecgframework.p3.core.utils.common.Pagenation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jwWebJwidService")
public class JwWebJwidServiceImpl implements JwWebJwidService {
	@Resource
	private JwWebJwidDao jwWebJwidDao;
	@Resource
	private JwSystemUserJwidDao jwSystemUserJwidDao;

	public void doAdd(JwWebJwid jwWebJwid) {
		this.jwWebJwidDao.add(jwWebJwid);
	}

	public void doEdit(JwWebJwid jwWebJwid) {
		this.jwWebJwidDao.update(jwWebJwid);
	}

	public void doDelete(String id) {
		this.jwWebJwidDao.delete(id);
	}

	public JwWebJwid queryById(String id) {
		JwWebJwid jwWebJwid = (JwWebJwid) this.jwWebJwidDao.get(id);
		return jwWebJwid;
	}

	public PageList<JwWebJwid> queryPageList(PageQuery<JwWebJwid> pageQuery) {
		PageList result = new PageList();
		Integer itemCount = this.jwWebJwidDao.count(pageQuery);
		List list = this.jwWebJwidDao.queryPageList(pageQuery, itemCount);
		Pagenation pagenation = new Pagenation(pageQuery.getPageNo(), itemCount.intValue(), pageQuery.getPageSize());
		result.setPagenation(pagenation);
		result.setValues(list);
		return result;
	}

	public List<JwWebJwid> queryJwids() {
		return this.jwWebJwidDao.queryJwids();
	}

	public JwWebJwid queryJwidNameByJwid(String jwid) {
		return this.jwWebJwidDao.queryJwidNameByJwid(jwid);
	}

	public List<JwWebJwid> queryJwWebJwidByUserId(String userId) {
		return this.jwWebJwidDao.queryJwWebJwidByUserId(userId);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void syncJwid(String username, List<JwWebJwid> list) {
		List exitList = this.jwWebJwidDao.queryJwWebJwidByUserId(username);
		if (list != null && list.size() > 0) {
			Iterator i$ = list.iterator();

			while (i$.hasNext()) {
				JwWebJwid jwWebJwid = (JwWebJwid) i$.next();
				JwWebJwid jwid = this.jwWebJwidDao.queryJwidNameByJwid(jwWebJwid.getJwid());
				JwSystemUserJwid jwSystemUserJwid;
				if (jwid == null) {
					this.jwWebJwidDao.add(jwWebJwid);
					jwSystemUserJwid = new JwSystemUserJwid();
					jwSystemUserJwid.setUserId(username);
					jwSystemUserJwid.setJwid(jwWebJwid.getJwid());
					this.jwSystemUserJwidDao.add(jwSystemUserJwid);
				} else if (!this.isExist(jwWebJwid.getJwid(), exitList)) {
					jwSystemUserJwid = new JwSystemUserJwid();
					jwSystemUserJwid.setUserId(username);
					jwSystemUserJwid.setJwid(jwWebJwid.getJwid());
					this.jwSystemUserJwidDao.add(jwSystemUserJwid);
				}
			}
		}

	}

	private boolean isExist(String jwid, List<JwWebJwid> list) {
		if (list != null && list.size() > 0) {
			Iterator i$ = list.iterator();

			while (i$.hasNext()) {
				JwWebJwid jwWebJwid = (JwWebJwid) i$.next();
				if (jwid.equals(jwWebJwid.getJwid())) {
					return true;
				}
			}
		}

		return false;
	}

	public JwWebJwid queryJwidByJwidAndUserId(String jwid, String userId) {
		return this.jwWebJwidDao.queryJwidByJwidAndUserId(jwid, userId);
	}

	public List<JwWebJwid> queryJwidsNotInUser(String userId) {
		return this.jwWebJwidDao.queryJwidsNotInUser(userId);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void modifyOperateUserJwidRel(String userId, List<String> jwids) {
		this.jwWebJwidDao.deleteUserJwidByUserid(userId);
		if (jwids != null && jwids.size() > 0) {
			Iterator i$ = jwids.iterator();

			while (i$.hasNext()) {
				String jwid = (String) i$.next();
				this.jwWebJwidDao.insertUserJwidRels(userId, jwid);
			}
		}

	}
}