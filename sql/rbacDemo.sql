/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : rbacDemo

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 17/06/2020 15:33:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for iw_dict
-- ----------------------------
DROP TABLE IF EXISTS `iw_dict`;
CREATE TABLE `iw_dict` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pid` varchar(32) DEFAULT NULL COMMENT '父级id',
  `status` varchar(6) NOT NULL DEFAULT '002001' COMMENT '状态 002001启用 002002停用',
  `sort` int(20) NOT NULL DEFAULT '0' COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `del_flag` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典表';

-- ----------------------------
-- Table structure for iw_permission
-- ----------------------------
DROP TABLE IF EXISTS `iw_permission`;
CREATE TABLE `iw_permission` (
  `id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '权限名',
  `url` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型为菜单时，代表前端路由地址，类型为按钮时，代表后端接口地址',
  `type` int(2) NOT NULL COMMENT '权限类型，菜单-1，按钮-2',
  `icon` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单图标',
  `permission` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限表达式',
  `method` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '后端接口访问方式',
  `sort` int(11) NOT NULL COMMENT '排序',
  `parent_id` bigint(64) NOT NULL COMMENT '父级id',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  `del_flag` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源表';

-- ----------------------------
-- Records of iw_permission
-- ----------------------------
BEGIN;
INSERT INTO `iw_permission` VALUES ('1072806379288399872', '测试页面', '/test', 1, NULL, 'page:test', NULL, 1, 0, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379313565696', '测试页面-查询', '/**/test', 2, NULL, 'btn:test:query', 'GET', 1, 1072806379288399872, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379330342912', '测试页面-添加', '/**/test', 2, NULL, 'btn:test:insert', 'POST', 2, 1072806379288399872, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379342925824', '监控在线用户页面', '/monitor', 1, NULL, 'page:monitor:online', NULL, 2, 0, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379363897344', '在线用户页面-查询', '/**/api/monitor/online/user', 2, NULL, 'btn:monitor:online:query', 'GET', 1, 1072806379342925824, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379384868864', '在线用户页面-踢出', '/**/api/monitor/online/user/kickout', 2, NULL, 'btn:monitor:online:kickout', 'DELETE', 2, 1072806379342925824, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379384868865', '权限页面', '/permission', 1, NULL, 'page:permission', NULL, 3, 0, 0, 0, 0);
INSERT INTO `iw_permission` VALUES ('1072806379384868866', '权限页面-增加', '/**/api/permission', 2, NULL, 'btn:permission:insert', 'POST', 1, 1072806379384868865, 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for iw_role
-- ----------------------------
DROP TABLE IF EXISTS `iw_role`;
CREATE TABLE `iw_role` (
  `id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '角色名',
  `description` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  `del_flag` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of iw_role
-- ----------------------------
BEGIN;
INSERT INTO `iw_role` VALUES ('1072806379208708096', '管理员', '超级管理员', 1544611947239, 1544611947239, NULL);
INSERT INTO `iw_role` VALUES ('1072806379238068224', '普通用户', '普通用户', 1544611947246, 1544611947246, NULL);
COMMIT;

-- ----------------------------
-- Table structure for iw_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `iw_role_permission`;
CREATE TABLE `iw_role_permission` (
  `role_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '角色主键',
  `permission_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '权限主键',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  `del_flag` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of iw_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379288399872', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379313565696', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379330342912', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379342925824', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379363897344', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379384868864', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379384868865', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379384868866', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379208708096', '1072806379384868867', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379238068224', '1072806379288399872', 0, 0, 0);
INSERT INTO `iw_role_permission` VALUES ('1072806379238068224', '1072806379313565696', 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for iw_user
-- ----------------------------
DROP TABLE IF EXISTS `iw_user`;
CREATE TABLE `iw_user` (
  `id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '主键',
  `user_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `pass_word` varchar(60) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '真实名字',
  `phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机',
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态，启用-1，禁用-0',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  `del_flag` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of iw_user
-- ----------------------------
BEGIN;
INSERT INTO `iw_user` VALUES ('1072806377661009920', 'admin', '$2a$10$64iuSLkKNhpTN19jGHs7xePvFsub7ZCcCmBqEYw8fbACGTE3XetYq', '管理员', '17300000000', NULL, NULL, 1, 1544611947032, 1544611947032, 0);
INSERT INTO `iw_user` VALUES ('1072806378780889088', 'user', '$2a$10$OUDl4thpcHfs7WZ1kMUOb.ZO5eD4QANW5E.cexBLiKDIzDNt87QbO', '普通用户', '17300001111', NULL, NULL, 1, 1544611947234, 1544611947234, 0);
COMMIT;

-- ----------------------------
-- Table structure for iw_user_role
-- ----------------------------
DROP TABLE IF EXISTS `iw_user_role`;
CREATE TABLE `iw_user_role` (
  `user_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '用户主键',
  `role_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '角色主键',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '更新时间',
  `del_flag` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

-- ----------------------------
-- Records of iw_user_role
-- ----------------------------
BEGIN;
INSERT INTO `iw_user_role` VALUES ('1072806377661009920', '1072806379208708096', 0, 0, 0);
INSERT INTO `iw_user_role` VALUES ('1072806378780889088', '1072806379238068224', 0, 0, 0);
INSERT INTO `iw_user_role` VALUES ('ddf01ab144064bf39b48dbd39e711428', '1072806379208708096', 1591428353433, 0, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
