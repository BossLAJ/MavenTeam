/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : bawei

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 26/06/2019 12:35:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(144) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hits` int(11) NULL DEFAULT NULL,
  `hot` bit(1) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT NULL,
  `created` datetime NULL DEFAULT NULL,
  `updated` datetime NULL DEFAULT NULL,
  `channel_id` int(11) NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_lfkytqlwoutq98g8j5f4ci62h`(`channel_id`) USING BTREE,
  INDEX `FK_2t7t521ow9c08uqbd9p11fsq4`(`category_id`) USING BTREE,
  INDEX `FK_p9jh9l0c468m5fxtcp1bcv3a6`(`user_id`) USING BTREE,
  CONSTRAINT `FK_2t7t521ow9c08uqbd9p11fsq4` FOREIGN KEY (`category_id`) REFERENCES `cms_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_lfkytqlwoutq98g8j5f4ci62h` FOREIGN KEY (`channel_id`) REFERENCES `cms_channel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_p9jh9l0c468m5fxtcp1bcv3a6` FOREIGN KEY (`user_id`) REFERENCES `cms_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES (1, '惊人的大数据画像', '大数据，一直被认为是互联网公司的金矿', '<p>大数据，一直被认为是互联网公司的金矿，其多次利用潜力深不可测。所以基于市场调研或收集的相关数据，通过科学论断分析后，其显示出来的惊人画像有时准确的让人害怕。</p>', '/upload/2afd6aca2c4147d0b34c31184c67569d.jpg', 96, b'1', 1, b'0', '2019-04-10 23:32:21', '2019-04-23 23:32:24', 1, 2, 1);
INSERT INTO `cms_article` VALUES (2, 'java', 'java ', 'java', NULL, 22, b'1', 1, b'0', '2019-04-16 13:59:33', '2019-04-16 13:59:36', 1, 1, 1);
INSERT INTO `cms_article` VALUES (3, '阿斯顿发生发达', 'mysqlsadfasf', '士大夫撒旦', NULL, 331, b'1', 0, b'0', '2019-04-16 14:00:05', '2019-04-16 14:00:11', 2, 5, 1);
INSERT INTO `cms_article` VALUES (4, 'js', 'js', 'js', NULL, 3, b'1', 1, b'0', '2019-04-09 14:00:34', '2019-04-16 14:00:37', 1, 3, 1);
INSERT INTO `cms_article` VALUES (5, NULL, '撒旦法', 'sdf', NULL, 3, NULL, 0, b'0', NULL, NULL, 1, 3, 1);
INSERT INTO `cms_article` VALUES (6, NULL, 'sdf', '师傅', NULL, 3, NULL, NULL, b'0', NULL, NULL, 1, 3, 1);
INSERT INTO `cms_article` VALUES (8, '中美之战', '厉害', '关于华为', '/upload/haha.jpg', 2, b'1', 1, b'0', '2019-05-27 14:53:40', NULL, NULL, NULL, 2);
INSERT INTO `cms_article` VALUES (14, 'SUV', 'bbb', 'aaa', '/upload/haha.jpg', 1, b'1', 1, b'0', '2019-05-28 13:32:43', NULL, 4, 14, 2);
INSERT INTO `cms_article` VALUES (15, '姚明', '牛X', '要命', '/upload/haha.jpg', 3, b'1', 1, b'0', '2019-05-28 13:38:50', NULL, 5, 17, 3);
INSERT INTO `cms_article` VALUES (16, 'ccc', 'eee', 'ddd', '/upload/haha.jpg', 3, b'1', 1, b'0', '2019-05-28 13:42:43', NULL, 3, 10, 3);
INSERT INTO `cms_article` VALUES (17, '111', '333', '222', '/upload/haha.jpg', 4, b'1', 1, b'0', '2019-05-28 13:45:19', NULL, 3, 10, 2);
INSERT INTO `cms_article` VALUES (21, '汽车报道', '关于汽车', '首先请求参数的格式一定的要求，老的方式是<a href=\"demo8?name=张三&age=23\">跳转</a>，\r\n\r\n而restful格式是：<a href=\"demo8/123/abc\">跳转</a>\r\n\r\n在控制器中：\r\n\r\n 在@RequestMapping 中一定要和请求格式对应\r\n {名称} 中名称自定义名称\r\n @PathVariable 获取@RequestMapping 中内容,默认按照方法参数名称去寻找.\r\n\r\n\r\n@RequestMapping(\"demo8/{id1}/{name}\")\r\npublic String demo8(@PathVariable String  name,@PathVariable(\"id1\") int age){\r\n　　System.out.println(name +\" \"+age);\r\n　　return \"/main.jsp\";\r\n}', '/upload/2.jpg', 52, b'1', 1, b'0', '2019-05-29 16:41:12', NULL, 4, 14, 2);
INSERT INTO `cms_article` VALUES (22, '', '', '', '/upload/', 45, b'1', 1, b'0', '2019-05-30 16:19:55', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (23, '', '', '', '/upload/', 5, b'1', 1, b'0', '2019-05-30 16:20:03', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (24, '1212121', '43432432', '3432432', '/upload/2.jpg', 5, b'1', 1, b'0', '2019-05-30 16:37:21', NULL, 3, 11, 1);
INSERT INTO `cms_article` VALUES (25, NULL, NULL, 'fsdfsdfsdffdsfdsfsd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cms_article` VALUES (27, '13rrrew', 'tretre', 'tretret', '/upload/2.jpg', 4, b'1', 1, b'0', '2019-05-30 16:42:54', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (28, '111111', '333', '222222', '/upload/2.jpg', 4, b'1', 1, b'0', '2019-05-30 16:47:27', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (29, 'ggggg', 'ddd', 'cccc', '/upload/2.jpg', 5, b'1', 1, b'0', '2019-05-30 16:51:41', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (30, '旅游', '222', '111', '/upload/2.jpg', 3, b'1', 1, b'0', '2019-05-30 23:48:24', NULL, 5, 18, 1);
INSERT INTO `cms_article` VALUES (31, '游戏', '222', '111', '/upload/2.jpg', 1, b'1', 1, b'0', '2019-05-30 23:49:16', NULL, 2, 1, 1);
INSERT INTO `cms_article` VALUES (32, '周考', '222', '111', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-30 23:52:27', NULL, 5, 19, 1);
INSERT INTO `cms_article` VALUES (33, '徒步111', '333', '222', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 00:01:58', NULL, 7, 26, 1);
INSERT INTO `cms_article` VALUES (34, 'ccc', '32323', '232323', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 00:05:39', NULL, 5, 20, 1);
INSERT INTO `cms_article` VALUES (35, 'aaaccc', '22', '111', '/upload/2.jpg', 5, b'1', 1, b'0', '2019-05-31 00:08:17', NULL, 5, 19, 1);
INSERT INTO `cms_article` VALUES (36, '而额外人', '222', '1111', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 09:26:26', NULL, 3, 10, 1);
INSERT INTO `cms_article` VALUES (37, 'gfdgfdgfd', 'ertretreter', 'hgfhgfhgfhgfhgf', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 09:29:00', NULL, 7, 26, 1);
INSERT INTO `cms_article` VALUES (38, '各个国家', '可以', '很多', '/upload/2.jpg', 12, b'1', 1, b'0', '2019-05-31 09:31:31', NULL, 3, 10, 1);
INSERT INTO `cms_article` VALUES (39, '1212', '43432', '23243', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 11:24:39', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (40, 'tetre', 'etretre', 'tret', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 11:25:09', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (41, 'd11', '4343', '2323', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 11:25:40', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (42, 'fghgfhgf', 'hghgh', 'hgfhgfh', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 14:13:51', NULL, 5, 20, 1);
INSERT INTO `cms_article` VALUES (43, 'b', 'eer', 'erer', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 14:21:47', NULL, 1, 2, NULL);
INSERT INTO `cms_article` VALUES (44, 'bc', '222', '1111', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 14:22:24', NULL, 2, 1, 1);
INSERT INTO `cms_article` VALUES (45, 'b', 'gfdg', 'fdsfds', '/upload/2.jpg', 0, b'1', 1, b'0', '2019-05-31 14:24:06', NULL, 1, 2, 1);
INSERT INTO `cms_article` VALUES (46, '111', '333', '222', '/upload/2.jpg', 1, b'1', 1, b'0', '2019-05-31 14:27:17', NULL, 3, 10, 1);
INSERT INTO `cms_article` VALUES (47, '汽车', '他热帖热帖', '高浮雕高浮雕高浮雕', '/upload/2.jpg', 2, b'1', 1, b'0', '2019-05-31 14:34:16', NULL, 4, 13, 2);

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sorted` int(11) NULL DEFAULT NULL,
  `channel_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ht3vk3a5838apbxow8dc6r6da`(`channel_id`) USING BTREE,
  CONSTRAINT `FK_ht3vk3a5838apbxow8dc6r6da` FOREIGN KEY (`channel_id`) REFERENCES `cms_channel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_category
-- ----------------------------
INSERT INTO `cms_category` VALUES (1, '互联网', 0, 2);
INSERT INTO `cms_category` VALUES (2, '软件', 1, 1);
INSERT INTO `cms_category` VALUES (3, '智能家居', 2, 1);
INSERT INTO `cms_category` VALUES (4, '虚拟货币', 0, 2);
INSERT INTO `cms_category` VALUES (5, '股票', 1, 2);
INSERT INTO `cms_category` VALUES (6, '外汇', 2, 2);
INSERT INTO `cms_category` VALUES (7, '黄金', 3, 2);
INSERT INTO `cms_category` VALUES (8, '宏观经济', 4, 2);
INSERT INTO `cms_category` VALUES (9, '美国', 0, 3);
INSERT INTO `cms_category` VALUES (10, '亚洲', 1, 3);
INSERT INTO `cms_category` VALUES (11, '欧洲', 2, 3);
INSERT INTO `cms_category` VALUES (12, '非洲', 3, 3);
INSERT INTO `cms_category` VALUES (13, '新车', 0, 4);
INSERT INTO `cms_category` VALUES (14, 'SUV', 1, 4);
INSERT INTO `cms_category` VALUES (15, '汽车导购', 2, 4);
INSERT INTO `cms_category` VALUES (16, '用车', 3, 4);
INSERT INTO `cms_category` VALUES (17, 'NBA', 0, 5);
INSERT INTO `cms_category` VALUES (18, 'CBA', 1, 5);
INSERT INTO `cms_category` VALUES (19, '中超', 2, 5);
INSERT INTO `cms_category` VALUES (20, '意甲', 3, 5);
INSERT INTO `cms_category` VALUES (21, '电影', 0, 6);
INSERT INTO `cms_category` VALUES (22, '电视剧', 1, 6);
INSERT INTO `cms_category` VALUES (23, '综艺', 2, 6);
INSERT INTO `cms_category` VALUES (24, '明星八卦', 3, 6);
INSERT INTO `cms_category` VALUES (25, '段子', 0, 7);
INSERT INTO `cms_category` VALUES (26, '爆笑节目', 1, 7);
INSERT INTO `cms_category` VALUES (27, '童趣萌宠', 2, 7);
INSERT INTO `cms_category` VALUES (28, '雷人囧事', 3, 7);

-- ----------------------------
-- Table structure for cms_channel
-- ----------------------------
DROP TABLE IF EXISTS `cms_channel`;
CREATE TABLE `cms_channel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sorted` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_channel
-- ----------------------------
INSERT INTO `cms_channel` VALUES (1, '科技', NULL, NULL, 0);
INSERT INTO `cms_channel` VALUES (2, '财经', NULL, NULL, 1);
INSERT INTO `cms_channel` VALUES (3, '国际', NULL, NULL, 2);
INSERT INTO `cms_channel` VALUES (4, '汽车', NULL, NULL, 3);
INSERT INTO `cms_channel` VALUES (5, '体育', NULL, NULL, 4);
INSERT INTO `cms_channel` VALUES (6, '娱乐', NULL, NULL, 5);
INSERT INTO `cms_channel` VALUES (7, '搞笑', NULL, NULL, 6);

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_id` int(11) NULL DEFAULT NULL,
  `displayTime` datetime NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
INSERT INTO `cms_comment` VALUES (7, 'aaaaaaaaa', 2, '2019-04-28 13:38:14', 1);
INSERT INTO `cms_comment` VALUES (8, 'sdfsdfa', 2, '2019-04-28 13:57:43', 1);
INSERT INTO `cms_comment` VALUES (11, 'asfdaf', 2, '2019-04-28 15:17:34', 1);
INSERT INTO `cms_comment` VALUES (12, 'asfaf', 2, '2019-04-28 15:17:42', 1);
INSERT INTO `cms_comment` VALUES (13, 'sdfsdfa', 2, '2019-04-28 15:48:55', 1);
INSERT INTO `cms_comment` VALUES (14, 'sdfsad', 1, '2019-04-28 15:53:27', 1);
INSERT INTO `cms_comment` VALUES (15, '243432v 32', 21, '2019-05-30 10:14:39', 1);
INSERT INTO `cms_comment` VALUES (16, '获救矿工的伤口高峰会上公开符合国家开放', 21, '2019-05-30 10:17:15', 1);
INSERT INTO `cms_comment` VALUES (26, '涛涛涛涛', NULL, '2019-05-30 10:38:19', 1);
INSERT INTO `cms_comment` VALUES (27, '热帖热帖', NULL, '2019-05-30 10:39:12', 1);
INSERT INTO `cms_comment` VALUES (28, '广泛大锅饭', NULL, '2019-05-30 10:40:14', 1);
INSERT INTO `cms_comment` VALUES (29, '一般化', NULL, '2019-05-30 10:47:52', 1);
INSERT INTO `cms_comment` VALUES (30, '11111', NULL, '2019-05-30 10:49:12', 1);
INSERT INTO `cms_comment` VALUES (31, '热望认为', NULL, '2019-05-30 10:51:06', 1);
INSERT INTO `cms_comment` VALUES (32, '退热退热退热', NULL, '2019-05-30 10:54:02', 1);
INSERT INTO `cms_comment` VALUES (33, '饿温热我认为', NULL, '2019-05-30 10:55:51', 1);

-- ----------------------------
-- Table structure for cms_settings
-- ----------------------------
DROP TABLE IF EXISTS `cms_settings`;
CREATE TABLE `cms_settings`  (
  `id` int(11) NOT NULL,
  `site_domain` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `site_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_list_size` int(11) NULL DEFAULT NULL,
  `slide_size` int(11) NULL DEFAULT NULL,
  `admin_username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_settings
-- ----------------------------
INSERT INTO `cms_settings` VALUES (1, 'localhost', 'CMS内容管理系', 10, 5, 'admin', '888888');

-- ----------------------------
-- Table structure for cms_slide
-- ----------------------------
DROP TABLE IF EXISTS `cms_slide`;
CREATE TABLE `cms_slide`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_slide
-- ----------------------------
INSERT INTO `cms_slide` VALUES (1, '1', '/upload/66e796c3g755eaef7edc8&690.jpg', NULL, '2019-04-10');
INSERT INTO `cms_slide` VALUES (2, '1', '/upload/66e796c3g755eaef7edc8&690.jpg', NULL, '2019-04-10');

-- ----------------------------
-- Table structure for cms_terms
-- ----------------------------
DROP TABLE IF EXISTS `cms_terms`;
CREATE TABLE `cms_terms`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 152 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_terms
-- ----------------------------
INSERT INTO `cms_terms` VALUES (41, '﻿手游');
INSERT INTO `cms_terms` VALUES (42, '网游');
INSERT INTO `cms_terms` VALUES (43, '单击');
INSERT INTO `cms_terms` VALUES (44, '徒步');
INSERT INTO `cms_terms` VALUES (45, '自驾游');
INSERT INTO `cms_terms` VALUES (46, '飞机');
INSERT INTO `cms_terms` VALUES (47, '梦游');
INSERT INTO `cms_terms` VALUES (48, 'Java编程');
INSERT INTO `cms_terms` VALUES (49, 'C编程');
INSERT INTO `cms_terms` VALUES (50, '.net编程');
INSERT INTO `cms_terms` VALUES (62, 'a');
INSERT INTO `cms_terms` VALUES (63, 'b');
INSERT INTO `cms_terms` VALUES (64, 'c');
INSERT INTO `cms_terms` VALUES (76, '飞机');
INSERT INTO `cms_terms` VALUES (77, '梦游');
INSERT INTO `cms_terms` VALUES (78, '网游');
INSERT INTO `cms_terms` VALUES (79, '﻿手游');
INSERT INTO `cms_terms` VALUES (80, 'Java编程');
INSERT INTO `cms_terms` VALUES (81, '徒步ttt');
INSERT INTO `cms_terms` VALUES (82, '﻿手');
INSERT INTO `cms_terms` VALUES (83, '徒步');
INSERT INTO `cms_terms` VALUES (84, 'aaaa');
INSERT INTO `cms_terms` VALUES (85, 'bbb');
INSERT INTO `cms_terms` VALUES (86, 'aaa');
INSERT INTO `cms_terms` VALUES (87, 'bbb');
INSERT INTO `cms_terms` VALUES (99, '呵呵');
INSERT INTO `cms_terms` VALUES (100, 'a');
INSERT INTO `cms_terms` VALUES (101, 'b');
INSERT INTO `cms_terms` VALUES (102, 'c');
INSERT INTO `cms_terms` VALUES (103, 'd');
INSERT INTO `cms_terms` VALUES (104, '美国');
INSERT INTO `cms_terms` VALUES (105, '欧洲');
INSERT INTO `cms_terms` VALUES (106, '南美洲');
INSERT INTO `cms_terms` VALUES (107, '锘挎墜娓竱缃戞父');
INSERT INTO `cms_terms` VALUES (148, 'fewwerew');
INSERT INTO `cms_terms` VALUES (149, 'SUV');
INSERT INTO `cms_terms` VALUES (150, '火车');
INSERT INTO `cms_terms` VALUES (151, '跑车');

-- ----------------------------
-- Table structure for cms_user
-- ----------------------------
DROP TABLE IF EXISTS `cms_user`;
CREATE TABLE `cms_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `locked` bit(1) NULL DEFAULT NULL,
  `created` date NOT NULL,
  `updated` date NOT NULL,
  `url_blog` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `score` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_m4o7s4w3o9o3www57522hfp8m`(`username`) USING BTREE,
  INDEX `idx_user_account`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_user
-- ----------------------------
INSERT INTO `cms_user` VALUES (1, 'test', 'efbe40026c52c653374cc758bf5b5489', 'test', NULL, 1, b'0', '2019-04-22', '2019-04-22', NULL, 20);
INSERT INTO `cms_user` VALUES (2, 'admin', '06e92d9a0557509978ed7cae61463e03', 'admin', NULL, 0, b'0', '2019-05-28', '2019-05-28', NULL, 10);
INSERT INTO `cms_user` VALUES (3, 'zhangsan', '87f435bd1aa5f9b1098ab95823d151dc', 'zhangsan', NULL, 1, b'0', '2019-05-28', '2019-05-28', NULL, NULL);
INSERT INTO `cms_user` VALUES (4, 'hjk', '7d42af1e0519982ff9d85f2f51daf1c3', 'hjk', NULL, 1, b'0', '2019-06-17', '2019-06-17', NULL, NULL);

-- ----------------------------
-- Table structure for term_article
-- ----------------------------
DROP TABLE IF EXISTS `term_article`;
CREATE TABLE `term_article`  (
  `article_id` int(11) NULL DEFAULT NULL,
  `term_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of term_article
-- ----------------------------
INSERT INTO `term_article` VALUES (1, 41);
INSERT INTO `term_article` VALUES (1, 42);
INSERT INTO `term_article` VALUES (1, 43);
INSERT INTO `term_article` VALUES (2, 41);
INSERT INTO `term_article` VALUES (2, 45);
INSERT INTO `term_article` VALUES (3, 46);
INSERT INTO `term_article` VALUES (4, 47);
INSERT INTO `term_article` VALUES (4, 48);
INSERT INTO `term_article` VALUES (5, 44);
INSERT INTO `term_article` VALUES (5, 49);
INSERT INTO `term_article` VALUES (5, 50);
INSERT INTO `term_article` VALUES (1, 86);
INSERT INTO `term_article` VALUES (1, 87);
INSERT INTO `term_article` VALUES (36, 99);
INSERT INTO `term_article` VALUES (37, 100);
INSERT INTO `term_article` VALUES (37, 101);
INSERT INTO `term_article` VALUES (37, 102);
INSERT INTO `term_article` VALUES (37, 103);
INSERT INTO `term_article` VALUES (38, 104);
INSERT INTO `term_article` VALUES (38, 105);
INSERT INTO `term_article` VALUES (38, 106);
INSERT INTO `term_article` VALUES (41, 118);
INSERT INTO `term_article` VALUES (42, 141);
INSERT INTO `term_article` VALUES (42, 142);
INSERT INTO `term_article` VALUES (42, 143);
INSERT INTO `term_article` VALUES (44, 144);
INSERT INTO `term_article` VALUES (44, 145);
INSERT INTO `term_article` VALUES (45, 146);
INSERT INTO `term_article` VALUES (46, 147);
INSERT INTO `term_article` VALUES (46, 148);
INSERT INTO `term_article` VALUES (47, 149);
INSERT INTO `term_article` VALUES (47, 150);
INSERT INTO `term_article` VALUES (47, 151);

SET FOREIGN_KEY_CHECKS = 1;
