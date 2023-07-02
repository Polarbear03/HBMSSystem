/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : hbmssystem

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/07/2023 14:54:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (-1572737022, 123, '张三', '12334', '12334323', 'dnaoibwiug');
INSERT INTO `admins` VALUES (-213901310, 123, '张三', '12334', '12334323', 'dnaoibwiug');
INSERT INTO `admins` VALUES (12, 123434, '3656547', '7876898', '9098', '3456');
INSERT INTO `admins` VALUES (79720449, 123, '张三', '12334', '12334323', 'dnaoibwiug');
INSERT INTO `admins` VALUES (486621186, 123, '312312', '343', '545', '6123');
INSERT INTO `admins` VALUES (486621187, 123, '123', '2343', '234', '541');
INSERT INTO `admins` VALUES (864124930, 1, '123', '12345', '123y9812', '12334');
INSERT INTO `admins` VALUES (1472208898, 1, '123', '12345', '123y9812', '12334');

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`  (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date_of_birth` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES (1, 1, '1', '1', '1', '1', '1', '2023-06-28 00:00:00', '2023-06-28 00:00:00', '1');

-- ----------------------------
-- Table structure for installers
-- ----------------------------
DROP TABLE IF EXISTS `installers`;
CREATE TABLE `installers`  (
  `installer_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`installer_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of installers
-- ----------------------------

-- ----------------------------
-- Table structure for merchants
-- ----------------------------
DROP TABLE IF EXISTS `merchants`;
CREATE TABLE `merchants`  (
  `merchant_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `merchant_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_license_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `registration_date` date NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchants
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NULL DEFAULT NULL,
  `merchant_id` int NULL DEFAULT NULL,
  `product_id` int NULL DEFAULT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `payment_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total_amount` decimal(10, 2) NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `unit_price` decimal(10, 2) NULL DEFAULT NULL,
  `discount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `customer_id`(`customer_id` ASC) USING BTREE,
  INDEX `merchant_id`(`merchant_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `delete_falg` int NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, '顾客管理', '/customer/**', 1, 1);
INSERT INTO `permissions` VALUES (2, '顾客查询', 'customer:query', 1, 1);
INSERT INTO `permissions` VALUES (3, '顾客添加', 'customer:add', 1, 1);
INSERT INTO `permissions` VALUES (4, '顾客修改', 'customer:update', 1, 1);
INSERT INTO `permissions` VALUES (5, '顾客封禁', 'customer:delete', 1, 1);
INSERT INTO `permissions` VALUES (6, '商家管理', '/merchant/**', 1, 1);
INSERT INTO `permissions` VALUES (7, '商家查询', 'merchant:query', 1, 1);
INSERT INTO `permissions` VALUES (8, '商家添加', 'merchant:add', 1, 1);
INSERT INTO `permissions` VALUES (9, '商家修改', 'merchant:update', 1, 1);
INSERT INTO `permissions` VALUES (10, '商家下架', 'merchant:delete', 1, 1);
INSERT INTO `permissions` VALUES (11, '安装员管理', '/installer/**', 1, 1);
INSERT INTO `permissions` VALUES (12, '安装员增加', 'installer:add', 1, 1);
INSERT INTO `permissions` VALUES (13, '安装员封禁', 'installer:delete', 1, 1);
INSERT INTO `permissions` VALUES (14, '安装员修改', 'installer:update', 1, 1);
INSERT INTO `permissions` VALUES (15, '安装员查询', 'installer:query', 1, 1);
INSERT INTO `permissions` VALUES (16, '管理员管理', '/admin/**', 1, 1);
INSERT INTO `permissions` VALUES (17, '管理员查询', 'admin:query', 1, 1);
INSERT INTO `permissions` VALUES (18, '管理员添加', 'admin:add', 1, 1);
INSERT INTO `permissions` VALUES (19, '管理员封禁', 'admin:delete', 1, 1);
INSERT INTO `permissions` VALUES (20, '管理员修改', 'admin:update', 1, 1);
INSERT INTO `permissions` VALUES (21, '商品管理', '/product/**', 1, 1);
INSERT INTO `permissions` VALUES (22, '商品添加', 'product:add', 1, 1);
INSERT INTO `permissions` VALUES (23, '商品删除', 'product:delete', 1, 1);
INSERT INTO `permissions` VALUES (24, '商品修改', 'product:update', 1, 1);
INSERT INTO `permissions` VALUES (25, '商品查询', 'product:query', 1, 1);
INSERT INTO `permissions` VALUES (26, '订单管理', '/order/**', 1, 1);
INSERT INTO `permissions` VALUES (27, '订单查询', 'order:query', 1, 1);
INSERT INTO `permissions` VALUES (28, '订单增加', 'order:add', 1, 1);
INSERT INTO `permissions` VALUES (29, '订单删除', 'order:delete', 1, 1);
INSERT INTO `permissions` VALUES (30, '订单修改', 'order:update', 1, 1);
INSERT INTO `permissions` VALUES (31, '分类管理', '/pc/**', 1, 1);
INSERT INTO `permissions` VALUES (32, '分类增加', 'pc:add', 1, 1);
INSERT INTO `permissions` VALUES (33, '分类删除', 'pc:delete', 1, 1);
INSERT INTO `permissions` VALUES (34, '分类修改', 'pc:update', 1, 1);
INSERT INTO `permissions` VALUES (35, '分类查询', 'pc:query', 1, 1);
INSERT INTO `permissions` VALUES (36, '评论管理', '/review/**', 1, 1);
INSERT INTO `permissions` VALUES (37, '评论增加', 'review:add', 1, 1);
INSERT INTO `permissions` VALUES (38, '评论删除', 'review:delete', 1, 1);
INSERT INTO `permissions` VALUES (39, '评论修改', 'review:update', 1, 1);
INSERT INTO `permissions` VALUES (40, '评论查询', 'review:query', 1, 1);
INSERT INTO `permissions` VALUES (41, '任务管理', '/task/**', 1, 1);
INSERT INTO `permissions` VALUES (42, '任务增加', 'task:add', 1, 1);
INSERT INTO `permissions` VALUES (43, '任务删除', 'task:delete', 1, 1);
INSERT INTO `permissions` VALUES (44, '任务修改', 'task:update', 1, 1);
INSERT INTO `permissions` VALUES (45, '任务查询', 'task:query', 1, 1);
INSERT INTO `permissions` VALUES (46, '用户管理', '/user/**', 1, 1);
INSERT INTO `permissions` VALUES (47, '用户增加', 'user:add', 1, 1);
INSERT INTO `permissions` VALUES (48, '用户删除', 'user:delete', 1, 1);
INSERT INTO `permissions` VALUES (49, '用户修改', 'user:update', 1, 1);
INSERT INTO `permissions` VALUES (50, '用户查询', 'user:query', 1, 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `merchant_id` int NULL DEFAULT NULL,
  `category_id` int NULL DEFAULT NULL,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `merchant_id`(`merchant_id` ASC) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 494948355 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 1, 1, '1', '1', 1.00, 1, NULL, NULL, '1');
INSERT INTO `product` VALUES (2, 123, 123, '123', '43', 54.00, 45, NULL, NULL, '123');

-- ----------------------------
-- Table structure for product_categories
-- ----------------------------
DROP TABLE IF EXISTS `product_categories`;
CREATE TABLE `product_categories`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parent_category_id` int NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`) USING BTREE,
  INDEX `parent_category_id`(`parent_category_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_categories
-- ----------------------------

-- ----------------------------
-- Table structure for reviews
-- ----------------------------
DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews`  (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NULL DEFAULT NULL,
  `customer_id` int NULL DEFAULT NULL,
  `review_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `rating` int NULL DEFAULT NULL,
  `review_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`review_id`) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  INDEX `customer_id`(`customer_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reviews
-- ----------------------------
INSERT INTO `reviews` VALUES (1, 1, 1, '1', 1, '2023-07-02 14:23:07');

-- ----------------------------
-- Table structure for role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions`  (
  `relation_id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NULL DEFAULT NULL,
  `permission_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`relation_id`) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  INDEX `permission_id`(`permission_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permissions
-- ----------------------------
INSERT INTO `role_permissions` VALUES (1, 1, 1);
INSERT INTO `role_permissions` VALUES (2, 1, 2);
INSERT INTO `role_permissions` VALUES (3, 1, 3);
INSERT INTO `role_permissions` VALUES (4, 1, 4);
INSERT INTO `role_permissions` VALUES (5, 1, 5);
INSERT INTO `role_permissions` VALUES (6, 1, 6);
INSERT INTO `role_permissions` VALUES (7, 1, 7);
INSERT INTO `role_permissions` VALUES (8, 1, 8);
INSERT INTO `role_permissions` VALUES (9, 1, 9);
INSERT INTO `role_permissions` VALUES (10, 1, 10);
INSERT INTO `role_permissions` VALUES (11, 1, 11);
INSERT INTO `role_permissions` VALUES (12, 1, 12);
INSERT INTO `role_permissions` VALUES (13, 1, 13);
INSERT INTO `role_permissions` VALUES (14, 1, 14);
INSERT INTO `role_permissions` VALUES (15, 1, 15);
INSERT INTO `role_permissions` VALUES (23, 1, 21);
INSERT INTO `role_permissions` VALUES (24, 1, 22);
INSERT INTO `role_permissions` VALUES (25, 1, 23);
INSERT INTO `role_permissions` VALUES (26, 1, 24);
INSERT INTO `role_permissions` VALUES (27, 1, 25);
INSERT INTO `role_permissions` VALUES (28, 1, 26);
INSERT INTO `role_permissions` VALUES (29, 1, 27);
INSERT INTO `role_permissions` VALUES (30, 1, 28);
INSERT INTO `role_permissions` VALUES (31, 1, 29);
INSERT INTO `role_permissions` VALUES (32, 1, 30);
INSERT INTO `role_permissions` VALUES (33, 1, 31);
INSERT INTO `role_permissions` VALUES (34, 1, 32);
INSERT INTO `role_permissions` VALUES (35, 1, 33);
INSERT INTO `role_permissions` VALUES (36, 1, 34);
INSERT INTO `role_permissions` VALUES (37, 1, 35);
INSERT INTO `role_permissions` VALUES (38, 1, 36);
INSERT INTO `role_permissions` VALUES (39, 1, 37);
INSERT INTO `role_permissions` VALUES (40, 1, 38);
INSERT INTO `role_permissions` VALUES (41, 1, 39);
INSERT INTO `role_permissions` VALUES (42, 1, 40);
INSERT INTO `role_permissions` VALUES (43, 1, 41);
INSERT INTO `role_permissions` VALUES (44, 1, 42);
INSERT INTO `role_permissions` VALUES (45, 1, 43);
INSERT INTO `role_permissions` VALUES (46, 1, 4);
INSERT INTO `role_permissions` VALUES (47, 1, 45);
INSERT INTO `role_permissions` VALUES (48, 2, 21);
INSERT INTO `role_permissions` VALUES (49, 2, 22);
INSERT INTO `role_permissions` VALUES (50, 2, 23);
INSERT INTO `role_permissions` VALUES (51, 2, 24);
INSERT INTO `role_permissions` VALUES (52, 2, 25);
INSERT INTO `role_permissions` VALUES (53, 2, 26);
INSERT INTO `role_permissions` VALUES (54, 2, 27);
INSERT INTO `role_permissions` VALUES (55, 2, 28);
INSERT INTO `role_permissions` VALUES (56, 2, 29);
INSERT INTO `role_permissions` VALUES (57, 2, 30);
INSERT INTO `role_permissions` VALUES (58, 2, 31);
INSERT INTO `role_permissions` VALUES (59, 2, 32);
INSERT INTO `role_permissions` VALUES (60, 2, 33);
INSERT INTO `role_permissions` VALUES (61, 2, 34);
INSERT INTO `role_permissions` VALUES (62, 2, 35);
INSERT INTO `role_permissions` VALUES (63, 2, 36);
INSERT INTO `role_permissions` VALUES (64, 2, 37);
INSERT INTO `role_permissions` VALUES (65, 2, 38);
INSERT INTO `role_permissions` VALUES (66, 2, 39);
INSERT INTO `role_permissions` VALUES (67, 2, 40);
INSERT INTO `role_permissions` VALUES (68, 3, 25);
INSERT INTO `role_permissions` VALUES (69, 3, 27);
INSERT INTO `role_permissions` VALUES (70, 3, 35);
INSERT INTO `role_permissions` VALUES (71, 3, 37);
INSERT INTO `role_permissions` VALUES (72, 3, 38);
INSERT INTO `role_permissions` VALUES (73, 3, 39);
INSERT INTO `role_permissions` VALUES (74, 3, 40);
INSERT INTO `role_permissions` VALUES (75, 3, 6);
INSERT INTO `role_permissions` VALUES (76, 3, 15);
INSERT INTO `role_permissions` VALUES (77, 4, 6);
INSERT INTO `role_permissions` VALUES (78, 4, 25);
INSERT INTO `role_permissions` VALUES (79, 4, 26);
INSERT INTO `role_permissions` VALUES (80, 4, 27);
INSERT INTO `role_permissions` VALUES (81, 4, 28);
INSERT INTO `role_permissions` VALUES (82, 4, 29);
INSERT INTO `role_permissions` VALUES (83, 4, 30);
INSERT INTO `role_permissions` VALUES (84, 4, 36);
INSERT INTO `role_permissions` VALUES (85, 4, 37);
INSERT INTO `role_permissions` VALUES (86, 4, 38);
INSERT INTO `role_permissions` VALUES (87, 4, 39);
INSERT INTO `role_permissions` VALUES (88, 4, 40);
INSERT INTO `role_permissions` VALUES (89, 4, 41);
INSERT INTO `role_permissions` VALUES (90, 4, 42);
INSERT INTO `role_permissions` VALUES (91, 4, 43);
INSERT INTO `role_permissions` VALUES (92, 4, 44);
INSERT INTO `role_permissions` VALUES (93, 4, 45);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '管理员');
INSERT INTO `roles` VALUES (2, '商家');
INSERT INTO `roles` VALUES (3, '顾客');
INSERT INTO `roles` VALUES (4, '安装员');
INSERT INTO `roles` VALUES (5, '超级管理员');

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks`  (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `installer_id` int NULL DEFAULT NULL,
  `order_id` int NULL DEFAULT NULL,
  `task_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `task_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `due_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `installer_id`(`installer_id` ASC) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tasks
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT 3,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date_of_birth` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `enabled` int NULL DEFAULT 1 COMMENT '是否启用账户0禁用，1启用',
  `account_no_expired` int NULL DEFAULT 1 COMMENT '账户是否没有过期0已过期 1 正常',
  `credentials_no_expired` int NULL DEFAULT 1 COMMENT '密码是否没有过期0已过期 1 正常',
  `account_no_locked` int NULL DEFAULT 1 COMMENT '账户是否没有锁定0已锁定 1 正常',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE COMMENT '用户名',
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188755971 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'dingZ302116', '123456', 1, 'zhangsan', '1234566', 'abdibsav', '123899162@email.com', '男', '2023-07-01 14:13:40', '2023-07-01 14:13:40', '1234354', 1, 1, 1, 1);
INSERT INTO `users` VALUES (188755970, 'zhangsan', '123456', 3, 'zhangsan', '13639234704', '山东省淄博市', '3112371994@qq.com', '男', '2023-07-01 19:07:20', '2023-07-01 19:07:20', NULL, 1, 1, 1, 1);
INSERT INTO `users` VALUES (1916956673, 'wangwu', '$2a$10$e6aGbLWivy36hPJfzQu7pey/NWj2y6vE/EhbwFUT7CYOAaoteWTMy', 3, 'zhangsan', '13639234704', '山东省淄博市', '3112371994@qq.com', '男', '2023-07-02 13:40:41', '2023-07-02 13:40:41', NULL, 1, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
