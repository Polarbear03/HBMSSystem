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

 Date: 27/06/2023 17:01:07
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
  `role_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`  (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date_of_birth` date NULL DEFAULT NULL,
  `registration_date` date NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customers_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for installers
-- ----------------------------
DROP TABLE IF EXISTS `installers`;
CREATE TABLE `installers`  (
  `installer_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`installer_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchants
-- ----------------------------
DROP TABLE IF EXISTS `merchants`;
CREATE TABLE `merchants`  (
  `merchant_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  `merchant_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_license_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `registration_date` date NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `merchants_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `merchants_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `order_detail_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NULL DEFAULT NULL,
  `product_id` int NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `unit_price` decimal(10, 2) NULL DEFAULT NULL,
  `discount` decimal(5, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  INDEX `product_id`(`product_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NULL DEFAULT NULL,
  `merchant_id` int NULL DEFAULT NULL,
  `order_date` date NULL DEFAULT NULL,
  `order_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `payment_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total_amount` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `customer_id`(`customer_id` ASC) USING BTREE,
  INDEX `merchant_id`(`merchant_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `update_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_categories
-- ----------------------------
DROP TABLE IF EXISTS `product_categories`;
CREATE TABLE `product_categories`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parent_category_id` int NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `create_date` date NULL DEFAULT NULL,
  `update_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE,
  INDEX `parent_category_id`(`parent_category_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `merchant_id` int NULL DEFAULT NULL,
  `category_id` int NULL DEFAULT NULL,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `update_date` date NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `merchant_id`(`merchant_id` ASC) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
  `review_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  INDEX `customer_id`(`customer_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
  `create_date` date NULL DEFAULT NULL,
  `due_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `installer_id`(`installer_id` ASC) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tz_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tz_sys_menu`;
CREATE TABLE `tz_sys_menu`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contact` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date_of_birth` date NULL DEFAULT NULL,
  `registration_date` date NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
