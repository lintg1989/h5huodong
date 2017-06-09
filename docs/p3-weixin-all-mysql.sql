/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50037
Source Host           : localhost:3306
Source Database       : p3-weixin

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2016-08-30 14:41:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `jw_system_act`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_act`;
CREATE TABLE `jw_system_act` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `act_code` varchar(100) NOT NULL COMMENT '活动项目编码',
  `act_name` varchar(100) NOT NULL COMMENT '活动名称',
  `act_discribe` varchar(300) default NULL COMMENT '活动描述',
  `type` varchar(30) default NULL COMMENT '活动类型',
  `jwid` varchar(64) NOT NULL COMMENT '微信原始ID',
  `creat_name` varchar(50) default NULL COMMENT '创建人',
  `creat_time` datetime default NULL COMMENT '创建时间',
  `update_name` varchar(50) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actcode` (`act_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动项目表';

-- ----------------------------
-- Records of jw_system_act
-- ----------------------------

-- ----------------------------
-- Table structure for `jw_system_act_txt`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_act_txt`;
CREATE TABLE `jw_system_act_txt` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `code` varchar(100) NOT NULL COMMENT '文本编码',
  `content` varchar(2000) NOT NULL COMMENT '文本内容',
  `discribe` varchar(100) default NULL COMMENT '文本描述',
  `act_code` varchar(32) NOT NULL COMMENT '所属活动',
  `jwid` varchar(64) default NULL COMMENT '微信原始ID',
  `creat_name` varchar(50) default NULL COMMENT '创建人',
  `creat_time` datetime default NULL COMMENT '创建时间',
  `update_name` varchar(50) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_code_actcode` (`code`,`act_code`),
  KEY `idx_code_actcode` (`code`,`act_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统文本表';

-- ----------------------------
-- Records of jw_system_act_txt
-- ----------------------------
INSERT INTO `jw_system_act_txt` VALUES ('402880ee5146cebf015146e54e74000b', 'index.tip.noBindPhone', '请在公众号回复手机号进行绑定', '没有绑定手机号提示语', '402880ee5127c20a0151283904170012', null, null, '2015-11-27 11:03:31', null, '2015-11-27 11:04:51');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee5146cebf015146ea058b000c', 'index.tip.noFocus', '关注才能参与抽奖游戏哦~', '未关注提示语', '402880ee5127c20a0151283904170012', null, null, '2015-11-27 11:08:40', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51555f50151f23e63310003', 'statistics', 'var _hmt = _hmt || [];\n(function() {\n  var hm = document.createElement(\"script\");\n  hm.src = \"//hm.baidu.com/hm.js?8e37bf5be2b9827bc5af38b321f6bb38\";\n  var s = document.getElementsByTagName(\"script\")[0]; \n  s.parentNode.insertBefore(hm, s);\n})();', '统计脚本', '402880ee51cd37910151cd4702720001', null, null, '2015-12-30 17:35:53', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a2bcf5480005', 'index.tip.shareFriendTitle', '幸运九宫格', '分享给好友的标题', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:44:09', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bb41360001', 'index.title', '幸运九宫格', '首页标题', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:42:16', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bba59f0002', 'myprizes.title', '我的奖品', '我的奖品页标题', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:42:42', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bbfff80003', 'winners.title', '获奖名单', '获奖名单页标题	', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:43:05', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bc82270004', 'index.tip.shareFriendCircle', '快来抽取属于你的奖品吧~', '分享到朋友圈的文字', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:43:39', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bcf7460005', 'index.tip.shareFriend', '快来抽取属于你的奖品吧~', '分享给好友的文字', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:44:09', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bd55c50006', 'index.img.share', 'http://h5.jeewx.com/content/jiugongge/img/fx_img.jpg', '分享小图	', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:44:33', null, '2015-12-15 12:02:24');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bdb6590007', 'index.tip.ylj', '领奖成功，请到我的奖品中查看', '已领奖提示	', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:44:57', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3be4f8c0008', 'index.actdesc', '亲，请点击进入九宫格抽奖活动页面，祝您好运哦！<br/>活动时间:2015-11-12至2016-06-01<br/><strong>兑奖请联系我们，电话138********</strong>', '活动说明', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:45:37', null, '2015-12-22 14:55:13');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3bf91c60009', 'prelink', 'http://www.guojusoft.com', '预设链接', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 11:46:59', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a3ba7e0151a3d2e888000a', 'index.img.erweima', 'rwm.jpg', '二维码', '402880ee5127c20a0151283904170012', null, null, '2015-12-15 12:08:07', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a8fdd50151a9049ce20001', 'controller.exception.nocount', '您的抽奖次数已经用完，不能再次抽奖。', '抽奖次数用完提示语', '402880ee5127c20a0151283904170012', null, null, '2015-12-16 12:20:30', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51a8fdd50151a906cdeb0002', 'controller.exception.nownocount', '您今日抽奖次数已经用完，请明日再来。', '今日抽奖次数用完提示语', '402880ee5127c20a0151283904170012', null, null, '2015-12-16 12:22:54', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d38209a8000c', 'controller.exception.nocount', '您的抽奖次数已经用完', '总次数用完', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:21:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d3829cba000d', 'controller.exception.nownocount', '您今日抽奖次数已经用完', '今日抽奖次数用万', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:22:11', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d3832f6c000e', 'index.title', '摇一摇', '标题', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:22:48', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d3852f76000f', 'detail', '摇一摇中卡券活动，活动时间:2015年1月1日', '活动说明', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:24:59', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d3875d550010', 'index.tip.nobindingphone', '请绑定手机号', '没绑定手机号', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:27:22', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d387e7320011', 'index.tip.nofocus', '请先关注', '请先关注', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:27:57', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d3506a0151d38c437c0012', 'controller.exception.winnotcanjoin', '中奖不可继续参与', '中奖不可继续参与', '402880ee51cd37910151cd4702720001', null, null, '2015-12-24 18:32:43', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d7fd1f0055d83ba1d20027', 'index.tip.sharefriendtitle', '快来摇一摇', '分享给好友的标题', '402880ee51cd37910151cd4702720001', null, null, '2015-12-25 16:05:16', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d7fd1f0151d82a2c900025', 'index.tip.sharefriendcircle', '摇一摇中大奖啦', '分享到朋友圈的文案', '402880ee51cd37910151cd4702720001', null, null, '2015-12-25 16:03:41', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d7fd1f0151d82ab77b0026', 'index.img.share', 'http://h5.jeewx.com/content/shaketicket/default/img/picurl-shake.jpg', '分享小图', '402880ee51cd37910151cd4702720001', null, null, '2015-12-25 16:04:16', null, '2015-12-25 16:06:42');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee51d7fd1f0151d82ba0d20027', 'index.tip.sharefriend', '摇一摇中大奖啦', '分享给好友的文案', '402880ee51cd37910151cd4702720001', null, null, '2015-12-25 16:05:16', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152154beacf0000', 'home.title', '入伙斧头帮', '首页标题', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 12:57:22', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152154cdb8d0001', 'information.title', '我的斧头帮', '个人信息页标题', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 12:58:24', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152154dc3400002', 'bhykj.title', '亲友团', '帮好友砍价页面标题', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 12:59:23', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152154ec8790003', 'detail.title', '活动说明', '活动说明页面标题', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:00:30', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea01521550a7cd0004', 'detail.part1', '           <p class=\"detail_ggxx_title\">一、<span>特权活动时间：</span>2015年12月12-24日</p><br />\n           <p class=\"detail_ggxx_title\">二、<span>特权活动对象：</span>仅限江苏省内用户参加，需关注官方微信<i>“沃江苏”。</i></p><br />\n           <p class=\"detail_ggxx_title\">三、<span>特权活动玩法：</span></p>\n           <p class=\"detail_ggxx_list_word\">\n               <span class=\"detail_ggxx_xmfh\">1、</span>\n               <i class=\"detail_ggxx_xmnr\">选中心仪的特权产品，点击“我要砍价”，选择“请人帮砍”分享朋友圈或邀请好友帮忙砍价；</i>\n           </p>\n           <p class=\"detail_ggxx_list_word\">\n               <span class=\"detail_ggxx_xmfh\">2、</span>\n               <i class=\"detail_ggxx_xmnr\">当砍至底价时，点击“立即兑换”，系统将发放对应优惠额的购机现金券密码至参与活动的手机号（温馨提示：记得提前绑定沃江苏的手机号哦）；</i>\n           </p>\n           <p class=\"detail_ggxx_list_word\">\n               <span class=\"detail_ggxx_xmfh\">3、</span>\n               <i class=\"detail_ggxx_xmnr\">领到购机现金券后可查看“用券宝典”，点击“立即购买”进入专属购机页面，即可以特权价购买iPhone 6s。</i>\n           </p>\n           <p class=\"detail_ggxx_jsq\">友情提醒：购机现金券仅限新入网用户在2015年12月12-24日使用。</p>', '活动说明', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:02:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea01521556cecb0005', 'index.img.shareShade', 'fxpyq_img.png', '分享到朋友圈的遮罩图片', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:09:16', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215580d100006', 'index.img.erweima', 'erwm_img.jpg', '关注二维码图片', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:10:38', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215590cdf0007', 'index.tip.noFocus', '参与活动要先关注微信公众号“xxx”哦~', '未关注的提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:11:43', null, '2016-01-06 17:40:54');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152155a17de0008', 'index.tip.noProduct', '活动太火爆，商品已被抢光<br />后台紧急补货中，大侠请稍后再来~', '商品数量为0', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:12:51', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152155b73660009', 'index.tip.shareFriendCircle', '斧头帮拉你入伙，一起来砍，3039元砍出iPhone 6s！', '分享到朋友圈的文字', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:14:20', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152155cca8f000a', 'index.tip.shareFriendDesc', '兄弟，帮我砍上一斧如何？iPhone 6S靠你了！', '分享给好友的文字', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:15:48', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152155d4c08000b', 'index.tip.shareFriendTile', '斧头帮', '分享给好友的标题', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:16:21', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152155fb55d000c', 'index.img.share', '分享小图片', 'http://h5.jeewx.com/content/commonftb/default/img/fxxtp_img.jpg', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:18:59', null, '2016-01-06 14:35:38');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215608346000d', 'information.tip.cutMinPrice', '大侠，已经砍到底价啦！<br />快去领购机现金券吧！', '已经看到低价提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:19:52', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215613c82000e', 'information.tip.noCutMinPrice', '尚未砍到底价，大侠仍需努<br />继续发动小伙伴们帮忙吧！', '没有砍到低价提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:20:40', null, '2016-01-06 16:10:01');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea01521561d524000f', 'information.tip.noBindPhone', '请在“xxx”公众号<br />回复手机号码进行绑定<br />才能参与活动哦！', '未绑定手机提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:21:19', null, '2016-01-06 17:40:35');
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215631cc80010', 'controller.shortMessage', '恭喜您获得%s元现金券，密码为%s，专享%s砍价活动优惠，过期作废，此券仅限使用一次，可自己使用或转赠他人。', '发送短信的文案', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:22:43', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152156416e80011', 'bhykj.tip.nextbargain', '板斧已坏<br />大侠休息吧！', '再次为好友砍价提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:23:47', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215647d5f0012', 'bhykj.tip.lastbargain', '神功已成<br />小心走火入魔', '已经砍到低价提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:24:13', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea015215651ac20013', 'detail.img', 'hdsm_tab.png', '活动说明的图片', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:24:53', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152156aef3a0014', 'controller.couponExpire', '现金券兑换已过截止日期', '现金券兑换已过截止日期提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:31:15', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee52154bea0152156bd6590015', 'controller.noCoupon', '大侠，您来晚了，券已领完', '券已领完提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 13:32:14', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee5215ed0a015215ed0a020000', 'controller.alreadyRecieveAwards', '您已经领取了奖品，不能参与砍价活动', '如果活动设置了中奖不可继续参与，对应的已经中过奖的提示语', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 15:53:22', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee5215ed0a015216077dcb0001', 'statistics', 'var a;', '统计脚本', '402880ee513747290151378f1b5a521', null, null, '2016-01-06 16:22:15', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('402880ee522086ba01522086ba9e0000', 'home.linkBtnName', '活动链接', '连接按钮名称', '402880ee513747290151378f1b5a521', null, null, '2016-01-08 17:17:26', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b090012', 'index.title', '全民砍价', '首页标题', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-25 10:15:12');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b0b0013', 'index.img.banner', 'banner1.jpg?v=1.0.1', '首页banner', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-01 19:45:36');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b0d0014', 'index.actDetail', '<dl class=\"hdxq_conter_nr\">\n	          <dd class=\"hdxq_wz\"> \n	              <span><b>如此高端的活动只给铁杆粉</b>：参与本活动前需关注“H5活动汇”公众号。</span> \n	              <span><b>我们拼的是手快和人气</b>最先砍到底价的前20名用户可以底价买到iPhone6s一部。</span> \n	              <span>来，po几张iPhone6s的美图</span>\n	            <div class=\"cp_img1_form\"><img src=\"http://img30.360buyimg.com/jgsq-productsoa/jfs/t1990/14/391467317/381809/6e9933ae/5603d37eN4701ca83.jpg\" /></div>\n	            	          </dd>\n	        </dl>\n	        <dl class=\"hdjs_conter_nr\">\n	          <dd class=\"hdjs_conter_nr_wz_list\"> \n	          	<span>活动时间</span>\n	          	<span> 2016年1月1日 00:00 — 2月 28日 00:00</span> \n	          </dd>\n	          <dd class=\"hdjs_conter_nr_wz_list\">\n	         		<span>活动玩法</span>\n	          		 <span> 商品的初始价格为5788元。每个用户可随机帮别人砍掉10-20元的价格。</span> \n	          </dd>\n	          <dl class=\"hdjs_conter_nr_wz_list\">\n	          	<span>奖励</span>\n	            <span> 活动期间最先砍到底价的前20名用户可以底价买到iPhone6s一部；</span>\n	          </dl>\n	          <dd class=\"hdjs_conter_nr_wz_list\">\n				  <span>特别提醒</span>\n		          <span>1. 必须通过关注“H5活动汇”才能参加该活动；</span> \n		          <span>2. 活动期间每个微信ID仅能为另一个微信ID砍价一次；</span> \n		          <span>3. 作弊刷票者将被取消活动资格。</span>\n		          <span><br>本活动为捷微测试活动，欢迎体验。最终解释权归捷微团队。</span>\n	          </dd>\n	        </dl>', '活动规则、详情，介绍等', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-10 14:41:48');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b110015', 'index.recevieTip', '恭喜您获得华为iPhone6s手机一部！请填写真实的姓名、手机号和收货详细地址，工作人员会尽快为您发货。', '中奖提示语，显示于页面上部和兑奖信息上方。', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-25 18:34:23');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b120016', 'fxindex.title', '砍啊', '帮砍页面标题', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b130017', 'index.recevieSuccessTip', '您已成功领取奖品！', '填写兑奖信息成功的提示语', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b130018', 'index.tip.shareFriendCircle', '2016年，兄弟们帮我砍价吧。', '【分享】分享到朋友圈的内容', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-07 21:20:03');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b140019', 'index.img.share', 'http://www.h5huodong.com/content/gzbargain/co/img/banner1.jpg', '【分享】分享图标', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-04 18:50:56');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b17001a', 'index.tip.shareFriendTitle', '全民砍价', '【分享】发送给好友的标题', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-30 11:58:11');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b18001b', 'index.tip.shareFriend', '兄弟姐妹们帮我砍价吧。', '【分享】发送给好友的内容', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-30 11:57:32');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b19001c', 'fxindex.recevieTip', '已成功领取奖品。点击“我要参加”，等你来领奖。', '分享页好友已领奖内容（显示于页面上部）', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-25 18:33:41');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b19001d', 'fxindex.tip.bargained', '您已经帮好友砍过价了，不能重复砍价！', '已砍过价提示语', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1a001e', 'index.notCutMin', '您尚未砍到底价，请继续努力！', '未砍至底价领奖提示', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1b001f', 'index.noRecevied', '奖品已抢光，请关注后续活动。', '未领取到奖品', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1c0020', 'fxindex.tip.received', '用户已领奖，请勿砍价。', '帮砍时已领奖', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1c0021', 'fxindex.tip.cutMin', '已砍至底价，请勿再砍。', '帮砍时已砍至底价，无需再砍。', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1d0022', 'index.style.bgcolor', '#8F0802', '页面背景颜色', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-01 19:48:02');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1e0023', 'statistics', 'var _hmt = _hmt || [];\n(function() {\n  var hm = document.createElement(\"script\");\n  hm.src = \"//hm.baidu.com/hm.js?8e37bf5be2b9827bc5af38b321f6bb38\";\n  var s = document.getElementsByTagName(\"script\")[0]; \n  s.parentNode.insertBefore(hm, s);\n})();', '统计代码', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, null);
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b1f0024', 'index.tip.qrcode', '关注微信公众号后才能参与活动<br>长按识别二维码关注', '关注二维码提示语', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2015-12-27 15:54:00');
INSERT INTO `jw_system_act_txt` VALUES ('ff808081520ad05601520c4c9b200025', 'index.img.qrcode', 'qrcode-h5.png', '二维码图片', 'ff808081520ad05601520c4c9acc0011', null, null, '2016-01-04 19:01:33', null, '2016-01-10 15:17:04');

