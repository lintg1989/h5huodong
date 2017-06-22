H5活动之家（h5huodong.com） | 开源免费微信活动平台
==========
特点：采用微服务架构，插件式开发、专业微信营销活动平台，具备大用户、高并发支撑能力


技术交流
==========
* H5活动之家官网：[www.h5huodong.com](http://www.h5huodong.com)
* 开发者论坛 ：[www.jeecg.org](http://www.jeecg.org)
* H5活动之家QQ群 : 413534092

官方公众号（H5活动之家）
==========
![github](http://www.jeecg.org/data/attachment/forum/201601/25/180314mjvputsot6hhtvoa.jpg "jeewx521")

### 微信H5活动源码列表（陆续更新..）
	  1.微信砍价活动   P3-Biz-gzbargain
	  2.摇一摇送卡券   P3-Biz-shaketicket
	  3.九宫格活动     P3-Biz-jiugongge
	  4.斧头帮砍价     P3-Biz-commonftb
	  
	  
### 砍价活动-效果图
![github](http://www.jeecg.org/data/attachment/forum/201601/25/180710anjfgtn677nojgg0.png "jeecg")
### 九宫格活动-效果图
![github](http://www.jeecg.org/data/attachment/forum/201601/25/180716vp55nguk5ggwqngw.png "jeecg")
### 斧头帮砍价-效果图
![github](http://www.jeecg.org/data/attachment/forum/201601/25/180500iwpg1agqm778wggp.png "jeecg")
### 摇一摇送卡券-效果图
![github](http://www.jeecg.org/data/attachment/forum/201601/25/180718zwfdl9ml1a15w8jf.png "jeecg")


【开发文档】

![github](http://img.blog.csdn.net/20151028163509595?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center "jeecg")
* [  文档下载来点我](http://www.jeecg.org/forum.php?mod=forumdisplay&fid=202)



	  
【架构说明】

    1.采用SpringMvc + Mybatis + Velocity + Maven(构建) 框架技术
    2.插件引入方式
        pom.xml文件中，引入新开发的插件
        <!-- P3 jar -->
 	    <dependency>
			<groupId>org.jeecgframework</groupId>
			<artifactId>P3-Biz-gzbargain</artifactId>
			<version>2.0.0</version>
		</dependency>
	3.项目启动访问方式：
	  采用maven方式，启动Web项目
      http://localhost:8080/P3-Web/{页面访问地址}
    4.页面层面不能采用jsp，需要采用模板语言Velocity
    5.实现插件式开发，按照模块进行开发，每个模块可以单独达成jar包
	6.数据库配置文件：
	  src/main/resources/db.properties
	  
	  
【开发入门】

	1.Eclipse + Maven + JDK7
    2.项目以Maven方式导入eclipse
	3.执行Mysql数据库脚本，每个项目脚本单独提供
	    P3-Web\doc\db\p3-base-init.sql
		P3-Biz-jiugongge\doc\db\jiugongge-init.sql
		P3-Biz-gzbargain\doc\db\gzbargain-init.sql
		P3-Biz-commonftb\doc\db\commonftb-init.sql
		P3-Biz-shaketicket\doc\db\shaketicket-init.sql
		
		完整项目SQL脚本：
		docs\p3-weixin-all-mysql.sql
	4.采用maven方式，启动主项目P3-Web，命令：tomcat:run
      活动访问地址：
	     http://localhost:8080/P3-Web/gzbargain/toIndex.do?actId=actgzbargain00001&openid=oR0jFt_DTsAUJebWqGeq3A1VWfRw&subscribe=1
	  说明：插件不能单独启动，maven方式引入到Web项目
	5.系统默认登录账号 admin/123456
	  
	
【代码生成器】

	1.工具类：P3-Web/src/main/java/org/jeecgframework/p3/cg/util/CodeToolUtil.java
	2.配置文件：P3-Web/src/main/resources/p3-cg-config.properties



### H5活动之家（管理后台）
![github](http://img.blog.csdn.net/20160830143702156?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center "jeecg")
![github](http://img.blog.csdn.net/20151028202206676?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center "jeecg")
![github](http://www.jeecg.org/data/attachment/forum/201601/25/182100gwfrlwssjbp278wf.png "jeecg")