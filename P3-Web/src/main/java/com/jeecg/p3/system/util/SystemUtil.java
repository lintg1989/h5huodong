/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.jeecg.p3.system.util;

import com.jeecg.p3.system.entity.JwWebJwid;
import com.jeecg.p3.system.entity.MenuFunction;
import com.jeecg.p3.system.entity.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;

public class SystemUtil {
	public static String list2TreeWithCheck(List<MenuFunction> allList, List<MenuFunction> roleList) {
		if (allList != null && allList.size() > 0) {
			ArrayList treeList = new ArrayList();
			Iterator jsonArray = allList.iterator();

			while (jsonArray.hasNext()) {
				MenuFunction auth = (MenuFunction) jsonArray.next();
				TreeNode tn = new TreeNode();
				tn.setId(auth.getAuthId());
				String pId = "0";
				if (auth.getParentAuthId() != null && !auth.getParentAuthId().equals("")) {
					pId = auth.getParentAuthId();
				}

				tn.setpId(pId);
				tn.setName(auth.getAuthName());
				if (!"1".equals(auth.getAuthType()) && !"Y".equals(auth.getLeafInd())) {
					tn.setOpen(true);
				} else {
					tn.setOpen(false);
				}

				tn.setChecked(false);
				Iterator i$ = roleList.iterator();

				while (i$.hasNext()) {
					MenuFunction mf = (MenuFunction) i$.next();
					if (mf.getAuthId().equals(auth.getAuthId())) {
						tn.setChecked(true);
						break;
					}
				}

				tn.setDoCheck(false);
				tn.setHalfCheck(false);
				tn.setParent(false);
				tn.setChkDisabled(false);
				tn.setNocheck(false);
				treeList.add(tn);
			}

			JSONArray jsonArray1 = JSONArray.fromObject(treeList);
			return jsonArray1.toString();
		} else {
			return "";
		}
	}

	public static String list2TreeWithCheckToJwid(List<JwWebJwid> allList, List<JwWebJwid> roleList) {
		if (allList != null && allList.size() > 0) {
			ArrayList treeList = new ArrayList();
			Iterator jsonArray = allList.iterator();

			while (jsonArray.hasNext()) {
				JwWebJwid auth = (JwWebJwid) jsonArray.next();
				TreeNode tn = new TreeNode();
				tn.setId(auth.getJwid());
				String pId = "0";
				tn.setpId(pId);
				tn.setName(auth.getName());
				tn.setChecked(false);
				Iterator i$ = roleList.iterator();

				while (i$.hasNext()) {
					JwWebJwid mf = (JwWebJwid) i$.next();
					if (mf.getJwid().equals(auth.getJwid())) {
						tn.setChecked(true);
						break;
					}
				}

				tn.setDoCheck(false);
				tn.setHalfCheck(false);
				tn.setParent(false);
				tn.setChkDisabled(false);
				tn.setNocheck(false);
				treeList.add(tn);
			}

			JSONArray jsonArray1 = JSONArray.fromObject(treeList);
			return jsonArray1.toString();
		} else {
			return "";
		}
	}

	public static String listTreeToAuth(List<MenuFunction> allList) {
		if (allList != null && allList.size() > 0) {
			ArrayList treeList = new ArrayList();
			Iterator jsonArray = allList.iterator();

			while (jsonArray.hasNext()) {
				MenuFunction auth = (MenuFunction) jsonArray.next();
				TreeNode tn = new TreeNode();
				tn.setId(auth.getAuthId());
				String pId = "0";
				if (auth.getParentAuthId() != null && !auth.getParentAuthId().equals("")) {
					pId = auth.getParentAuthId();
				}

				tn.setpId(pId);
				tn.setName(auth.getAuthName());
				if (!"1".equals(auth.getAuthType()) && !"Y".equals(auth.getLeafInd())) {
					tn.setOpen(true);
				} else {
					tn.setOpen(false);
				}

				tn.setChecked(false);
				tn.setDoCheck(false);
				tn.setHalfCheck(false);
				tn.setParent(false);
				tn.setChkDisabled(false);
				tn.setNocheck(false);
				treeList.add(tn);
			}

			JSONArray jsonArray1 = JSONArray.fromObject(treeList);
			return jsonArray1.toString();
		} else {
			return "";
		}
	}
}