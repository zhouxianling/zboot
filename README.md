## 写在开头

> **zboot项目的初衷是用于快速开发各种小型的系统的，zboot基于springboot+mybatis架构实现的。集成了jwt安全验证，swagger-ui接口调试，Redis数据库等。而且还配套zboot-ui后台管理前端，zboot-ui是基于element框架开发的。**


----

##  zboot-ui相关截图
### 登录界面
![登录界面](https://img-blog.csdnimg.cn/20190414235253875.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### 首页
> 动态菜单配置

![首页](https://img-blog.csdnimg.cn/20190414235326373.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### 菜单管理

> 无线级菜单管理

![菜单管理](https://img-blog.csdnimg.cn/2019041423534422.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### 用户管理界面

> 部门筛选，角色分配等功能。

![用户管理](https://img-blog.csdnimg.cn/20190414235358651.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### 角色管理

> 角色动态菜单配置

![角色管理](https://img-blog.csdnimg.cn/20190414235418430.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### 机构管理

> 无限级机构配置

![部门管理](https://img-blog.csdnimg.cn/20190414235437285.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)
### swagger接口调试

> Swagger UI 是目前最流行的 RestFul 接口 API 文档和测试工具

![swagger-ui](https://img-blog.csdnimg.cn/20190414235455595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pob3V4aWFubGluZzIzMw==,size_16,color_FFFFFF,t_70)

### 服务端zboot项目介绍
> 基于springboot+mybatis+mysql搭建的，
> - 集成了Redis数据库
> - swagger-ui接口调试
> - jwt权限认证
> - mybatisplus代码自动生成
> - 全局异常处理
> - 等等




### 前端zboot-ui项目介绍
	这是基于后端项目zboot项目的的后台管理功能，实现了根据用户角色动态生成菜单，以及用户、角色、部门、菜单管理等基础功能。
#### Build Setup
```
# Install dependencies
npm install

# 建议不要用cnpm  安装有各种诡异的bug 可以通过如下操作解决npm速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# Serve with hot reload at localhost:9528
npm run dev

# Build for production with minification
npm run build

# Build for production and view the bundle analyzer report
npm run build --report
```


### 结尾
服务端地址[zboot项目地址](https://github.com/zhouxianling/zboot)
前端地址[zboot-ui项目地址](https://github.com/zhouxianling/zboot-ui)
有不足的地方欢迎大家留言。
