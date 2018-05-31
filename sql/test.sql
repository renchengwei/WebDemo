/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 10/09/2017 21:39:18 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `permissions`
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL COMMENT '权限名称',
  `type` varchar(2) NOT NULL COMMENT '权限类型：0：目录 1：菜单 2：按钮',
  `available` char(1) NOT NULL COMMENT '是否可用 0：可用 1：禁用',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '修改时间',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父目录ID，type为1时有值',
  `menu_url` varchar(128) DEFAULT NULL COMMENT '菜单URL，type为1时有值',
  `order_no` int(11) NOT NULL COMMENT '排序号',
  `code` varchar(50) NOT NULL COMMENT '授权标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '权限图标',
  `is_deleted` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `permissions`
-- ----------------------------
BEGIN;
INSERT INTO `permissions` VALUES ('84', '首页', '1', '1', '2017-07-09 18:39:34', '2017-07-12 19:59:57', '-1', '/index.html', '0', 'index', 'fa fa-home', '0'), ('85', '系统用户', '0', '1', '2017-07-09 18:42:18', '2017-07-12 20:00:13', '-1', '', '1', 'system:user', 'fa fa-edit', '0'), ('86', '权限角色', '0', '1', '2017-07-09 18:42:53', '2017-07-09 23:07:09', '-1', '', '2', 'system:permission', 'fa fa-desktop', '0'), ('87', '系统监控', '0', '0', '2017-07-09 18:43:50', '2017-07-09 18:43:50', '-1', '', '3', 'system:monitor', 'fa fa-desktop', '0'), ('88', '人员管理', '1', '0', '2017-07-09 18:45:16', '2017-07-09 18:45:16', '85', '/user/list.jsp', '0', 'user:list', '', '0'), ('89', '权限管理', '1', '0', '2017-07-09 18:53:51', '2017-07-09 18:53:51', '86', '/jsp/authority/permissionList.jsp', '0', 'permission:list', '', '0'), ('90', '角色管理', '1', '0', '2017-07-09 18:54:23', '2017-07-09 18:54:23', '86', 'abc', '1', 'role:list', '', '0'), ('91', '数据库监控', '1', '1', '2017-07-09 19:02:43', '2017-07-09 19:02:43', '87', 'aa', '0', 'database:status', '', '0'), ('92', '新增', '2', '1', '2017-07-09 19:05:07', '2017-07-09 19:05:07', '89', '', '0', 'permission:add', '', '0'), ('93', '在线用户', '1', '1', '2017-07-12 20:05:38', '2017-07-12 20:20:39', '87', 'aaa', '2', 'abc', '', '1');
COMMIT;

-- ----------------------------
--  Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `available` char(1) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `is_deleted` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `roles`
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES ('2', 'admin', 'admin', '1', '2017-03-12 09:23:55', '2017-03-12 09:23:55', ''), ('3', 'user', 'user', '1', '2017-03-12 09:33:22', '2017-03-12 09:33:22', ''), ('4', '角色1', '角色1', '1', '2017-08-05 23:06:44', '2017-08-05 23:06:44', '0'), ('5', '角色1', '角色1', '1', '2017-08-05 23:06:50', '2017-08-05 23:06:50', '0'), ('6', '角色2', '角色2', '1', '2017-08-05 23:08:14', '2017-08-05 23:08:14', '0'), ('7', 'test2', '', '1', '2017-08-26 14:44:15', '2017-08-26 14:44:15', '0');
COMMIT;

-- ----------------------------
--  Table structure for `roles_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `roles_permissions`
-- ----------------------------
BEGIN;
INSERT INTO `roles_permissions` VALUES ('2', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gmt_create` time DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `test`
-- ----------------------------
BEGIN;
INSERT INTO `test` VALUES ('1', 'aa', '22:05:14', 'ok'), ('3', 'aa', '22:11:46', 'this is update result'), ('4', 'aa', '22:29:41', 'ok'), ('5', 'aa', '22:30:57', 'ok'), ('6', 'aa', '22:31:38', 'ok'), ('7', 'aa', '23:30:33', 'ok');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  `password_salt` varchar(128) DEFAULT NULL,
  `locked` char(1) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `is_deleted` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'zhangsan', '345678', '34567', '0', '2017-03-12 23:13:32', '2017-03-12 23:13:32', '0'), ('5', 'lisi', 'dd5545831eb574c21fc7d9aadf9a2e2d', '98d723b3a0012f60dad18c2eb4d48519', '0', '2017-03-12 16:44:50', '2017-03-12 16:44:50', '0');
COMMIT;

-- ----------------------------
--  Table structure for `users_roles`
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users_roles`
-- ----------------------------
BEGIN;
INSERT INTO `users_roles` VALUES ('3', '5', '2'), ('4', '5', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