-- ----------------------------
-- Table structure for `jw_system_auth`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_auth`;
CREATE TABLE `jw_system_auth` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `auth_id` varchar(32) NOT NULL default '' COMMENT '权限编码',
  `auth_name` varchar(100) default NULL COMMENT '权限名称',
  `is_logs` char(2) default NULL COMMENT '是否记录日志 0不记录 1记录',
  `auth_type` varchar(2) default NULL COMMENT '权限类型 0:菜单;1:功能',
  `auth_desc` varchar(120) default NULL COMMENT '权限说明',
  `auth_contr` varchar(256) default NULL COMMENT '权限控制',
  `parent_auth_id` char(12) default NULL COMMENT '上一级权限编码',
  `sort_no` int(11) default NULL COMMENT '排序',
  `biz_level` char(2) default NULL COMMENT '层级',
  `leaf_ind` char(2) default NULL COMMENT '是否叶子节点',
  `del_stat` char(2) NOT NULL default '0' COMMENT '删除标志 0未删除 1已删除',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_authid` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营系统权限表';

-- ----------------------------
-- Records of jw_system_auth
-- ----------------------------
INSERT INTO `jw_system_auth` VALUES ('1', '21', '系统管理', null, '0', null, null, null, '900', '1', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('2', '2101', '用户管理', null, '0', null, '/system/back/jwSystemUser/list.do', '21', '1', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('3', '210101', '新增用户', null, '1', '新增用户', '/system/back/jwSystemUser/doAdd.do', '2101', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('4', '210102', '编辑用户', null, '1', '编辑用户', '/system/back/jwSystemUser/doEdit.do', '2101', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('5', '2102', '角色管理', null, '0', null, '/system/back/jwSystemRole/list.do', '21', '2', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('6', '210201', '新增角色', '', '1', '新增角色', '/system/back/jwSystemRole/doAdd.do', '2102', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('7', '210202', '编辑角色', '', '1', '编辑角色', '/system/back/jwSystemRole/doEdit.do', '2102', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('8', '210203', '角色授权', null, '1', '角色授权', '/system/back/jwSystemRole/editRoleAuth.do', '2102', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('9', '210204', '删除角色', '', '1', '删除角色', '/system/back/jwSystemRole/doDelete.do', '2102', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('10', '2103', '权限管理', null, '0', null, '/system/back/jwSystemAuth/list.do', '21', '3', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('11', '210301', '新增权限', null, '1', '新增权限', '/system/back/jwSystemAuth/doAdd.do', '2103', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('12', '210302', '编辑权限', null, '1', '编辑权限', '/system/back/jwSystemAuth/doEdit.do', '2103', null, null, null, '0');
INSERT INTO `jw_system_auth` VALUES ('31', '2104', '项目管理', '', '0', '', '/system/back/jwSystemProject/list.do', '21', '4', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('32', '2105', '公众号管理', '', '0', '', '/system/back/jwWebJwid/list.do', '21', '5', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('33', '27', '摇一摇活动管理', '', '0', '', '', '', '5', '1', '', '0');
INSERT INTO `jw_system_auth` VALUES ('34', '2701', '活动配置', '', '0', '摇一摇活动', '/shaketicket/back/wxActShaketicketHome/list.do', '27', '1', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('35', '2702', '奖品配置', '', '0', '奖品配置', '/shaketicket/back/wxActShaketicketAward/list.do', '27', '2', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('36', '28', '斧头帮活动', '', '0', '', '', '', '5', '1', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('37', '2801', '主活动', '', '0', '主活动', '/commonftb/back/wxActCommonftbMain/list.do', '28', '1', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('38', '2802', '子活动', '', '0', '子活动', '/commonftb/back/wxActCommonftb/list.do', '28', '2', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('39', '26', '九宫格活动管理', '', '0', '', '', '', '4', '1', '', '0');
INSERT INTO `jw_system_auth` VALUES ('40', '2601', '九宫格活动', '', '0', '九宫格活动', '/jiugongge/back/wxActJiugongge/list.do', '26', '1', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('41', '2602', '奖项配置', '', '0', '奖项配置', '/jiugongge/back/wxActJiugonggeAwards/list.do', '26', '2', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('42', '2603', '奖品配置', '', '0', '奖品配置', '/jiugongge/back/wxActJiugonggePrizes/list.do', '26', '3', '2', 'Y', '0');
INSERT INTO `jw_system_auth` VALUES ('43', '29', '砍价活动管理', null, '0', '', '', '', '7', '1', 'N', '0');
INSERT INTO `jw_system_auth` VALUES ('44', '2901', '活动配置', null, '0', '活动配置', '/gzbargain/back/gzWxActBargain/list.do', '29', '1', '2', 'Y', '0');

-- ----------------------------
-- Table structure for `jw_system_auth_mutex`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_auth_mutex`;
CREATE TABLE `jw_system_auth_mutex` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `auth_id` varchar(32) NOT NULL COMMENT '权限编码',
  `mutex_auth_id` varchar(32) NOT NULL COMMENT '互斥权限编码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限互斥表';

-- ----------------------------
-- Records of jw_system_auth_mutex
-- ----------------------------

-- ----------------------------
-- Table structure for `jw_system_logo_title`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_logo_title`;
CREATE TABLE `jw_system_logo_title` (
  `id` varchar(32) NOT NULL,
  `logo` varchar(100) default NULL COMMENT '系统的logo',
  `title1` varchar(100) default NULL COMMENT '系统名称',
  `title2` varchar(100) default NULL COMMENT '系统名称',
  `title3` varchar(100) default NULL COMMENT '系统名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统logo和title设置表';

-- ----------------------------
-- Records of jw_system_logo_title
-- ----------------------------
INSERT INTO `jw_system_logo_title` VALUES ('1', '捷微H5活动营销平台', '捷微H5活动营销平台', '', null);

-- ----------------------------
-- Table structure for `jw_system_project`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_project`;
CREATE TABLE `jw_system_project` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `code` varchar(100) NOT NULL COMMENT '项目编码',
  `name` varchar(100) NOT NULL COMMENT '项目名称',
  `img` varchar(255) default NULL COMMENT '项目图片',
  `discribe` varchar(300) default NULL COMMENT '活动描述',
  `hdurl` varchar(200) default NULL COMMENT '入口地址',
  `application_type` varchar(10) default NULL COMMENT '应用类型',
  `creat_name` varchar(50) default NULL COMMENT '创建人',
  `creat_time` datetime default NULL COMMENT '创建时间',
  `update_name` varchar(50) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动项目管理表';

-- ----------------------------
-- Records of jw_system_project
-- ----------------------------
INSERT INTO `jw_system_project` VALUES ('402880ee51c40a030151c40a037f0000', 'jiugongge', '九宫格', 'jiugongge.jpg', '九宫格抽奖', 'http://www.jeewx.com/jeewx/weixinLinksucaiController.do?link&id=8a792db35148806801514881188a0001', '', null, '2015-12-21 18:16:09', null, null);
INSERT INTO `jw_system_project` VALUES ('402880ee51d7fd1f0151d80cd8610012', 'shaketicket', '摇一摇通用版', 'shaketicket.jpg', '摇一摇通用版', 'http://www.jeewx.com/jeewx/weixinLinksucaiController.do?link&id=ff80808151d26aca0151d80bfebc044f', '', null, '2015-12-25 15:31:39', null, null);
INSERT INTO `jw_system_project` VALUES ('402880ee52108c3a0152108c3a450000', 'commonftb', '斧头帮通用版', 'commonftb.jpg', '斧头帮通用版', 'http://www.jeewx.com/jeewx/weixinLinksucaiController.do?link&id=ff80808152107b460152108e9e630036', '', null, '2016-01-05 14:49:31', null, null);
INSERT INTO `jw_system_project` VALUES ('ff80808151cdf6f70151ce1902f20008', 'gzbargain', '砍价', 'gzbargain.jpg', '砍价，单商品', 'http://www.jeewx.com/jeewx/weixinLinksucaiController.do?link&id=ff808081520c192c01520c31b0af001b', '', null, '2015-12-23 01:08:44', null, null);

-- ----------------------------
-- Table structure for `jw_system_role`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_role`;
CREATE TABLE `jw_system_role` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `role_id` varchar(32) NOT NULL default '' COMMENT '角色编码',
  `role_name` varchar(100) default NULL COMMENT '角色名称',
  `crt_operator` varchar(64) default NULL COMMENT '创建人',
  `crt_dt` datetime default NULL COMMENT '创建日期',
  `role_typ` char(4) default NULL COMMENT '角色种类',
  `del_stat` char(2) default NULL COMMENT '删除标志',
  `creator` varchar(64) default NULL COMMENT '建立者',
  `editor` varchar(64) default NULL COMMENT '编辑者',
  `create_dt` timestamp NULL default NULL COMMENT '建立日期',
  `edit_dt` timestamp NULL default NULL COMMENT '编辑日期',
  `last_edit_dt` timestamp NULL default NULL COMMENT '上次修改日期',
  `record_version` char(8) default NULL COMMENT '版本号',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_roleid` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营角色表';

-- ----------------------------
-- Records of jw_system_role
-- ----------------------------
INSERT INTO `jw_system_role` VALUES ('1', '00', '系统管理员', 'admin', null, null, '0', 'admin', null, '2015-12-22 10:34:05', '2015-12-22 10:34:05', '2015-12-22 10:34:05', null);
INSERT INTO `jw_system_role` VALUES ('2', '01', '默认角色', 'admin', null, null, '0', 'admin', null, '2015-12-25 14:13:58', null, null, null);

-- ----------------------------
-- Table structure for `jw_system_role_auth_rel`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_role_auth_rel`;
CREATE TABLE `jw_system_role_auth_rel` (
  `role_id` varchar(32) NOT NULL default '' COMMENT '角色编码',
  `auth_id` varchar(32) NOT NULL default '' COMMENT '权限编码',
  PRIMARY KEY  (`role_id`,`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营角色与权限表';

-- ----------------------------
-- Records of jw_system_role_auth_rel
-- ----------------------------
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '21');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2101');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210101');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210102');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2102');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210201');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210202');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210203');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210204');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2103');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210301');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '210302');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2104');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2105');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '26');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2601');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2602');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2603');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '27');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2701');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2702');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '28');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2801');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2802');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '29');
INSERT INTO `jw_system_role_auth_rel` VALUES ('00', '2901');

-- ----------------------------
-- Table structure for `jw_system_user`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_user`;
CREATE TABLE `jw_system_user` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `user_id` varchar(32) default '' COMMENT '用户编码',
  `user_name` varchar(32) default NULL COMMENT '用户名称',
  `password` varchar(64) default NULL COMMENT '密码',
  `user_erp_no` varchar(64) default NULL COMMENT '用户ERP号',
  `user_typ` char(2) default NULL COMMENT '用户种类',
  `ope_dep_id` char(12) default NULL COMMENT '部门编码',
  `ope_phone_num` varchar(20) default NULL COMMENT '手机电话',
  `email` varchar(64) default NULL COMMENT '注册邮箱',
  `ope_email_authinfo` varchar(32) default NULL COMMENT '邮箱认证信息',
  `user_icon` varchar(32) default NULL COMMENT '用户头像',
  `ope_mobile_auth_ind` char(2) default NULL COMMENT '手机是否认证',
  `ope_email_auth_ind` char(2) default NULL COMMENT '邮箱是否认证',
  `id_num` char(20) default NULL COMMENT '证件号码',
  `id_typ` char(2) default NULL COMMENT '证件种类',
  `state` char(2) default NULL COMMENT '状态',
  `user_stat` varchar(20) default NULL COMMENT '用户状态 NORMAL:正常；INVALID：无效',
  `last_logn_dttm` datetime default NULL COMMENT '上次登录日期',
  `last_logn_ip` char(15) default NULL COMMENT '上次登录IP',
  `ope_passwd_ind` char(2) default NULL COMMENT '是否保持密码',
  `del_stat` char(2) default NULL COMMENT '删除标志',
  `creator` varchar(64) default NULL COMMENT '建立者',
  `editor` varchar(64) default NULL COMMENT '编辑者',
  `create_dt` timestamp NULL default NULL COMMENT '建立日期',
  `edit_dt` timestamp NULL default NULL COMMENT '编辑日期',
  `last_edit_dt` timestamp NULL default NULL COMMENT '上次修改日期',
  `record_version` char(8) default NULL COMMENT '版本号',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营用户表';

-- ----------------------------
-- Records of jw_system_user
-- ----------------------------
INSERT INTO `jw_system_user` VALUES ('1', 'admin', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, null, null, null, null, null, null, null, 'NORMAL', null, null, null, null, null, null, '2015-12-22 14:16:10', null, null, null);

-- ----------------------------
-- Table structure for `jw_system_user_jwid`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_user_jwid`;
CREATE TABLE `jw_system_user_jwid` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '用户编码',
  `jwid` varchar(64) NOT NULL COMMENT '公众号',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq` (`user_id`,`jwid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信公众号字典表';

-- ----------------------------
-- Records of jw_system_user_jwid
-- ----------------------------
INSERT INTO `jw_system_user_jwid` VALUES ('1f245f942ff31034b83216100b0702f7', 'admin', 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `jw_system_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `jw_system_user_role_rel`;
CREATE TABLE `jw_system_user_role_rel` (
  `user_id` varchar(32) NOT NULL default '' COMMENT '用户id',
  `role_id` varchar(32) NOT NULL default '' COMMENT '角色id',
  PRIMARY KEY  (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营用户与角色';

-- ----------------------------
-- Records of jw_system_user_role_rel
-- ----------------------------
INSERT INTO `jw_system_user_role_rel` VALUES ('admin', '00');

-- ----------------------------
-- Table structure for `jw_web_jwid`
-- ----------------------------
DROP TABLE IF EXISTS `jw_web_jwid`;
CREATE TABLE `jw_web_jwid` (
  `id` varchar(32) NOT NULL,
  `jwid` varchar(64) NOT NULL COMMENT '公众号',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `application_type` varchar(10) default NULL COMMENT '应用类型',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_jwid` (`jwid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信公众号字典表';

-- ----------------------------
-- Records of jw_web_jwid
-- ----------------------------
INSERT INTO `jw_web_jwid` VALUES ('ff80808151f1628c0151f16470cb0006', 'gh_f268aa85d1c7', 'H5活动汇', null);

-- ----------------------------
-- Table structure for `wx_act_bargain`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_bargain`;
CREATE TABLE `wx_act_bargain` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `act_name` varchar(100) NOT NULL COMMENT '砍价活动名称',
  `act_detail` varchar(500) default NULL COMMENT '活动描述',
  `act_rule` varchar(1000) default NULL COMMENT '活动规则',
  `begain_time` datetime default NULL COMMENT '活动开始时间',
  `end_time` datetime NOT NULL COMMENT ' 活动结束时间',
  `product_num` int(11) NOT NULL COMMENT '产品数量',
  `product_unit` varchar(10) NOT NULL COMMENT '产品单位',
  `product_name` varchar(255) NOT NULL COMMENT '产品名称',
  `product_price` decimal(11,2) NOT NULL COMMENT '产品价格',
  `product_img` varchar(255) default NULL COMMENT '产品图片',
  `foucs_user_can_join` varchar(1) default NULL COMMENT '是否关注用户参与',
  `show_rate` int(11) NOT NULL COMMENT '展示比例',
  `create_time` datetime default NULL COMMENT '创建时间',
  `product_remain_num` int(11) NOT NULL COMMENT '产品剩余数量',
  `cut_min_price` decimal(11,2) default NULL COMMENT '砍价最低金额',
  `template` varchar(32) default NULL COMMENT '模版简称',
  `hdurl` varchar(255) default NULL COMMENT '入口地址',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  `project_code` varchar(32) default NULL COMMENT '活动编码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='砍价活动表';

-- ----------------------------
-- Records of wx_act_bargain
-- ----------------------------
INSERT INTO `wx_act_bargain` VALUES ('ff808081520ad05601520c4c9acc0011', '新年砍价活动', '1', '10,20,0', '2016-01-01 19:00:50', '2016-02-28 19:00:53', '20', '部', 'iphone6s', '2999.00', '1', '0', '1', null, '20', '1999.00', 'co', 'http://wx.jeecg.com/jeewx/weixinLinksucaiController.do?link&id=ff808081520c192c01520c31b0af001b&actId=ff808081520ad05601520c4c9acc0011&jwid=gh_f268aa85d1c7', 'gh_f268aa85d1c7', 'gzbargain');

-- ----------------------------
-- Table structure for `wx_act_bargain_awards`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_bargain_awards`;
CREATE TABLE `wx_act_bargain_awards` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) NOT NULL COMMENT '活动id',
  `awards_seq` int(11) NOT NULL COMMENT '奖品序号',
  `openid` varchar(100) NOT NULL COMMENT '兑奖人openid',
  `nickname` varchar(200) default NULL COMMENT '兑奖人昵称',
  `real_name` varchar(100) default NULL COMMENT '真实姓名',
  `mobile` varchar(50) default NULL COMMENT '手机号',
  `address` varchar(200) default NULL COMMENT '详细地址',
  `awards_code` varchar(64) NOT NULL COMMENT '兑奖码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_awardsseq` USING BTREE (`act_id`,`awards_seq`),
  UNIQUE KEY `uniq_actid_openid` (`act_id`,`openid`),
  KEY `idx_openid` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领取奖品记录表';

-- ----------------------------
-- Records of wx_act_bargain_awards
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_bargain_record`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_bargain_record`;
CREATE TABLE `wx_act_bargain_record` (
  `id` varchar(32) NOT NULL COMMENT '记录id',
  `registration_id` varchar(32) NOT NULL COMMENT '报名id',
  `openid` varchar(100) NOT NULL COMMENT '砍价人openid',
  `nickname` varchar(200) NOT NULL COMMENT '砍价人昵称',
  `cut_price` decimal(11,2) NOT NULL COMMENT '砍掉价格',
  `curr_price` decimal(11,2) NOT NULL COMMENT '砍后价格',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_registrationid_openid` USING BTREE (`registration_id`,`openid`),
  KEY `idx_registrationid` (`registration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='砍价帮砍记录表';

-- ----------------------------
-- Records of wx_act_bargain_record
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_bargain_registration`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_bargain_registration`;
CREATE TABLE `wx_act_bargain_registration` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) NOT NULL COMMENT '活动id',
  `openid` varchar(100) NOT NULL COMMENT '活动参与人openid',
  `nickname` varchar(200) NOT NULL COMMENT '活动参与人昵称',
  `head` varchar(200) default NULL COMMENT '活动参与人头像',
  `product_name` varchar(255) NOT NULL COMMENT '产品名称',
  `product_price` decimal(11,2) NOT NULL COMMENT '产品价格',
  `product_new_price` decimal(11,2) NOT NULL COMMENT '砍后价格',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  `awards_status` varchar(2) default '0' COMMENT '领奖状态0:未领奖;1:已领奖',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_openid` USING BTREE (`act_id`,`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='砍价报名表';

-- ----------------------------
-- Records of wx_act_bargain_registration
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_commonftb`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb`;
CREATE TABLE `wx_act_commonftb` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '子活动名称',
  `binner` varchar(100) default NULL COMMENT '子活动标题图片',
  `confirm` varchar(30) default NULL COMMENT '子活动确认选择提示语',
  `foucs_user_can_join` varchar(1) default '0' COMMENT '是否关注用户参与 0否1是',
  `binding_mobile_can_join` varchar(1) default '0' COMMENT '是否绑定手机可领奖 0否1是',
  `act_rule` varchar(1000) NOT NULL COMMENT '子活动规则',
  `begain_time` datetime NOT NULL COMMENT '子活动开始时间',
  `end_time` datetime NOT NULL COMMENT '子 活动结束时间',
  `product_num` int(11) NOT NULL COMMENT '产品数量',
  `product_unit` varchar(10) default NULL COMMENT '产品单位',
  `product_name` varchar(255) NOT NULL COMMENT '产品名称',
  `product_price` decimal(11,2) NOT NULL COMMENT '产品价格',
  `product_img` varchar(255) default NULL COMMENT '产品图片',
  `product_remain_num` int(11) NOT NULL COMMENT '产品剩余数量',
  `awards_end_time` datetime default NULL COMMENT '兑奖截止日期',
  `coupon_start_time` datetime default NULL COMMENT '券开始时间',
  `coupon_end_time` datetime default NULL COMMENT '券结束时间',
  `cut_min_price` decimal(11,2) default NULL COMMENT '砍价最低金额',
  `if_cut_min` varchar(1) default '0' COMMENT '是否砍到最底价',
  `coupon_level` varchar(64) default NULL COMMENT '卡券档位',
  `round_type` varchar(2) default '0' COMMENT '取整方式（0向下取整1向上取整）',
  `update_time` datetime default NULL COMMENT '更新时间',
  `jwid` varchar(64) NOT NULL COMMENT '微信平台原始id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='砍价子活动表';

-- ----------------------------
-- Records of wx_act_commonftb
-- ----------------------------
INSERT INTO `wx_act_commonftb` VALUES ('402880ee00151283904171', '斧头帮·香主', 'cp_title1.png', '初出茅庐闯天下，这个香主我要定了！', '1', '1', '4,8,0', '2016-01-16 11:36:31', '2016-06-06 23:59:59', '100', '台', 'iPhone6s<span class=\'ftb_cp_yj\'>（16G）</span>', '5299.00', 'cp_img3g_96.png', '92', '2016-02-06 23:59:59', '2015-11-30 23:59:59', '2016-02-06 23:59:59', '4639.00', '0', '660', '0', '2016-01-07 12:22:59', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb` VALUES ('402880ee00151283904172', '斧头帮·堂主', 'cp_title2.png', '一把板斧走江湖，堂主非我莫属！', '0', '0', '8,12,0', '2016-01-16 11:36:31', '2016-06-06 23:59:59', '100', '台', 'iPhone6s(16G)', '5299.00', 'cp_img1g.png', '100', '2016-02-06 23:59:59', '2015-11-30 23:59:59', '2016-02-06 23:59:59', '4239.00', '0', '1060', '0', null, 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb` VALUES ('402880eea0151283904173', '斧头帮·长老', 'cp_title3.png', '风雨江湖任我行，斧头长老霸气临！', '0', '0', '12,18,0', '2016-01-16 11:36:31', '2016-06-06 23:59:59', '100', '台', 'iPhone6s(16G)', '5299.00', 'cp_img3g_109.png', '100', '2016-02-06 23:59:59', '2015-11-30 23:59:59', '2016-02-06 23:59:59', '3639.00', '0', '1660', '0', null, 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb` VALUES ('402880eeca015128390412', '斧头帮·帮主', 'cp_title4.png', '兄弟齐心砍出道，帮主之名震天下！', '0', '0', '18,24,0', '2016-01-16 11:36:31', '2016-06-06 23:59:59', '100', '台', 'iPhone6s(16G)', '5299.00', 'cp_img4g.png', '100', '2016-02-06 23:59:59', '2015-11-30 23:59:59', '2016-02-06 23:59:59', '3039.00', '0', '2260', '0', '2016-01-05 15:30:48', 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `wx_act_commonftb_awards`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_awards`;
CREATE TABLE `wx_act_commonftb_awards` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) NOT NULL COMMENT '活动id',
  `awards_seq` int(11) NOT NULL COMMENT '奖品序号',
  `openid` varchar(100) NOT NULL COMMENT '兑奖人openid',
  `nickname` varchar(200) default NULL COMMENT '兑奖人昵称',
  `real_name` varchar(100) default NULL COMMENT '真实姓名',
  `mobile` varchar(50) default NULL COMMENT '手机号',
  `address` varchar(200) default NULL COMMENT '详细地址',
  `coupon_id` varchar(64) default NULL COMMENT '卡券id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_awardsseq` (`act_id`,`awards_seq`),
  UNIQUE KEY `uniq_actid_openid` (`act_id`,`openid`),
  UNIQUE KEY `uniq_couponid` (`coupon_id`),
  KEY `idx_openid` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领取奖品记录表';

-- ----------------------------
-- Records of wx_act_commonftb_awards
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_commonftb_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_coupon`;
CREATE TABLE `wx_act_commonftb_coupon` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) default NULL COMMENT '活动id(子活动)',
  `card_id` varchar(64) NOT NULL COMMENT '卡券ID',
  `card_psd` varchar(64) NOT NULL COMMENT '卡券密码',
  `card_type` varchar(255) default NULL COMMENT '卡券类型 CASH：代金券类型',
  `brand_name` varchar(36) default NULL COMMENT '商户名字',
  `title` varchar(27) default NULL COMMENT '卡券名',
  `least_cost` decimal(11,2) default NULL COMMENT '代金券专用，表示起用金额（单位为元）',
  `reduce_cost` decimal(11,2) default NULL COMMENT '代金券专用，表示减免金额。（单位为元）',
  `status` varchar(2) default '0' COMMENT '状态（0:未领取，1:已领取）',
  `jwid` varchar(64) default NULL COMMENT '微信原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_cardid` (`card_id`,`act_id`),
  KEY `idx_actid` (`act_id`),
  KEY `idx_cardid` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卡券配置表';

-- ----------------------------
-- Records of wx_act_commonftb_coupon
-- ----------------------------
INSERT INTO `wx_act_commonftb_coupon` VALUES ('1', '402880ee00151283904171', '1088100600112000', '1073752317429716331', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('10', '402880ee00151283904171', '1088100656100009', '1362055373421666503', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('100', '402880ee00151283904171', '1088100660100099', '1066066499103328391', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('101', '402880ee00151283904171', '1088100660100100', '1476970276118746525', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('102', '402880ee00151283904171', '1088100610100101', '2364377753485278823', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('103', '402880ee00151283904171', '1088100660100102', '6053541931138472440', 'CASH', 'H5活动汇', '', '0.00', '660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('105', '402880ee00151283904172', '1088100660100104', '1267870752169883302', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('106', '402880ee00151283904172', '1088100630100105', '3604967472182449766', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('107', '402880ee00151283904172', '1088100660100106', '1504296811107069015', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('108', '402880ee00151283904172', '1088100660100107', '5154896358673355458', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('11', '402880ee00151283904172', '1088100660100010', '8262773634346760277', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('110', '402880ee00151283904172', '1088100660100109', '7686020119126570399', 'CASH', 'H5活动汇', '', '0.00', '1060.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('111', '402880eea0151283904173', '1088100660100110', '4323641713139569171', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('112', '402880eea0151283904173', '1088100660100111', '5550342322305958743', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('113', '402880eea0151283904173', '1088100660100112', '1198113362612441601', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('114', '402880eea0151283904173', '1088100620100113', '1727891876103277776', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('115', '402880eea0151283904173', '1088100660100114', '4283614810359914512', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('116', '402880eea0151283904173', '1088100612100115', '5078744793137186983', 'CASH', 'H5活动汇', '', '0.00', '1660.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('118', '402880eeca015128390412', '1088100660100117', '5903329071158719692', 'CASH', 'H5活动汇', '', '0.00', '2260.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('119', '402880eeca015128390412', '1088100660100118', '1810142104671306216', 'CASH', 'H5活动汇', '', '0.00', '2260.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('12', '402880eeca015128390412', '1088100660100011', '1189949538190820628', 'CASH', 'H5活动汇', '', '0.00', '2260.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('120', '402880eeca015128390412', '1088100660100119', '1954572832150385419', 'CASH', 'H5活动汇', '', '0.00', '2260.00', '0', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_commonftb_coupon` VALUES ('121', '402880eeca015128390412', '1088100661200120', '1638457123922647047', 'CASH', 'H5活动汇', '', '0.00', '2260.00', '0', 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `wx_act_commonftb_main`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_main`;
CREATE TABLE `wx_act_commonftb_main` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `act_name` varchar(100) NOT NULL COMMENT '砍价活动名称',
  `begain_time` datetime default NULL COMMENT '活动开始时间',
  `end_time` datetime default NULL COMMENT ' 活动结束时间',
  `many_can_join` varchar(1) default '0' COMMENT '是否只能参加一个子活动 0否1是',
  `hdurl` varchar(255) default NULL COMMENT '入口地址',
  `template` varchar(10) default NULL COMMENT '模版(省份简称)',
  `jwid` varchar(64) NOT NULL COMMENT '微信公众号',
  `project_code` varchar(32) default NULL COMMENT '所属项目编码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主活动表';

-- ----------------------------
-- Records of wx_act_commonftb_main
-- ----------------------------
INSERT INTO `wx_act_commonftb_main` VALUES ('402880ee513747290151378f1b5a521', '斧头帮', '2016-01-16 12:40:48', '2016-06-06 17:40:52', '1', 'http://wx.jeecg.com/jeewx/weixinLinksucaiController.do?link&id=ff80808152107b460152108e9e630036&mainActId=402880ee513747290151378f1b5a521&jwid=gh_f268aa85d1c7', '', 'gh_f268aa85d1c7', 'commonftb');

-- ----------------------------
-- Table structure for `wx_act_commonftb_record`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_record`;
CREATE TABLE `wx_act_commonftb_record` (
  `id` varchar(32) NOT NULL COMMENT '记录id',
  `registration_id` varchar(32) NOT NULL COMMENT '报名id',
  `openid` varchar(100) NOT NULL COMMENT '砍价人openid',
  `nickname` varchar(200) NOT NULL COMMENT '砍价人昵称',
  `cut_price` decimal(11,2) NOT NULL COMMENT '砍掉价格',
  `curr_price` decimal(11,2) NOT NULL COMMENT '砍后价格',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_registrationid_openid` (`registration_id`,`openid`),
  KEY `idx_registrationid` (`registration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帮砍记录表';

-- ----------------------------
-- Records of wx_act_commonftb_record
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_commonftb_registration`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_registration`;
CREATE TABLE `wx_act_commonftb_registration` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) NOT NULL COMMENT '活动id',
  `openid` varchar(100) NOT NULL COMMENT '活动所属人openid',
  `nickname` varchar(200) NOT NULL COMMENT '活动所属人昵称',
  `head` varchar(200) default NULL COMMENT '会员头像',
  `product_name` varchar(255) NOT NULL COMMENT '产品名称',
  `product_price` decimal(11,2) NOT NULL COMMENT '产品价格',
  `product_new_price` decimal(11,2) NOT NULL COMMENT '砍后价格',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  `awards_status` varchar(2) default '0' COMMENT '领奖状态0:未领奖;1:已领奖',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_openid` (`act_id`,`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='砍价报名表';

-- ----------------------------
-- Records of wx_act_commonftb_registration
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_commonftb_relation`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_commonftb_relation`;
CREATE TABLE `wx_act_commonftb_relation` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `main_act_id` varchar(32) NOT NULL COMMENT '主活动编码',
  `act_id` varchar(32) NOT NULL COMMENT '活动编码',
  `act_sort` int(11) default NULL COMMENT '活动排序',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  KEY `idx_mainactid` (`main_act_id`),
  KEY `idx_actid` (`act_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主活动明细活动配置';

-- ----------------------------
-- Records of wx_act_commonftb_relation
-- ----------------------------
INSERT INTO `wx_act_commonftb_relation` VALUES ('1', '402880ee513747290151378f1b5a521', '402880ee00151283904171', '1', '2015-11-30 17:48:19');
INSERT INTO `wx_act_commonftb_relation` VALUES ('2', '402880ee513747290151378f1b5a521', '402880ee00151283904172', '2', '2015-11-30 17:48:37');
INSERT INTO `wx_act_commonftb_relation` VALUES ('3', '402880ee513747290151378f1b5a521', '402880eea0151283904173', '3', '2015-11-30 17:48:47');
INSERT INTO `wx_act_commonftb_relation` VALUES ('4', '402880ee513747290151378f1b5a521', '402880eeca015128390412', '4', '2015-11-30 17:48:58');

-- ----------------------------
-- Table structure for `wx_act_jiugongge`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge`;
CREATE TABLE `wx_act_jiugongge` (
  `id` varchar(100) NOT NULL COMMENT '键主',
  `title` varchar(400) default NULL COMMENT '活动名称',
  `description` text COMMENT '活动描述',
  `starttime` datetime default NULL COMMENT '开始时间',
  `endtime` datetime default NULL COMMENT '结束时间',
  `banner` varchar(100) default NULL COMMENT '背景图',
  `count` int(10) default NULL COMMENT '抽奖次数',
  `hdurl` varchar(200) default NULL COMMENT '入口地址',
  `foucs_user_can_join` varchar(1) default '0' COMMENT '是否关注可参加',
  `binding_mobile_can_join` varchar(1) default '0' COMMENT '是否绑定手机可参加',
  `num_per_day` int(11) default '0' COMMENT '每日抽奖次数',
  `prize_status` varchar(1) default '0' COMMENT '是否中奖可参与 0：中奖可继续参与 1:中奖不可参与',
  `jwid` varchar(64) default NULL COMMENT '微信原始id',
  `project_code` varchar(32) default NULL COMMENT '活动编码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='九宫格活动表';

-- ----------------------------
-- Records of wx_act_jiugongge
-- ----------------------------
INSERT INTO `wx_act_jiugongge` VALUES ('402880ee5127c20a0151283904170012', '幸运九宫格', '九宫格活动', '2016-01-16 12:02:38', '2016-06-06 12:02:41', null, '25', 'http://wx.jeecg.com/jeewx/weixinLinksucaiController.do?link&id=8a792db35148806801514881188a0001&actId=402880ee5127c20a0151283904170012&jwid=gh_f268aa85d1c7', '1', '0', '0', '0', 'gh_f268aa85d1c7', null);

-- ----------------------------
-- Table structure for `wx_act_jiugongge_awards`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge_awards`;
CREATE TABLE `wx_act_jiugongge_awards` (
  `id` varchar(36) NOT NULL default '',
  `awards_name` varchar(200) default NULL COMMENT '奖项名称',
  `jwid` varchar(64) default NULL,
  `awards_value` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_awardsjwid` (`jwid`,`awards_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项表';

-- ----------------------------
-- Records of wx_act_jiugongge_awards
-- ----------------------------
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281efbd00006', '一等奖', 'gh_f268aa85d1c7', '1');
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281f395f0007', '二等奖', 'gh_f268aa85d1c7', '2');
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281f69740008', '三等奖', 'gh_f268aa85d1c7', '3');
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281f8d290009', '四等奖', 'gh_f268aa85d1c7', '4');
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281fc42d000a', '五等奖', 'gh_f268aa85d1c7', '5');
INSERT INTO `wx_act_jiugongge_awards` VALUES ('402880ee5127c20a0151281fe96b000b', '六等奖', 'gh_f268aa85d1c7', '6');

-- ----------------------------
-- Table structure for `wx_act_jiugongge_prizes`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge_prizes`;
CREATE TABLE `wx_act_jiugongge_prizes` (
  `id` varchar(36) NOT NULL default '',
  `name` varchar(200) default NULL COMMENT '奖品名称',
  `img` varchar(50) default NULL COMMENT '奖品图片',
  `jwid` varchar(64) default NULL COMMENT '微信原始id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖品表';

-- ----------------------------
-- Records of wx_act_jiugongge_prizes
-- ----------------------------
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a01512823001d000c', 'iphone6plus', 'sy2_03.jpg', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a01512823417c000d', 'iPhone6s', 'sy2_05.jpg', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a015128237268000e', '华为', 'sy2_09.jpg', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a01512823a265000f', '小米', 'sy2_10.jpg', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a01512824448a0010', '电影票', 'movie.jpg', 'gh_f268aa85d1c7');
INSERT INTO `wx_act_jiugongge_prizes` VALUES ('402880ee5127c20a01512824a8600011', 'U盘', 'up.jpg', 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `wx_act_jiugongge_record`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge_record`;
CREATE TABLE `wx_act_jiugongge_record` (
  `id` varchar(32) NOT NULL COMMENT '记录id',
  `act_id` varchar(32) default NULL,
  `openid` varchar(100) NOT NULL COMMENT 'openid',
  `nickname` varchar(200) NOT NULL COMMENT '昵称',
  `recieve_time` datetime NOT NULL COMMENT '中奖时间',
  `awards_id` varchar(36) default NULL COMMENT '奖项',
  `realname` varchar(30) default NULL COMMENT '收货人姓名',
  `phone` varchar(15) default NULL COMMENT '手机号',
  `address` varchar(15) default NULL COMMENT '地址',
  `seq` int(10) default NULL COMMENT '抽奖序号',
  `jwid` varchar(64) NOT NULL COMMENT '对应微信平台原始id',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_seq` (`act_id`,`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抽奖记录表';

-- ----------------------------
-- Records of wx_act_jiugongge_record
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_jiugongge_registration`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge_registration`;
CREATE TABLE `wx_act_jiugongge_registration` (
  `id` varchar(32) NOT NULL,
  `act_id` varchar(32) NOT NULL COMMENT '活动id',
  `openid` varchar(100) NOT NULL COMMENT '活动所属人openid',
  `nickname` varchar(200) NOT NULL COMMENT '活动所属人昵称',
  `awards_num` int(10) default '0' COMMENT '抽奖次数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '更新时间',
  `awards_status` varchar(2) default '0' COMMENT '抽奖状态0:未抽奖;1:已抽奖;',
  `jwid` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='九宫格活动报名表';

-- ----------------------------
-- Records of wx_act_jiugongge_registration
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_act_jiugongge_relation`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_jiugongge_relation`;
CREATE TABLE `wx_act_jiugongge_relation` (
  `id` varchar(36) NOT NULL default '',
  `prize_id` varchar(36) default NULL,
  `act_id` varchar(36) default NULL,
  `jwid` varchar(64) default NULL,
  `award_id` varchar(36) default NULL,
  `amount` int(10) default NULL COMMENT '数量',
  `remain_num` int(10) default NULL COMMENT '剩余数量',
  `probability` double(5,2) default '0.00' COMMENT '概率',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动奖品明细表';

-- ----------------------------
-- Records of wx_act_jiugongge_relation
-- ----------------------------
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904320013', '402880ee5127c20a01512823001d000c', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281efbd00006', '1', '1', '0.07');
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904350014', '402880ee5127c20a01512823417c000d', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281f395f0007', '2', '2', '0.09');
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904360015', '402880ee5127c20a015128237268000e', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281f69740008', '3', '3', '0.10');
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904370016', '402880ee5127c20a01512823a265000f', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281f8d290009', '4', '4', '0.15');
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904380017', '402880ee5127c20a01512824448a0010', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281fc42d000a', '5', '5', '0.20');
INSERT INTO `wx_act_jiugongge_relation` VALUES ('402880ee5127c20a0151283904390018', '402880ee5127c20a01512824a8600011', '402880ee5127c20a0151283904170012', 'gh_f268aa85d1c7', '402880ee5127c20a0151281fe96b000b', '6', '6', '0.20');

-- ----------------------------
-- Table structure for `wx_act_shaketicket_award`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_shaketicket_award`;
CREATE TABLE `wx_act_shaketicket_award` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `is_card` varchar(2) default NULL COMMENT '是否卡券0 是1 否',
  `awards_name` varchar(64) default NULL COMMENT '奖品名称',
  `owner` varchar(64) default NULL COMMENT '发奖公司',
  `card_id` varchar(64) default NULL COMMENT '卡券id',
  `img` varchar(100) default NULL COMMENT '奖品图片',
  `jwid` varchar(64) default NULL COMMENT '微信公众号',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项表';

-- ----------------------------
-- Records of wx_act_shaketicket_award
-- ----------------------------
INSERT INTO `wx_act_shaketicket_award` VALUES ('402880ee5127c20a0151281efbd00016', '1', '北京国炬现金抵用券', '北京国炬', 'pDltNwW02RH4RuUu5iQ_uHOxSLbY', null, 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `wx_act_shaketicket_config`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_shaketicket_config`;
CREATE TABLE `wx_act_shaketicket_config` (
  `id` varchar(32) NOT NULL COMMENT '活动ID',
  `act_id` varchar(32) NOT NULL COMMENT '所属活动',
  `award_id` varchar(32) NOT NULL,
  `probability` double(8,3) default NULL COMMENT '中奖概率',
  `amount` int(10) default NULL COMMENT '总数量',
  `remain_num` int(10) default NULL COMMENT '剩余数量',
  `jwid` varchar(64) default NULL COMMENT '微信公众号',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动奖项配置表';

-- ----------------------------
-- Records of wx_act_shaketicket_config
-- ----------------------------
INSERT INTO `wx_act_shaketicket_config` VALUES ('402880ee5127c21a0151281efbd12310', '402880ee51cd37910151cd4702720001', '402880ee5127c20a0151281efbd00016', '1.000', '100', '100', 'gh_f268aa85d1c7');

-- ----------------------------
-- Table structure for `wx_act_shaketicket_home`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_shaketicket_home`;
CREATE TABLE `wx_act_shaketicket_home` (
  `id` varchar(100) NOT NULL COMMENT '键主',
  `act_name` varchar(400) default NULL COMMENT '活动名称',
  `active_flag` varchar(2) default NULL COMMENT '启用状态（0：停用；1：激活）',
  `template` varchar(100) default NULL COMMENT '模版简称',
  `count` int(10) default NULL COMMENT '抽奖次数',
  `num_per_day` int(11) default '0' COMMENT '每日抽奖次数',
  `hdurl` varchar(200) default NULL COMMENT '入口地址',
  `foucs_user_can_join` varchar(1) default '0' COMMENT '是否关注可参加 0否1是',
  `binding_mobile_can_join` varchar(1) default '0' COMMENT '是否绑定手机可参加 0否1是',
  `win_can_join` varchar(1) default '0' COMMENT '是否中奖可参与 0：中奖可继续参与 1:中奖不可参与',
  `jwid` varchar(64) NOT NULL COMMENT '微信原始id',
  `project_code` varchar(32) NOT NULL COMMENT '所属项目编码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='摇一摇活动表';

-- ----------------------------
-- Records of wx_act_shaketicket_home
-- ----------------------------
INSERT INTO `wx_act_shaketicket_home` VALUES ('402880ee51cd37910151cd4702720001', '摇一摇', '1', 'default', '1', '0', 'http://wx.jeecg.com/jeewx/weixinLinksucaiController.do?link&id=ff80808151d26aca0151d80bfebc044f&actId=402880ee51cd37910151cd4702720001&jwid=gh_f268aa85d1c7', '0', '0', '1', 'gh_f268aa85d1c7', 'shaketicket');

-- ----------------------------
-- Table structure for `wx_act_shaketicket_record`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_shaketicket_record`;
CREATE TABLE `wx_act_shaketicket_record` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `act_id` varchar(32) NOT NULL COMMENT '活动ID',
  `award_id` varchar(64) default NULL COMMENT '奖品ID',
  `openid` varchar(100) NOT NULL COMMENT '微信openid',
  `awards_seq` int(11) NOT NULL COMMENT '奖品序号',
  `draw_status` varchar(2) NOT NULL COMMENT '抽奖状态 0 未中奖 1已中奖',
  `receive_status` varchar(2) default NULL COMMENT '领取状态 0 未领取 1已领取',
  `draw_time` datetime default NULL COMMENT '抽奖时间',
  `receive_time` datetime default NULL,
  `jwid` varchar(64) default NULL COMMENT '微信公众号',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_actid_awardsseq` (`act_id`,`awards_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抽奖记录表';

-- ----------------------------
-- Records of wx_act_shaketicket_record
-- ----------------------------
