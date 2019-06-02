package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.entity.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface CircleService {

    public List<Map<String ,Object>> circleList(CircleQueryParams circleQueryParams);

    public List<Map<String,Object>> circleListTotal(CircleQueryParams circleQueryParams);
    public List<Student> circleStudentList( String circleId);
    public List<Circle> teacherJoinedCircles(String teacherId);
    public int insertCircle(Circle circle);

    public int updateCircle(Circle circle);

    public int deleteCircle(Map<String,Object> paras);

    public int closeCircle(Map<String,Object> paras);


    //------------------------ 微信---------------------------//
    // 按条件组合分页查询圈子(本学生未加入过的公开圈子)
    public List<Map<String,Object>> circleFindList(String circleTitle,String circleClassId,String studentId, String pageSize, String pageBegin);

    // 查询本学生已加入的圈子
    public List<Map<String,Object>> circleHaveJoinedList(String studentId, String pageSize, String pageBegin);

    // 查询本学生家长建的圈子
    public List<Map<String,Object>>  studentBuildCircleList(String studentId, String pageSize, String pageBegin);

    //学生家长建圈
    public int studentBuildCircle(Circle circle);

    // 学生家长圈子修改
//    private String circleId; // 圈子编号
//    private String circleTitle; // 圈子标题
//    private String subTitle ; // 副标题
//    private String circleClassId; // 类别
//    private String  memo; // 圈子介绍
//    private String picUrl; // 宣传海报
    public int updateStudentBuildCircle(Circle circle);


    //学生加入圈子
    public int studentJoinCircle(String circleId,String studentId);

    // 学生退出圈子（有学籍，班级, 建圈老师 的圈子为 学校建的圈子，不能自行退出）
    public int studentOutOfCircle(String circleId,String studentId);






}
