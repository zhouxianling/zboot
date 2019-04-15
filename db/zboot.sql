/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : sbm_table

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/04/2019 09:32:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `parent_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '云南省', NULL, '2018-01-22 19:00:23', '2019-03-06 15:16:21', '0', 0);
INSERT INTO `sys_dept` VALUES (2, '山东省', NULL, '2018-01-22 19:00:38', '2019-03-06 15:16:36', '0', 0);
INSERT INTO `sys_dept` VALUES (3, '昆明市', NULL, '2018-01-22 19:00:44', '2019-03-06 15:16:53', '0', 1);
INSERT INTO `sys_dept` VALUES (4, '盘龙区', NULL, '2018-01-22 19:00:52', '2019-03-06 15:16:59', '0', 3);
INSERT INTO `sys_dept` VALUES (5, '金辰', 1, '2019-04-04 09:51:37', '2019-04-04 09:51:37', '0', 4);
INSERT INTO `sys_dept` VALUES (6, '金刀营', NULL, '2018-01-22 19:01:06', '2019-03-06 15:17:46', '1', 5);
INSERT INTO `sys_dept` VALUES (7, '山东沙县', NULL, '2018-01-22 19:01:57', '2018-09-13 01:46:42', '0', 2);
INSERT INTO `sys_dept` VALUES (8, '潍坊沙县', NULL, '2018-01-22 19:02:03', '2018-09-13 01:46:43', '0', 7);
INSERT INTO `sys_dept` VALUES (9, '高新沙县', NULL, '2018-01-22 19:02:14', '2018-09-13 01:46:44', '1', 8);
INSERT INTO `sys_dept` VALUES (10, '贵州省', 1, '2019-04-05 13:47:39', '2019-04-05 13:47:39', '0', 0);
INSERT INTO `sys_dept` VALUES (11, '院校沙县', NULL, '2018-12-10 21:19:26', '2019-03-06 15:16:02', '0', 8);
INSERT INTO `sys_dept` VALUES (20, '北京市', 1, '2019-03-07 03:14:06', '2019-03-07 12:08:17', '1', 0);
INSERT INTO `sys_dept` VALUES (26, '四川省', 1, '2019-04-04 09:58:15', NULL, '0', 0);

-- ----------------------------
-- Table structure for sys_dept_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_relation`;
CREATE TABLE `sys_dept_relation`  (
  `ancestor` bigint(20) NOT NULL COMMENT '祖先节点',
  `descendant` bigint(20) NOT NULL COMMENT '后代节点',
  PRIMARY KEY (`ancestor`, `descendant`) USING BTREE,
  INDEX `idx1`(`ancestor`) USING BTREE,
  INDEX `idx2`(`descendant`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '部门关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept_relation
-- ----------------------------
INSERT INTO `sys_dept_relation` VALUES (1, 1);
INSERT INTO `sys_dept_relation` VALUES (1, 3);
INSERT INTO `sys_dept_relation` VALUES (1, 4);
INSERT INTO `sys_dept_relation` VALUES (1, 5);
INSERT INTO `sys_dept_relation` VALUES (1, 18);
INSERT INTO `sys_dept_relation` VALUES (2, 2);
INSERT INTO `sys_dept_relation` VALUES (2, 7);
INSERT INTO `sys_dept_relation` VALUES (2, 8);
INSERT INTO `sys_dept_relation` VALUES (2, 11);
INSERT INTO `sys_dept_relation` VALUES (3, 3);
INSERT INTO `sys_dept_relation` VALUES (3, 4);
INSERT INTO `sys_dept_relation` VALUES (3, 5);
INSERT INTO `sys_dept_relation` VALUES (4, 4);
INSERT INTO `sys_dept_relation` VALUES (4, 5);
INSERT INTO `sys_dept_relation` VALUES (5, 5);
INSERT INTO `sys_dept_relation` VALUES (7, 7);
INSERT INTO `sys_dept_relation` VALUES (7, 8);
INSERT INTO `sys_dept_relation` VALUES (7, 11);
INSERT INTO `sys_dept_relation` VALUES (8, 8);
INSERT INTO `sys_dept_relation` VALUES (8, 11);
INSERT INTO `sys_dept_relation` VALUES (10, 10);
INSERT INTO `sys_dept_relation` VALUES (11, 11);
INSERT INTO `sys_dept_relation` VALUES (22, 22);
INSERT INTO `sys_dept_relation` VALUES (23, 23);
INSERT INTO `sys_dept_relation` VALUES (26, 26);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `sort` int(10) NOT NULL COMMENT '排序（升序）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_dict_value`(`value`) USING BTREE,
  INDEX `sys_dict_label`(`label`) USING BTREE,
  INDEX `sys_dict_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '9', '异常', 'log_type', '日志异常', 1, '2018-07-09 06:16:14', '2018-11-24 07:25:11', '日志异常', '0');
INSERT INTO `sys_dict` VALUES (2, '0', '正常', 'log_type', '正常', 0, '2018-07-09 06:15:40', '2018-11-24 07:25:14', '正常', '0');
INSERT INTO `sys_dict` VALUES (3, 'WX', '微信', 'social_type', '微信登录', 0, '2018-08-16 14:01:45', '2018-11-24 07:25:16', '微信登录', '0');
INSERT INTO `sys_dict` VALUES (4, 'QQ', 'QQ', 'social_type', 'QQ登录', 1, '2018-07-09 06:15:40', '2018-11-24 07:25:18', 'QQ登录', '0');
INSERT INTO `sys_dict` VALUES (5, '0', '正常', 'log_type', '日志类型', 0, '2018-09-30 02:33:53', '2018-11-24 07:25:20', '日志正常', '0');
INSERT INTO `sys_dict` VALUES (6, '0', '未提交', 'leave_status', '请假状态', 0, '2018-09-30 02:34:45', '2018-11-24 07:25:23', '请假状态', '0');
INSERT INTO `sys_dict` VALUES (7, '1', '审批中', 'leave_status', '请假状态', 1, '2018-09-30 02:35:16', '2018-11-24 07:25:25', '请假状态', '0');
INSERT INTO `sys_dict` VALUES (8, '2', '完成', 'leave_status', '请假状态', 2, '2018-09-30 02:35:58', '2018-11-24 07:25:28', '请假状态', '0');
INSERT INTO `sys_dict` VALUES (9, '9', '驳回', 'leave_status', '请假状态', 9, '2018-09-30 02:36:31', '2018-11-24 07:25:31', '请假状态', '0');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` bit(1) NULL DEFAULT NULL,
  `new_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新文件名称',
  `original_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源文件名称',
  `suffix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `volume` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1045 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES (1045, '2019-03-05 15:24:30', b'0', 'c7b8ba6f-ff57-4636-a2d0-422575773e22.txt', '123.txt', '.txt', '59B', NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作提交的数据',
  `time` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '执行时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  `exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_log_create_by`(`create_by`) USING BTREE,
  INDEX `sys_log_request_uri`(`request_uri`) USING BTREE,
  INDEX `sys_log_type`(`type`) USING BTREE,
  INDEX `sys_log_create_date`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (51, '0', '添加角色', 'test', 'admin', '2019-01-24 20:56:43', NULL, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.6.0', '/role', 'POST', 'Authorization=%5B%5D', '65', '0', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端URL',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) NULL DEFAULT 1 COMMENT '排序值',
  `keep_alive` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0-开启，1- 关闭',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '博客管理', '/api/**', '/blog/', 0, 'menu', NULL, 1, '0', NULL, '2019-04-04 14:55:59', '2019-04-04 14:56:01', '0');
INSERT INTO `sys_menu` VALUES (2, '正文管理', '/api/**', '/blog/content', 1, 'guide', NULL, 1, '0', NULL, '2019-04-04 14:57:27', '2019-04-04 14:57:46', '0');
INSERT INTO `sys_menu` VALUES (4, '系统设置', '/api/**', '/setting', 0, 'setting', NULL, 5, '0', NULL, '2019-03-11 15:50:02', '2019-03-15 14:58:45', '0');
INSERT INTO `sys_menu` VALUES (5, '用户管理', '/api/**', '/setting/user', 4, 'user', NULL, 1, '0', NULL, '2019-03-11 15:50:38', '2019-04-04 17:30:05', '0');
INSERT INTO `sys_menu` VALUES (6, '角色管理', '/api/**', '/setting/role', 4, 'guide', NULL, 2, '0', NULL, '2019-03-11 15:51:11', '2019-04-04 17:30:11', '0');
INSERT INTO `sys_menu` VALUES (7, '菜单管理', '/api/**', '/setting/menu', 4, 'menu', NULL, 3, '0', NULL, '2019-03-11 16:03:11', '2019-04-04 17:30:13', '0');
INSERT INTO `sys_menu` VALUES (8, '部门管理', '/api/**', '/setting/dept', 4, 'tree', NULL, 4, '0', NULL, '2019-03-11 16:03:41', '2019-04-04 17:30:15', '0');
INSERT INTO `sys_menu` VALUES (33, '标题管理', '/api/**', '/blog/content', 1, 'guide', NULL, 2, '0', NULL, '2019-04-04 09:20:12', '2019-04-04 17:20:12', '0');
INSERT INTO `sys_menu` VALUES (34, '作者管理', '/api/**', '/blog/content', 1, 'guide', NULL, 1, '0', NULL, '2019-04-04 09:20:33', '2019-04-04 17:20:33', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_idx1_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (12, '\r\n超级管理员', 'superAdmin', '6666', '2019-03-07 07:33:41', '2019-03-15 11:43:24', '0');
INSERT INTO `sys_role` VALUES (26, '测试', 'test', '测试角色', '2019-04-05 16:26:01', NULL, '0');
INSERT INTO `sys_role` VALUES (27, '周', 'zhou', '超级管理员', '2019-04-05 16:32:52', NULL, '0');
INSERT INTO `sys_role` VALUES (28, '李', 'Li', '超级管理员', '2019-04-05 16:34:05', NULL, '0');
INSERT INTO `sys_role` VALUES (29, '管理员', 'admins', '管理员', '2019-04-05 16:35:53', NULL, '0');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` int(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (12, 1);
INSERT INTO `sys_role_menu` VALUES (12, 2);
INSERT INTO `sys_role_menu` VALUES (12, 4);
INSERT INTO `sys_role_menu` VALUES (12, 5);
INSERT INTO `sys_role_menu` VALUES (12, 6);
INSERT INTO `sys_role_menu` VALUES (12, 7);
INSERT INTO `sys_role_menu` VALUES (12, 8);
INSERT INTO `sys_role_menu` VALUES (29, 1);
INSERT INTO `sys_role_menu` VALUES (29, 2);
INSERT INTO `sys_role_menu` VALUES (29, 4);
INSERT INTO `sys_role_menu` VALUES (29, 5);
INSERT INTO `sys_role_menu` VALUES (29, 6);
INSERT INTO `sys_role_menu` VALUES (29, 7);
INSERT INTO `sys_role_menu` VALUES (29, 8);
INSERT INTO `sys_role_menu` VALUES (29, 32);
INSERT INTO `sys_role_menu` VALUES (29, 33);
INSERT INTO `sys_role_menu` VALUES (29, 34);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '简介',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `lock_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '0-正常，9-锁定',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '0-正常，1-删除',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_idx1_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (4, 'admin', '1000:fe9fcb330ce3d55be81b91821341a3c03ccc406d311522a8:ff9a9b03bbb8d43949e944515bf3ce455f847141b27934f1', NULL, '10086', NULL, 1, '2019-03-07 15:24:29', '2019-04-05 20:15:26', '0', '0', '蔡二');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (4, 29);

SET FOREIGN_KEY_CHECKS = 1;
