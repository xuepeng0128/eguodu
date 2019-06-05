package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.dao.business.CircleMapper;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CircleServiceImp implements CircleService {
    @Autowired
    private CircleMapper mapper;
    @Override
    public List<Map<String, Object>> circleList(CircleQueryParams circleQueryParams) {
        return mapper.circleList(circleQueryParams);
    }

    @Override
    public List<Map<String, Object>> circleListTotal(CircleQueryParams circleQueryParams) {
        return mapper.circleListTotal(circleQueryParams);
    }

    @Override
    public List<Student> circleStudentList(String circleId) {
        return mapper.circleStudentList(circleId);
    }

    @Override
    public List<Circle> teacherJoinedCircles(String teacherId) {
        return mapper.teacherJoinedCircles(teacherId);
    }

    @Override
    public int insertCircle(Circle circle) {
           mapper.insertClassStudentToCircle(circle.getCircleId(),circle.getClassesId());
           mapper.insertTeachersToCircle(circle.getCircleId(),circle.getClassesId());
          return mapper.insertCircle(circle);
    }

    @Override
    public int updateCircle(Circle circle) {
        return mapper.updateCircle(circle);
    }

    @Override
    public int deleteCircle(Map<String, Object> paras) {
        return mapper.deleteCircle(paras);
    }

    @Override
    public int closeCircle(Map<String, Object> paras) {
        return mapper.closeCircle(paras);
    }





    // 按条件组合分页查询圈子(本学生未加入过的公开圈子)
    @Override
    public List<Map<String,Object>> circleFindList(String circleTitle, String circleClassId, String studentId, String pageSize, String pageBegin) {
        return mapper.circleFindList(circleTitle,circleClassId,studentId,pageSize,pageBegin);
    }
    // 查询本学生已加入的圈子
    @Override
    public List<Map<String,Object>> circleHaveJoinedList(String studentId,  String pageSize, String pageBegin) {
        return mapper.circleHaveJoinedList(studentId,pageSize,pageBegin);
    }
    // 查询本学生家长建的圈子
    @Override
    public List<Map<String,Object>> studentBuildCircleList(String studentId, String pageSize, String pageBegin) {
        return mapper.studentBuildCircleList(studentId,pageSize,pageBegin);
    }
    //学生家长建圈
    @Override
    public int studentBuildCircle(Circle circle) {
         mapper.insertCircle(circle);
         mapper.insertCurrentStudentToCircle(circle.getCircleId(),circle.getBuildStudentId());
         return 1;
    }

    @Override
    public int updateStudentBuildCircle(Circle circle) {
        return mapper.updateCircle(circle);
    }

    @Override
    public int studentJoinCircle(String circleId, String studentId) {
        return    mapper.insertCurrentStudentToCircle(circleId,studentId );
    }

    @Override
    public int studentOutOfCircle(String circleId, String studentId) {
        return mapper.studentOutOfCircle(circleId,studentId);
    }

    // 根据id 查询根据圈子ID 获取圈子内容（标题、缩略图、副标题、来源学校、参加人数、总打卡次数、通知、当前主题信息【缩略图、标题、副标题】）
    @Override
    public List<Map<String, Object>> circleMsgById(String circleId,String studentId) {
        return mapper.circleMsgById(circleId,studentId);
    }
}
