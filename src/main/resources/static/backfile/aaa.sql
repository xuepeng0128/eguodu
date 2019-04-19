/*
Navicat MySQL Data Transfer

Source Server         : yz
Source Server Version : 50725
Source Host           : qdm632203159.my3w.com:3306
Source Database       : qdm632203159_db

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-19 15:25:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for circle
-- ----------------------------
DROP TABLE IF EXISTS `circle`;
CREATE TABLE `circle` (
`circleId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '圈子编号' ,
`circleName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '圈名' ,
`circleClassId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '圈子类别id' ,
`schoolId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`classesId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级id' ,
`buildTeacherPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建圈老师paperid' ,
`buildTime`  datetime NOT NULL COMMENT '建圈时间' ,
`memo`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '圈子描述（富文本）' ,
`picUrl`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宣传画' ,
`closeMan`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`closeTime`  datetime NULL DEFAULT NULL ,
`closeReason`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关闭原因' ,
PRIMARY KEY (`circleId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of circle
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for circlehabit
-- ----------------------------
DROP TABLE IF EXISTS `circlehabit`;
CREATE TABLE `circlehabit` (
`circleHabitId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '圈子习惯id' ,
`circleId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属圈子id' ,
`sourceHabitId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '习惯来源（学校管理层，老师，家长）' ,
`habitName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`memo`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`buildManPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`buildTime`  datetime NULL DEFAULT NULL ,
`beginDate`  datetime NULL DEFAULT NULL ,
`endDate`  datetime NULL DEFAULT NULL ,
`putCardCoinPerTime`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`circleHabitId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='圈内习惯'

;

-- ----------------------------
-- Records of circlehabit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for circlehabitstudent
-- ----------------------------
DROP TABLE IF EXISTS `circlehabitstudent`;
CREATE TABLE `circlehabitstudent` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`circleHabitId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`studentPaperId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of circlehabitstudent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
`classesId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`grade`  int(11) NULL DEFAULT NULL ,
`classes`  int(11) NULL DEFAULT NULL ,
`classesName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`schoolId`  int(11) NULL DEFAULT NULL ,
`headMaster`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班主任' ,
PRIMARY KEY (`classesId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of classes
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for classesstudent
-- ----------------------------
DROP TABLE IF EXISTS `classesstudent`;
CREATE TABLE `classesstudent` (
`classesId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`studentId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号' ,
PRIMARY KEY (`classesId`, `studentId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of classesstudent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for classesteacher
-- ----------------------------
DROP TABLE IF EXISTS `classesteacher`;
CREATE TABLE `classesteacher` (
`id`  int(11) NOT NULL ,
`classesId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherPaperId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`studySubjectId`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of classesteacher
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_circleclass
-- ----------------------------
DROP TABLE IF EXISTS `dic_circleclass`;
CREATE TABLE `dic_circleclass` (
`circleClassId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pareClassId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`circleClassName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`icon`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`memo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`circleClassId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of dic_circleclass
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_corpduty
-- ----------------------------
DROP TABLE IF EXISTS `dic_corpduty`;
CREATE TABLE `dic_corpduty` (
`corpDutyId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职务编号' ,
`corpDutyName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务名称' ,
`master`  tinyint(4) NULL DEFAULT 0 COMMENT '是否管理员' ,
PRIMARY KEY (`corpDutyId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of dic_corpduty
-- ----------------------------
BEGIN;
INSERT INTO `dic_corpduty` VALUES ('01', '总监', '1'), ('02', '业务员', '0'), ('331', '23', '1');
COMMIT;

-- ----------------------------
-- Table structure for dic_habit
-- ----------------------------
DROP TABLE IF EXISTS `dic_habit`;
CREATE TABLE `dic_habit` (
`habitId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`habitName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`habitClass`  int(11) NOT NULL DEFAULT 1 COMMENT '1德，2.智，3.体4.美5.劳' ,
`memo`  varchar(1000) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`picUrl`  varchar(1000) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
PRIMARY KEY (`habitId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=gbk COLLATE=gbk_chinese_ci

;

-- ----------------------------
-- Records of dic_habit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_nation
-- ----------------------------
DROP TABLE IF EXISTS `dic_nation`;
CREATE TABLE `dic_nation` (
`nationId`  varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL ,
`nationName`  varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
PRIMARY KEY (`nationId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=gbk COLLATE=gbk_chinese_ci
COMMENT='行政区划'

;

-- ----------------------------
-- Records of dic_nation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_studysubject
-- ----------------------------
DROP TABLE IF EXISTS `dic_studysubject`;
CREATE TABLE `dic_studysubject` (
`studySubjectId`  int(11) NOT NULL AUTO_INCREMENT ,
`studySubjectName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`habitClass`  int(50) NULL DEFAULT NULL COMMENT '习惯模板id' ,
PRIMARY KEY (`studySubjectId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of dic_studysubject
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_subjectexamclass
-- ----------------------------
DROP TABLE IF EXISTS `dic_subjectexamclass`;
CREATE TABLE `dic_subjectexamclass` (
`subjectExamClassId`  int(11) NOT NULL AUTO_INCREMENT ,
`subjectExamClassName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`studySubjectId`  int(11) NULL DEFAULT NULL COMMENT '所属学科id' ,
PRIMARY KEY (`subjectExamClassId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='考试题型分类'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of dic_subjectexamclass
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dic_teacherduty
-- ----------------------------
DROP TABLE IF EXISTS `dic_teacherduty`;
CREATE TABLE `dic_teacherduty` (
`teacherDutyId`  varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL ,
`teacherDutyName`  varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT '' ,
`master`  smallint(4) NULL DEFAULT 0 ,
PRIMARY KEY (`teacherDutyId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=gbk COLLATE=gbk_chinese_ci

;

-- ----------------------------
-- Records of dic_teacherduty
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
`employeeId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`employeeName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`paperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`corpDutyId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`enterDate`  datetime NULL DEFAULT NULL ,
`leaveDate`  datetime NULL DEFAULT NULL ,
`wxcode`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`employeeId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
`menuId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menuName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`pareMenuId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`url`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`icon`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`power`  varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`paixu`  int(11) NULL DEFAULT NULL ,
`kind`  smallint(6) NULL DEFAULT 1 COMMENT '1.公司 ，2.学校，3.机构' ,
PRIMARY KEY (`menuId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('101', '数据资源', '0', null, null, null, '1', '1'), ('10101', '学校资源', '101', '/frame/corpbasemsg/school', null, null, '2', '1'), ('10102', '学生资源', '101', '/frame/corpbasemsg/student', null, null, '3', '1'), ('10103', '教师资源', '101', '/frame/corpbasemsg/teacher', null, null, null, '1'), ('106', '统计分析', '0', null, null, null, '1', '1'), ('107', '字典管理', '0', null, null, null, '1', '1'), ('10701', '微习惯资源池', '107', '/frame/corpdic/habittemplate', null, null, '2', '1'), ('10702', '公司职务', '107', '/frame/corpdic/corpduty', null, null, '3', '1'), ('10703', '学校职务', '107', '/frame/corpdic/teacherduty', null, null, '4', '1'), ('10704', '学校课程', '107', '/frame/corpdic/studysubject', null, null, '5', '1'), ('10705', '试卷题型', '107', '/frame/corpdic/subjectexamclass', null, null, '6', '1'), ('10706', '圈子类别', '107', null, null, null, null, '1'), ('10707', '习惯类别', '107', null, null, null, null, '1'), ('108', '小程序管理', '0', '', null, null, null, '1'), ('10801', '参数设置', '108', null, null, null, null, '1'), ('109', '系统管理', '0', null, null, null, null, '1'), ('10901', '员工管理', '109', '/frame/corpsystem/employee', null, null, null, '1'), ('10902', '系统用户', '109', '/frame/corpsystem/user', null, null, null, '1'), ('10903', '用户权限', '109', '/frame/corpsystem/userPower', null, null, null, '1'), ('10904', '学校管理员', '109', '/frame/corpsystem/schoolAdmin', null, null, null, '1'), ('10905', '培训机构管理员', '109', '/frame/corpsystem/trainschoolAdmin', null, null, null, '1'), ('10909', '修改密码', '109', '/frame/corpsystem/changePwd', null, null, null, '1');
COMMIT;

-- ----------------------------
-- Table structure for parenthabit
-- ----------------------------
DROP TABLE IF EXISTS `parenthabit`;
CREATE TABLE `parenthabit` (
`parentHabitId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`habitClassId`  int(11) NULL DEFAULT NULL ,
`parentHabitName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`buildHabitStudentPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`parentHabitId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of parenthabit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
`schoolId`  varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL ,
`schoolName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cityId`  varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`districtId`  varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`longitude`  decimal(18,6) NULL DEFAULT NULL ,
`latitude`  decimal(18,6) NULL DEFAULT NULL ,
`tel`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`linkMan`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`schoolStyle`  int(11) NULL DEFAULT NULL COMMENT '1 小学,2.初中,3.幼儿园' ,
`saleManId`  varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`regTime`  datetime NULL DEFAULT NULL ,
`train`  smallint(6) NULL DEFAULT 0 COMMENT '是否培训机构,1.是，0.否' ,
PRIMARY KEY (`schoolId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='学校表'

;

-- ----------------------------
-- Records of school
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`studentId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号' ,
`paperId`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`studentName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`schoolId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`wxCode`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`regTime`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for studentnoticereceived
-- ----------------------------
DROP TABLE IF EXISTS `studentnoticereceived`;
CREATE TABLE `studentnoticereceived` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`teacherNoticeId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sendTime`  datetime NULL DEFAULT NULL COMMENT '通知发送时间' ,
`receiveTime`  datetime NULL DEFAULT NULL ,
`studentPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of studentnoticereceived
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for studentputcard
-- ----------------------------
DROP TABLE IF EXISTS `studentputcard`;
CREATE TABLE `studentputcard` (
`id`  bigint(20) NOT NULL ,
`circleHabitId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '圈子习惯id' ,
`studentPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`shouldPutCardDate`  datetime NULL DEFAULT NULL ,
`canGetGuodubi`  int(11) NULL DEFAULT NULL ,
`getGuodubi`  int(11) NULL DEFAULT NULL ,
`upperLimitGuodubi`  tinyint(4) NULL DEFAULT NULL ,
`canGetScore`  decimal(10,6) NULL DEFAULT NULL ,
`getScore`  decimal(10,6) NULL DEFAULT NULL ,
`putCardTime`  datetime NULL DEFAULT NULL ,
`putCardMemo`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`putCardPicUrls`  varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`putCardaudioUrls`  varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`putCardvideoUrls`  varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打卡视频url' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='学生日常打卡'

;

-- ----------------------------
-- Records of studentputcard
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for studysubjectexamresult
-- ----------------------------
DROP TABLE IF EXISTS `studysubjectexamresult`;
CREATE TABLE `studysubjectexamresult` (
`subjectExamId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`studySubjectId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`subjectExamName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`publishTeacherPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`publishCircleIds`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`examTime`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`subjectExamId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='学科考试主表'

;

-- ----------------------------
-- Records of studysubjectexamresult
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for substudysubjectexamresult
-- ----------------------------
DROP TABLE IF EXISTS `substudysubjectexamresult`;
CREATE TABLE `substudysubjectexamresult` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`subjectExamId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`studentPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`subjectExamClassId`  int(11) NULL DEFAULT NULL ,
`score`  decimal(10,2) NULL DEFAULT NULL ,
`getScore`  decimal(10,2) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='学科考试字表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of substudysubjectexamresult
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`paperId`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`teacherName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherDutyId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`schoolId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`regTime`  datetime NOT NULL ,
`wxcode`  varchar(1000) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=gbk COLLATE=gbk_chinese_ci
COMMENT='教师表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teacherhabit
-- ----------------------------
DROP TABLE IF EXISTS `teacherhabit`;
CREATE TABLE `teacherhabit` (
`teacherHabitId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`habitClassId`  int(11) NULL DEFAULT 1 ,
`teacherHabitName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherMemo`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`buildTime`  datetime NULL DEFAULT NULL ,
`buildManPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`teacherHabitId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of teacherhabit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teacherhabitexam
-- ----------------------------
DROP TABLE IF EXISTS `teacherhabitexam`;
CREATE TABLE `teacherhabitexam` (
`teacherHabitExamId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`includeCircleHabitIds`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '包含的考核习惯' ,
`publishedTeacherPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布考核的老师' ,
`publishedDate`  datetime NULL DEFAULT NULL COMMENT '发布时间' ,
`examTitle`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`examMemo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`examBeginDate`  datetime NULL DEFAULT NULL ,
`examEndDate`  datetime NULL DEFAULT NULL ,
`totalScore`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`teacherHabitExamId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='教师考核模板'

;

-- ----------------------------
-- Records of teacherhabitexam
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teachernotice
-- ----------------------------
DROP TABLE IF EXISTS `teachernotice`;
CREATE TABLE `teachernotice` (
`teacherNoticeId`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`buildDate`  datetime NULL DEFAULT NULL ,
`memo`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sendCircleIds`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送圈子id' ,
`buildTeacherPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`teacherNoticeId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='老师发布通知'

;

-- ----------------------------
-- Records of teachernotice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`userId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号' ,
`account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号' ,
`passWord`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码' ,
`schoolId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校编号' ,
`employeeId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司员工身份证号' ,
`teacherPaperId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师身份证号' ,
`supperAdmin`  tinyint(4) NULL DEFAULT 0 ,
`schoolAdmin`  tinyint(4) NULL DEFAULT 0 ,
`addTime`  datetime NULL DEFAULT NULL ,
`kind`  smallint(6) NULL DEFAULT 1 COMMENT '1. 公司,2.学校,3.培训机构' ,
PRIMARY KEY (`userId`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('000000', 'supadmin', 'FC113B85A3ADE1C3', null, null, null, '1', null, null, '1');
COMMIT;

-- ----------------------------
-- Function structure for func_makeBusinessId
-- ----------------------------
DROP FUNCTION IF EXISTS `func_makeBusinessId`;
DELIMITER ;;
CREATE DEFINER=`qdm632203159`@`%` FUNCTION `func_makeBusinessId`(`billstyle` varchar(50)) RETURNS varchar(50) CHARSET utf8
BEGIN
	#Routine body goes here...
   declare billid varchar(50) ;
   
   if billstyle='PUR' THEN

      SELECT ifnull(max(right(purchaseId,4)),'0000') into @maxId from t_main_purchase_bill 
      where purchaseId like  CONCAT('%', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'%');
      set billid= concat('PUR-', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'-',
                          case when @maxId +1 <10 then
                                concat('000', @maxId +1)
                               when  @maxId +1 >=10 and    @maxId +1 <100 THEN
                                 concat('00', @maxId +1) 
                               when  @maxId +1 >=100 and    @maxId +1 <1000 THEN
                                 concat('0', @maxId +1) 
                               ELSE
                                  concat('', @maxId +1) 
                               end );
   ELSEIF  billstyle='IVE' THEN
      SELECT ifnull(max(right(inventoryId,4)),'0000') into @maxId from t_main_inventory_bill 
      where inventoryId like  CONCAT('%', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'%');
      set billid= concat('PUR-', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'-',
                          case when @maxId +1 <10 then
                                concat('000', @maxId +1)
                               when  @maxId +1 >=10 and    @maxId +1 <100 THEN
                                 concat('00', @maxId +1) 
                               when  @maxId +1 >=100 and    @maxId +1 <1000 THEN
                                 concat('0', @maxId +1) 
                               ELSE
                                  concat('', @maxId +1) 
                               end );



   ELSE
      SELECT ifnull(max(right(saleId,4)),'0000') into @maxId from t_main_sale_bill 
      where saleId like  CONCAT('%', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'%');
      set billid= concat('PUR-', DATE_FORMAT(now(),'%Y%m%d'),'-',maker,'-',
                          case when @maxId +1 <10 then
                                concat('000', @maxId +1)
                               when  @maxId +1 >=10 and    @maxId +1 <100 THEN
                                 concat('00', @maxId +1) 
                               when  @maxId +1 >=100 and    @maxId +1 <1000 THEN
                                 concat('0', @maxId +1) 
                               ELSE
                                  concat('', @maxId +1) 
                               end );



   end if;
  


	RETURN billid;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_makeDicId
-- ----------------------------
DROP FUNCTION IF EXISTS `func_makeDicId`;
DELIMITER ;;
CREATE DEFINER=`qdm632203159`@`%` FUNCTION `func_makeDicId`(`dicName` varchar(50)) RETURNS varchar(50) CHARSET utf8
BEGIN
	#Routine body goes here...
   declare Dicid varchar(50) ;
   if dicName='corpduty' THEN 

     SELECT ifnull(max(corpDutyId),'00') into @maxId from dic_corpduty;
        set Dicid= case when @maxId +1 <10 then
                                concat('0', @maxId +1)
                               ELSE
                                  concat('', @maxId +1) 
                               end ;
   ELSEIF  dicName='habit' THEN
      SELECT ifnull(max(habitId),'000') into @maxId from dic_habit;
        set Dicid= case when @maxId +1 <10 then
                                concat('00', @maxId +1)
                        when @maxId +1 >=10 and @maxId +1<100 THEN
                                concat('0', @maxId +1)
                               ELSE
                                  concat('', @maxId +1) 
                               end ;
   ELSEIF  dicName='studysubject' THEN
      SELECT ifnull(max(studySubjectId),'00') into @maxId from dic_studysubject;
        set Dicid= case when @maxId +1 <10 then
                                concat('0', @maxId +1)
                               ELSE
                                  concat('', @maxId +1) 
                               end ;

  ELSEIF  dicName='subjectexamclass' THEN
      SELECT ifnull(max(subjectExamClassId),'00') into @maxId from dic_subjectexamclass;
        set Dicid= case when @maxId +1 <10 then
                                concat('0', @maxId +1)
                               ELSE
                                  concat('', @maxId +1) 
                               end ;



   ELSEIF  dicName='user' THEN
  
        SELECT ifnull(max(userId),'000000') into @maxId from user  ;
        set Dicid= case when @maxId +1 <10 then
                                concat('00000', @maxId +1)
                               when  @maxId +1 >=10 and    @maxId +1 <100 THEN
                                 concat('0000', @maxId +1) 
                               when  @maxId +1 >=100 and    @maxId +1 <1000 THEN
                                 concat('000', @maxId +1) 
                               when  @maxId +1 >=1000 and    @maxId +1 <10000 THEN
                                 concat('00', @maxId +1) 
                               when  @maxId +1 >=10000 and    @maxId +1 <100000 THEN
                                 concat('0', @maxId +1) 
                               ELSE
                                  concat('', @maxId +1) 
                               end ;
 
  end if;
	RETURN Dicid;
END
;;
DELIMITER ;

-- ----------------------------
-- Auto increment value for circlehabitstudent
-- ----------------------------
ALTER TABLE `circlehabitstudent` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for dic_studysubject
-- ----------------------------
ALTER TABLE `dic_studysubject` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for dic_subjectexamclass
-- ----------------------------
ALTER TABLE `dic_subjectexamclass` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for student
-- ----------------------------
ALTER TABLE `student` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for studentnoticereceived
-- ----------------------------
ALTER TABLE `studentnoticereceived` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for substudysubjectexamresult
-- ----------------------------
ALTER TABLE `substudysubjectexamresult` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for teacher
-- ----------------------------
ALTER TABLE `teacher` AUTO_INCREMENT=1;
