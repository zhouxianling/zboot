## 写在开头

> **zboot项目的初衷是用于快速开发各种小型的系统的，zboot基于springboot+mybatis架构实现的。集成了jwt安全验证，swagger-ui接口调试，Redis数据库等。而且还配套zboot-ui后台管理前端，zboot-ui是基于element框架开发的。**


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
