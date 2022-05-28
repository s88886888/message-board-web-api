/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : messageboard_database

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/05/2022 23:38:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', '2022-05-21 14:02:38');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `articlename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` datetime NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `authorid` int NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `likecount` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `authorid`(`authorid`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 157 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '车厘子真好吃', '2022-05-28 21:36:21', 'Linson', 1, '今天出门买了一袋车厘子，针不错啊。', 'https://img1.imgtp.com/2022/05/28/iBEWdmQ0.jpg', 0);
INSERT INTO `article` VALUES (2, '♥嘿嘿♥', '2022-05-28 21:50:09', 'Linson', 1, '✨你眼里不只是有星星大概是装了整个银河系。', 'https://img1.imgtp.com/2022/05/28/zAG8VjEf.jpeg', 0);
INSERT INTO `article` VALUES (3, '街头灯影里藏着的某某', '2022-05-28 21:53:43', 'Linson', 1, '有一个夜晚我烧毁了所有的记忆，从此我的梦就透明了；有一个早晨我扔掉了所有的昨天，从此我的脚步就轻盈了。 ——泰戈尔', 'https://img1.imgtp.com/2022/05/28/T55ojtoD.jpeg', 0);
INSERT INTO `article` VALUES (4, '哦', '2022-05-28 21:54:36', 'Linson', 1, '生气归生气，又不是不喜欢你了', 'https://img1.imgtp.com/2022/05/28/C6NnsDX5.jpeg', 0);
INSERT INTO `article` VALUES (5, '泡面达人', '2022-05-28 21:55:47', 'Linson', 1, '泡面真的是无敌好吃哇', 'https://img1.imgtp.com/2022/05/28/GJ9jKA9B.jpeg', 0);
INSERT INTO `article` VALUES (6, '嘿嘿', '2022-05-28 21:58:33', 'Linson', 1, '「覅䣈歀糣鬻喜欢你龒㼭悫厵」你看，我除了喜欢你，什么都不会', 'https://img1.imgtp.com/2022/05/28/EUGbY597.jpeg', 0);
INSERT INTO `article` VALUES (7, '草莓果酱', '2022-05-28 22:00:16', 'Linson', 1, '\"言与司合,安上已脱,芝芙草拔。\"', 'https://img1.imgtp.com/2022/05/28/erBrI9DZ.gif', 0);
INSERT INTO `article` VALUES (8, '天上的星星', '2022-05-28 22:01:39', 'Linson', 1, '你对我来说，就像天上的星星，然后你从天上掉了下来，掉到了我怀里。我想把你藏进我的心里，不知道你愿意不愿意？', 'https://img1.imgtp.com/2022/05/28/Q9NiMIfh.gif', 0);
INSERT INTO `article` VALUES (9, '藏头诗', '2022-05-28 22:02:54', 'Linson', 1, '我拿出一张纸，想写些什么字，你会不会发现这是首藏头诗？', 'https://img1.imgtp.com/2022/05/28/iBhvPhgG.gif', 0);
INSERT INTO `article` VALUES (10, '新人报道', '2022-05-28 22:05:20', 'boy', 32, '第一次玩这个晚风留言，萌新求带带', 'https://img1.imgtp.com/2022/05/28/IU8Y62AO.jpg', 0);
INSERT INTO `article` VALUES (11, '拍照记得插袋', '2022-05-28 22:06:51', 'boy', 32, '任何地方也像开四面台着最闪的衫 扮十分感慨有人来拍照要记住插袋。', 'https://img1.imgtp.com/2022/05/28/QDQo9fDG.jpg', 0);
INSERT INTO `article` VALUES (12, '三食堂开业了', '2022-05-28 22:09:13', 'boy', 32, '今天就来试试吃吃看，这个葱油拌面好不好吃。', 'https://img1.imgtp.com/2022/05/28/FG6Lc1wf.jpg', 0);
INSERT INTO `article` VALUES (13, '日记', '2022-05-28 22:13:19', 'boy', 32, '今天我还是照常给你发消息，汇报日常工作，你终于回了我四个字：“嗯嗯，好的”你开始愿意敷衍我了，我太感动了受宠若惊。我愿意天天给你发消息。就算你天天骂我，我也不觉得烦。', 'https://img1.imgtp.com/2022/05/28/5AVbfmkL.gif', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Linson', '17677275020', '123456', '854700937@qq.com', 'https://img1.imgtp.com/2022/05/28/UNH8tZsM.jpg');
INSERT INTO `user` VALUES (32, 'boy', '17677275033', '123456', '854700937@qq.com', 'https://img1.imgtp.com/2022/05/28/oImJqYva.jpg');
INSERT INTO `user` VALUES (33, '李巨', '17677275044', '123456', '8588@qq.com', 'https://img1.imgtp.com/2022/05/28/bBEBQAno.jpg');
INSERT INTO `user` VALUES (34, '渣男', '17677275055', '123456', '7788@qq.com', NULL);

SET FOREIGN_KEY_CHECKS = 1;
