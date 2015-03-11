# 车源汇众 图形报表

------

这是一个JavaWeb 图形报表的骨架.

## 技术框架：

> * 后端使用spring+mybatis，shiro做权限验证，最简单的骨架可以参考[quick4j](https://github.com/starzou/quick4j)
> * 前端css框架使用了 londinium, 这不是一个开源项目
> * 画图使用了d3.js
> * 报表使用了c3.js

------

## 如何安装
> * 下载项目: git clone http://10.0.0.23/root/javaweb-demo.git
> * maven安装分词器ik-analyzer，下载地址：https://github.com/leiguorui/ik-analyzer
> * maven打包: mvn package -Dmaven.test.skip=true
> * 解压quick4j.war,拷贝到tomcat的webapp/ROOT中，否则css找不到