-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`id`, `name`, `sex`, `birth`, `photo_url`) VALUES (1, 'ada', '女', '2001-01-01', 'photo/1.jpg');
INSERT INTO `student` (`id`, `name`, `sex`, `birth`, `photo_url`) VALUES (2, 'Bob', '男', '2002-02-02', 'photo/2.jpg');
INSERT INTO `student` (`id`, `name`, `sex`, `birth`, `photo_url`) VALUES (3, 'Cindy', '女', '2003-03-03', 'photo/3.jpg');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;