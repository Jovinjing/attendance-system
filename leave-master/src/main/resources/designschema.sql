/*
 Navicat Premium Data Transfer

 Source Server         : benji
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : designschema

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 27/12/2025 01:14:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `class_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '班级编号',
  `class_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `dep_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '二级学院编号',
  `major` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专业',
  `grade` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '年级',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '班级表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, 'DSJ-18RJ01', '运维测试部', 'G1', '软件工程', '2022年', '2021-05-08 16:27:59', '2022-05-07 19:03:23');
INSERT INTO `classes` VALUES (2, 'DSJ-18RJ02', '前端开发部', 'G1', '软件工程', '2022年', '2021-05-08 16:27:59', '2022-05-07 19:03:25');
INSERT INTO `classes` VALUES (3, 'DSJ-18RJ03', '后端开发部', 'G1', '软件工程', '2022年', '2021-05-08 16:27:59', '2022-05-07 19:03:27');

-- ----------------------------
-- Table structure for signin
-- ----------------------------
DROP TABLE IF EXISTS `signin`;
CREATE TABLE `signin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `signin_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假编号',
  `course_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '课程编码',
  `reason` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假理由',
  `day_num` int NULL DEFAULT NULL COMMENT '天数',
  `stu_no` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学号',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '请假时间',
  `status` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '状态',
  `audit_time` datetime NULL DEFAULT NULL COMMENT '审核已经',
  `opinion` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '请假表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of signin
-- ----------------------------
INSERT INTO `signin` VALUES (15, 'WZ1651970484544344', NULL, 'ssssssssssss', 1, '201809512327', '2022-05-05 16:52:07', '成功', '2022-05-08 09:09:53', '无', '2022-05-08 08:41:53', '2022-05-08 10:51:35');
INSERT INTO `signin` VALUES (16, 'WZ1651976670551612', NULL, 'aaa得到', 1, '201809512327', '2022-05-08 10:24:54', '成功', NULL, NULL, '2022-05-08 10:24:55', '2022-05-08 10:51:37');
INSERT INTO `signin` VALUES (17, 'WZ1651976927607105', NULL, '打卡', 1, '201809512327', '2022-05-08 10:28:58', '成功', NULL, NULL, '2022-05-08 10:28:59', '2022-05-08 10:51:38');
INSERT INTO `signin` VALUES (18, 'WZ1651977856745394', NULL, NULL, 1, '201809512327', '2022-05-08 10:44:20', '成功', NULL, NULL, '2022-05-08 10:44:21', '2022-05-08 10:51:40');
INSERT INTO `signin` VALUES (19, 'WZ1651978309432501', NULL, NULL, 1, '201809512327', '2022-05-08 10:51:51', '成功', NULL, NULL, '2022-05-08 10:51:52', '2022-05-08 10:51:52');
INSERT INTO `signin` VALUES (20, 'WZ1766751674444814', NULL, NULL, 1, '201809512327', '2025-12-24 00:00:00', '成功', NULL, NULL, '2025-12-26 20:21:54', '2025-12-26 20:21:54');

-- ----------------------------
-- Table structure for sys_course
-- ----------------------------
DROP TABLE IF EXISTS `sys_course`;
CREATE TABLE `sys_course`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `class_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '班号',
  `course_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `year` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学年',
  `term` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学期',
  `hour` int NULL DEFAULT NULL COMMENT '学时',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '课程表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_course
-- ----------------------------
INSERT INTO `sys_course` VALUES (1, '1800001201', 'DSJ-18RJ03', '公假2', '2020', '1', 120, '2021-05-09 22:48:12', '2022-05-08 15:01:59');
INSERT INTO `sys_course` VALUES (2, '1800001202', 'DSJ-18RJ03', '私假', '2020', '1', 112, '2021-05-09 22:48:12', '2022-05-08 15:02:01');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `dep_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '二级学院编码',
  `dep_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '二级学院表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES (1, 'G1', '火山引擎', '2021-05-08 16:27:59', '2022-05-07 19:29:13');
INSERT INTO `sys_department` VALUES (2, 'G2', '叮咚买菜', '2021-05-08 16:27:59', '2022-05-07 19:29:25');
INSERT INTO `sys_department` VALUES (3, 'G3', '充电桩业务', '2021-05-08 16:27:59', '2022-05-07 19:29:33');

-- ----------------------------
-- Table structure for sys_instructor
-- ----------------------------
DROP TABLE IF EXISTS `sys_instructor`;
CREATE TABLE `sys_instructor`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `inst_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工号',
  `inst_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `dep_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '二级学院编号',
  `telephone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '辅导员表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_instructor
-- ----------------------------
INSERT INTO `sys_instructor` VALUES (1, '201812378', '张经理', 'G1', '13758952158', '2021-05-08 16:27:59', '2022-05-08 15:02:29');
INSERT INTO `sys_instructor` VALUES (2, '201812399', '李经理', 'G1', '17683869523', '2021-05-08 16:27:59', '2022-05-08 15:02:34');
INSERT INTO `sys_instructor` VALUES (3, '201925428', '王经理', 'G4', '14789652145', '2021-05-08 16:27:59', '2022-05-08 15:02:41');
INSERT INTO `sys_instructor` VALUES (4, '201932147', '周经理', 'G6', '13985421236', '2021-05-08 16:27:59', '2022-05-08 15:02:47');
INSERT INTO `sys_instructor` VALUES (5, '201965245', '恒经理', 'G2', '17685475215', '2021-05-08 16:27:59', '2022-05-08 15:02:52');
INSERT INTO `sys_instructor` VALUES (6, '201965412', '问经理', 'G7', '13587459682', '2021-05-08 16:27:59', '2022-05-08 15:03:00');
INSERT INTO `sys_instructor` VALUES (7, '201986321', '傲经理', 'G5', '13658745214', '2021-05-08 16:27:59', '2022-05-08 15:03:07');

-- ----------------------------
-- Table structure for sys_leave
-- ----------------------------
DROP TABLE IF EXISTS `sys_leave`;
CREATE TABLE `sys_leave`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `leave_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假编号',
  `course_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '课程编码',
  `reason` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假理由',
  `day_num` int NULL DEFAULT NULL COMMENT '天数',
  `stu_no` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学号',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '请假时间',
  `status` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '状态',
  `audit_time` datetime NULL DEFAULT NULL COMMENT '审核已经',
  `opinion` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '请假表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_leave
-- ----------------------------
INSERT INTO `sys_leave` VALUES (12, 'WZ1651913514517520', '1800001201', 'ssss', 1, '201809512327', '2022-05-05 16:52:07', '通过', '2022-05-07 18:59:41', '无', '2022-05-07 16:52:11', '2022-05-07 19:47:23');
INSERT INTO `sys_leave` VALUES (13, 'WZ1651913558649697', '1800001201', 'aaa', 1, '201809512327', '2022-05-25 00:00:00', '未审批', NULL, NULL, '2022-05-07 16:52:49', '2022-05-07 19:47:23');
INSERT INTO `sys_leave` VALUES (14, 'WZ1766545069239219', '1800001201', '广州培训公差', 14, '201809512327', '2025-12-24 00:00:00', '未审批', NULL, NULL, '2025-12-24 10:58:54', '2025-12-24 10:58:54');
INSERT INTO `sys_leave` VALUES (15, 'WZ1766751866623847', '1800001201', '广州培训公差', 3, '201809512327', '2025-12-26 20:24:55', '未审批', NULL, NULL, '2025-12-26 20:25:04', '2025-12-26 20:25:04');
INSERT INTO `sys_leave` VALUES (16, 'WZ1766751914846715', '1800001202', '生病', 1, '201809512327', '2025-12-17 00:00:00', '未审批', NULL, NULL, '2025-12-26 20:25:33', '2025-12-26 20:25:33');

-- ----------------------------
-- Table structure for sys_rest
-- ----------------------------
DROP TABLE IF EXISTS `sys_rest`;
CREATE TABLE `sys_rest`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `rest_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假编号',
  `course_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '课程编码',
  `reason` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假理由',
  `day_num` int NULL DEFAULT NULL COMMENT '天数',
  `stu_no` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学号',
  `apply_time` datetime NULL DEFAULT NULL COMMENT '请假时间',
  `status` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '状态',
  `audit_time` datetime NULL DEFAULT NULL COMMENT '审核已经',
  `opinion` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '请假表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_rest
-- ----------------------------
INSERT INTO `sys_rest` VALUES (15, 'WZ1651970484544344', NULL, 'ssssssssssss', 1, '201809512327', '2022-05-05 16:52:07', '通过', '2022-05-08 09:09:53', '无', '2022-05-08 08:41:53', '2022-05-08 09:09:55');
INSERT INTO `sys_rest` VALUES (16, 'WZ1766751950559998', NULL, '旅游', 3, '201809512327', '2025-12-26 20:26:06', '未审批', NULL, NULL, '2025-12-26 20:26:15', '2025-12-26 20:26:15');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工号',
  `full_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `telephone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '123', '总经理', '123456', '17683864164', '2021-05-07 22:05:47', '2022-05-08 11:03:10');
INSERT INTO `sys_user` VALUES (2, '111', '总经理', '111', '14254634564', '2021-05-08 19:47:56', '2022-05-07 19:20:30');
INSERT INTO `sys_user` VALUES (3, '201809512327', '普通员工', '123456', '15782586425', '2021-05-08 16:27:59', '2022-05-07 20:22:41');
INSERT INTO `sys_user` VALUES (4, '201809512328', '普通员工', '123456', '14258725257', '2021-05-08 16:27:59', '2022-05-07 20:22:43');
INSERT INTO `sys_user` VALUES (5, '201809512340', '普通员工', '123456', '14256754287', '2021-05-08 16:27:59', '2022-05-07 20:22:44');
INSERT INTO `sys_user` VALUES (6, '201812378', '部门经理', '123456', '14248557598', '2021-05-08 16:27:59', '2022-05-07 19:17:04');
INSERT INTO `sys_user` VALUES (7, '201812399', '部门经理', '123456', '17842534254', '2021-05-08 16:27:59', '2022-05-07 19:20:33');
INSERT INTO `sys_user` VALUES (8, '201909512328', '普通员工', '123456', '12587542825', '2021-05-08 16:27:59', '2022-05-07 20:22:45');
INSERT INTO `sys_user` VALUES (9, '201909512330', '普通员工', '123456', '17854424255', '2021-05-08 16:27:59', '2022-05-07 20:22:46');
INSERT INTO `sys_user` VALUES (10, '201925428', '人事处员工', '123456', '15782424557', '2021-05-08 16:27:59', '2022-05-07 19:17:34');
INSERT INTO `sys_user` VALUES (11, '201932147', '财务处员工', '123456', '17977454282', '2021-05-08 16:27:59', '2022-05-08 11:16:04');
INSERT INTO `sys_user` VALUES (12, '201965245', '普通员工', '123456', '12428258325', '2021-05-08 16:27:59', '2022-05-08 15:03:28');

-- ----------------------------
-- Table structure for sys_worker
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker`;
CREATE TABLE `sys_worker`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编码',
  `stu_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工号',
  `class_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门号',
  `stu_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '通讯地址',
  `stu_tel` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作者电话',
  `contact` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contact_tel` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '联系人电话',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '工作者信息表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_worker
-- ----------------------------
INSERT INTO `sys_worker` VALUES (1, '201809512326', 'DSJ-18RJ01', '工具人', 1, '广州应用科技学院', '17683864164', '工具人爸爸', '13578542365', '2021-05-08 16:27:59', '2025-12-27 01:10:12');
INSERT INTO `sys_worker` VALUES (2, '201809512327', 'DSJ-18RJ01', '风飒飒', 1, '广州应用科技学院', '14586255568', '风飒飒爸爸', '13784525242', '2021-05-08 16:27:59', '2025-12-27 01:10:14');
INSERT INTO `sys_worker` VALUES (3, '201809512328', 'DSJ-18RJ01', '张佳辉', 1, '广州应用科技学院', '12345686453', '张佳辉妈妈', '12854282528', '2021-05-08 16:27:59', '2025-12-27 01:10:16');
INSERT INTO `sys_worker` VALUES (4, '201809512340', 'DSJ-18RJ01', '艾丽丝', 0, '广州应用科技学院', '15864562345', '艾丽丝爸爸', '17953574575', '2021-05-08 16:27:59', '2025-12-27 01:10:18');
INSERT INTO `sys_worker` VALUES (5, '201909512328', 'DSJ-18RJ01', '傅凌湘', 0, '广州应用科技学院', '13868653453', '傅凌湘妈妈', '14852756868', '2021-05-08 16:27:59', '2025-12-27 01:10:19');
INSERT INTO `sys_worker` VALUES (6, '201909512330', 'DSJ-18RJ01', '弗朗叙', 1, '广州应用科技学院', '18755354686', '弗朗叙爸爸', '15825282285', '2021-05-08 16:27:59', '2025-12-27 01:10:56');
INSERT INTO `sys_worker` VALUES (7, '测试', 'DSJ-18RJ01', '测试', 1, '测试', '测试', '测试', '测试', '2021-05-09 12:35:25', '2022-05-07 19:02:34');

SET FOREIGN_KEY_CHECKS = 1;
