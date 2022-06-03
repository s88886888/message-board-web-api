/*
 Navicat Premium Data Transfer

 Source Server         : long
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 47.100.39.148:3306
 Source Schema         : messageboard_database

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 01/06/2022 00:02:25
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '车厘子真好吃', '2022-05-28 21:36:21', 'Linson', 1, '今天出门买了一袋车厘子，针不错啊。', 'https://img1.imgtp.com/2022/05/28/iBEWdmQ0.jpg', 0);
INSERT INTO `article` VALUES (2, '♥嘿嘿嘿♥', '2022-05-28 21:50:09', 'Linson', 1, '✨你眼里不只是有星星大概是装了整个银河系。', 'https://img1.imgtp.com/2022/05/28/zAG8VjEf.jpeg', 0);
INSERT INTO `article` VALUES (3, '街头灯影里藏着的某某', '2022-05-28 21:53:43', 'Linson', 1, '有一个夜晚我烧毁了所有的记忆，从此我的梦就透明了；有一个早晨我扔掉了所有的昨天，从此我的脚步就轻盈了。 ', 'https://img1.imgtp.com/2022/05/28/T55ojtoD.jpeg', 0);
INSERT INTO `article` VALUES (4, '哦哦', '2022-05-28 21:54:36', 'Linson', 1, '生气归生气，又不是不喜欢你了。', 'https://img1.imgtp.com/2022/05/28/C6NnsDX5.jpeg', 0);
INSERT INTO `article` VALUES (5, '泡面达人', '2022-05-28 21:55:47', 'Linson', 1, '泡面真的是无敌好吃哇。1', 'https://img1.imgtp.com/2022/05/28/GJ9jKA9B.jpeg', 0);
INSERT INTO `article` VALUES (6, '嘿嘿', '2022-05-28 21:58:33', 'Linson', 1, '「覅䣈歀糣鬻喜欢你龒㼭悫厵」你看，我除了喜欢你，什么都不会', 'https://img1.imgtp.com/2022/05/29/v11Ld4VO.gif', 0);
INSERT INTO `article` VALUES (7, '草莓果酱', '2022-05-28 22:00:16', 'Linson', 1, '\"言与司合,安上已脱,芝芙草拔。\"', 'https://img1.imgtp.com/2022/05/28/erBrI9DZ.gif', 0);
INSERT INTO `article` VALUES (8, '天上的星星', '2022-05-28 22:01:39', 'Linson', 1, '你对我来说，就像天上的星星，然后你从天上掉了下来，掉到了我怀里。我想把你藏进我的心里，不知道你愿意不愿意', 'https://img1.imgtp.com/2022/05/28/Q9NiMIfh.gif', 0);
INSERT INTO `article` VALUES (9, '藏头诗', '2022-05-28 22:02:54', 'Linson', 1, '我拿出一张纸，想写些什么字，你会不会发现这是首藏头诗？1', 'https://img1.imgtp.com/2022/05/28/iBhvPhgG.gif', 0);
INSERT INTO `article` VALUES (10, '新人报道', '2022-05-28 22:05:20', 'boy', 32, '第一次玩这个晚风留言，萌新求带带', 'https://img1.imgtp.com/2022/05/28/IU8Y62AO.jpg', 0);
INSERT INTO `article` VALUES (11, '拍照记得插袋', '2022-05-28 22:06:51', 'boy', 32, '任何地方也像开四面台着最闪的衫 扮十分感慨有人来拍照要记住插袋。', 'https://img1.imgtp.com/2022/05/28/QDQo9fDG.jpg', 0);
INSERT INTO `article` VALUES (12, '三食堂开业', '2022-05-28 22:09:13', 'boy', 32, '今天就来试试吃吃看，这个葱油拌面好不好吃。1', 'https://img1.imgtp.com/2022/05/28/FG6Lc1wf.jpg', 0);
INSERT INTO `article` VALUES (13, '日记', '2022-05-28 22:13:19', 'boy', 32, '今天我还是照常给你发消息，汇报日常工作，你终于回了我四个字：“嗯嗯，好的”你开始愿意敷衍我了，我太感动了受宠若惊。我愿意天天给你发消息。就算你天天骂我，我也不觉得烦。', 'https://img1.imgtp.com/2022/05/28/5AVbfmkL.gif', 0);
INSERT INTO `article` VALUES (157, '花', '2022-05-29 00:45:30', '李巨', 33, '月亮是我抛的硬币，两面都是梦见你。', 'https://img1.imgtp.com/2022/05/29/GDCCLeex.jpg', 0);
INSERT INTO `article` VALUES (158, '等', '2022-05-29 00:46:18', '李巨', 33, '等一个人久了，也就那样了', 'https://img1.imgtp.com/2022/05/29/JH042CCB.jpg', 0);
INSERT INTO `article` VALUES (159, '运气', '2022-05-29 00:47:02', '李巨', 33, '我的运气只到遇见你，接下来的，就要自己努力了。', 'https://img1.imgtp.com/2022/05/29/Q0CiSz5U.jpg', 0);
INSERT INTO `article` VALUES (160, '等待', '2022-05-29 00:48:08', '李巨', 33, '你说你七点会来，那我就会一直等待', 'https://img1.imgtp.com/2022/05/29/9GPaEA03.jpg', 0);
INSERT INTO `article` VALUES (161, '星星✨', '2022-05-29 00:48:41', '李巨', 33, '宇宙中的一颗星星✨ 都不及你的眼，因为因为你眼中有星辰大海啊', 'https://img1.imgtp.com/2022/05/29/AZD210Xp.jpg', 0);
INSERT INTO `article` VALUES (162, '爱你', '2022-05-29 00:49:25', '李巨', 33, '不要忧愁老之将至，你老了一定很可爱。而且，假如你老了十岁，我当然也同样老了十岁，世界也老了十岁，上帝也老了十岁，一切都还是一样。我只愿意凭着一点灵感的相通，时时带给彼此以慰藉，像流星的光辉，照耀我疲惫的梦寐，永远存一个安慰，纵然在离别的时候，醒来觉得甚是爱你', 'https://img1.imgtp.com/2022/05/29/an4lE2Bz.jpg', 0);
INSERT INTO `article` VALUES (163, '充电宝', '2022-05-29 00:50:47', '李巨', 33, '真无语 咋长成这样了 太好看了吧 美哭了', 'https://img1.imgtp.com/2022/05/29/sb4CEgDM.jpg', 0);
INSERT INTO `article` VALUES (164, '年少少年', '2022-05-29 00:51:39', '李巨', 33, '我年少偶然识得人间绝色，见水不是水是水光潋滟，见山不是山是水色空蒙，见你不是你，是西子，是风雨同舟者。', 'https://img1.imgtp.com/2022/05/29/Q0CiSz5U.jpg', 0);
INSERT INTO `article` VALUES (165, '只随你。', '2022-05-29 00:52:18', '李巨', 33, '万人皆随心随性，而我只随你。', 'https://img1.imgtp.com/2022/05/29/rhioSXUg.jpg', 0);
INSERT INTO `article` VALUES (166, '《登柳州峨山》', '2022-05-29 00:55:24', '李巨', 33, '荒山秋日午，独上意悠悠。如何望乡处，西北是融州。', 'https://img1.imgtp.com/2022/05/29/zggjZ6BT.jpg', 0);
INSERT INTO `article` VALUES (167, '我只随你', '2022-05-29 01:32:58', '渣男', 34, '说星星好看的人一定没有看过你的眼睛 ✨✨', 'https://img1.imgtp.com/2022/05/29/8oYrXzBV.gif', 0);
INSERT INTO `article` VALUES (168, '     GD', '2022-05-29 01:38:56', '渣男', 34, '我会喜欢你，直到我数学满分。', 'https://img1.imgtp.com/2022/05/29/fN2YHj9s.gif', 0);
INSERT INTO `article` VALUES (169, '你最珍贵', '2022-05-29 01:47:58', '渣男', 34, '打印一张你的照片放在口袋，今天我就是身藏巨款的人，你最珍贵', 'https://img1.imgtp.com/2022/05/29/B7l6ZKFx.gif', 0);
INSERT INTO `article` VALUES (170, '太阳见了你', '2022-05-29 01:48:24', '渣男', 34, '今天为什么是阴天？因为太阳见了你，害羞的躲进了云朵', 'https://img1.imgtp.com/2022/05/29/9H3rh5rJ.jpeg', 0);
INSERT INTO `article` VALUES (171, '都知道你', '2022-05-29 01:55:47', '渣男', 34, '我算不上低调 但也不喜欢炫耀 却想让每个认识我的人都知道你。', 'https://img1.imgtp.com/2022/05/29/PJOrDJ3h.jpeg', 0);
INSERT INTO `article` VALUES (172, '我喜欢你', '2022-05-29 01:57:03', '渣男', 34, '“我喜欢你”这句话有点重先撂这儿了你帮我拿一下​', 'https://img1.imgtp.com/2022/05/29/2iC0a0ZU.jpeg', 0);
INSERT INTO `article` VALUES (173, '微笑的模样', '2022-05-29 01:57:22', '渣男', 34, '我想用手掌里紧握的温暖，托住时光里微笑的模样。', 'https://img1.imgtp.com/2022/05/29/pFyU5iZY.jpeg', 0);
INSERT INTO `article` VALUES (174, '你想知道', '2022-05-29 02:23:22', 'Linson', 1, '你想知道我对你的爱情是什么吗？就是从心底里喜欢你，觉得你的一举一动都和亲切，不高兴你比喜欢我更喜欢别人。你要是喜欢别人我会哭，但是还是喜欢你。 ——王小波', 'https://img1.imgtp.com/2022/05/29/hl7lMFuN.jpeg', 0);
INSERT INTO `article` VALUES (175, '温柔', '2022-05-29 02:25:54', 'Linson', 1, '这个世界从来都不温柔，还好，我有你', 'https://img1.imgtp.com/2022/05/29/MEkDcZkE.jpeg', 0);
INSERT INTO `article` VALUES (176, '愿意', '2022-05-29 02:26:47', '李巨', 33, '我和你跨过分秒，愿也可以跨过余生岁月', 'https://img1.imgtp.com/2022/05/29/AhElxecw.jpg', 0);
INSERT INTO `article` VALUES (177, '难过的就不会是我', '2022-05-29 02:27:22', '李巨', 33, '只要我足够冷漠 难过的就不会是我', 'https://img1.imgtp.com/2022/05/29/KfjHPKcH.jpg', 0);
INSERT INTO `article` VALUES (178, '张爱玲《更衣记》', '2022-05-29 02:28:34', '李巨', 33, '回忆这东西若是有气味的话，那就是樟脑的香，甜而稳妥，像记得分明的快乐，甜而怅惘，像忘却了的忧愁。- 张爱玲《更衣记》', 'https://img1.imgtp.com/2022/05/29/atss0d2V.jpg', 0);
INSERT INTO `article` VALUES (179, '........', '2022-05-29 02:38:11', '爱龙', 43, 'ʕ̯•͡˔•̯᷅ʔ ᐝ', 'https://img1.imgtp.com/2022/05/29/TJu35EbI.gif', 0);
INSERT INTO `article` VALUES (180, 'IU', '2022-05-29 02:42:14', '爱龙', 43, 'ᴛʜʀᴏᴡ ᴀᴡᴀʏ ʏᴇꜱᴛᴇʀᴅᴀʏ ᴀɴᴅ ᴍᴀᴋᴇ ᴇᴠᴇʀʏ ᴅᴀʏ ʟɪɢʜᴛ ˙˘˙', 'https://img1.imgtp.com/2022/05/29/IEapRzUh.gif', 0);
INSERT INTO `article` VALUES (181, 'IU', '2022-05-29 02:42:43', '爱龙', 43, 'ᴛʜʀᴏᴡ ᴀᴡᴀʏ ʏᴇꜱᴛᴇʀᴅᴀʏ ᴀɴᴅ ᴍᴀᴋᴇ ᴇᴠᴇʀʏ ᴅᴀʏ ʟɪɢʜᴛ ˙˘˙', 'https://img1.imgtp.com/2022/05/29/LXcBrEVF.jpeg', 0);
INSERT INTO `article` VALUES (182, 'IU', '2022-05-29 02:44:51', '爱龙', 43, '你在我心里，就像天上的星星，多一颗少一颗都无所谓。', 'https://img1.imgtp.com/2022/05/29/s4bQznD4.gif', 0);
INSERT INTO `article` VALUES (183, '位置', '2022-05-29 02:45:50', '爱龙', 43, '不能老盯着手机屏幕，要不时地抬起头，看看老板的位置。', 'https://img1.imgtp.com/2022/05/29/QKuWv6TR.gif', 0);
INSERT INTO `article` VALUES (184, '草莓果酱OX', '2022-05-29 02:51:05', 'boy', 32, '只是因为在人群中，多看了你一眼，你就以为我要坐你的摩的。', 'https://img1.imgtp.com/2022/05/29/swjSJLcH.gif', 0);
INSERT INTO `article` VALUES (185, '草莓果酱OX', '2022-05-29 02:51:46', 'boy', 32, '如果全世界都不要你了，你要记得还有我，我也不要你。', 'https://img1.imgtp.com/2022/05/29/ZIrpxkBi.gif', 0);
INSERT INTO `article` VALUES (186, '43434', '2022-05-29 13:57:40', '3123', 44, '4343423423432', 'https://img1.imgtp.com/2022/05/29/rIlZZTje.jpeg', 0);
INSERT INTO `article` VALUES (187, '时间，空间，留影', '2022-05-29 15:02:07', '李明峻', 45, '照片是一种很特殊的东西，它跨越了时间，跨越了空间，当你举起摄影机的时候，你就把这段时间、这个空间，给留了下来，我享受留住时间的感觉，这是神应该有的能力，但我们现在都有。', 'https://img1.imgtp.com/2022/05/29/IR5URfSo.jpg', 0);
INSERT INTO `article` VALUES (189, '122346', '2022-05-29 16:15:28', '帅成马', 46, '党建党建党建军说你手机的鸡蛋鸡', 'https://img1.imgtp.com/2022/05/29/3mrRSLC8.gif', 0);
INSERT INTO `article` VALUES (192, '今天吃什么', '2022-05-30 08:35:50', 'boy1', 32, '今天吃葱油拌面今天吃葱油拌面今天吃葱油拌面', 'https://img1.imgtp.com/2022/05/29/atss0d2V.jpg', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Linson', '17677275020', '123456', '854700937@qq.com', 'https://img1.imgtp.com/2022/05/30/3nGty6m1.jpg');
INSERT INTO `user` VALUES (32, 'boy1', '17677275033', '123456', '854700937@qq.com', 'https://img1.imgtp.com/2022/05/28/oImJqYva.jpg');
INSERT INTO `user` VALUES (33, '李巨', '17677275044', '123456', '8588@qq.com', 'https://img1.imgtp.com/2022/05/28/bBEBQAno.jpg');
INSERT INTO `user` VALUES (34, '渣男', '17677275055', '123456', '7788@qq.com', 'https://img1.imgtp.com/2022/05/29/8M1lHYip.jpg');
INSERT INTO `user` VALUES (43, '爱龙', '17677275066', '123456', '123@qq.com', 'https://img1.imgtp.com/2022/05/29/iMtfR9KX.jpg');
INSERT INTO `user` VALUES (44, '刘工', '13333333333', '123456', '23211@qq.com', 'https://img1.imgtp.com/2022/05/29/g8ZtiqtT.png');
INSERT INTO `user` VALUES (45, '李明峻', '13877634306', 'Pencil0330', 'limingjun0330@tencilpencil.cn', 'https://img1.imgtp.com/2022/05/29/bAbTvsKj.jpg');
INSERT INTO `user` VALUES (46, '帅成马啊', '13377589456', '123456', '1173260230@qq.com', 'https://img1.imgtp.com/2022/05/29/T2vcuxVv.jpg');

SET FOREIGN_KEY_CHECKS = 1;
