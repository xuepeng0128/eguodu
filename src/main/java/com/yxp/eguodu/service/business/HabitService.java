package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HabitService {


    public List<Habit> habitList(HabitQueryParams habitQueryParams);

    public List<Map<String,Object>> habitListTotal(HabitQueryParams habitQueryParams);


    public int insertExamHabit(HabitExam habitExam ,List<Habit> habits,String[] studentIds);

    public int insertNoExamHabit(Habit habit,String[] studentIds);


    // 学生准备打卡，获取打卡信息
    public List<StudentPutCard>  currentStudentPrepareHabitPutCard( String habitId,  String studentId);

    public int studentPutCard(WxPutCard wxPutCard);


    // 圈子日记
    public List<WxPutCardDiary> putCardDiaryList(String circleId, String longitude ,
                                                  String latitude ,    String mostHoldDays,
                                                  String mostAgree,  String putCardTimeBegin ,
                                                  String putCardTimeEnd, String pageBegin,String pageSize);

    // 打卡点赞
    public int agreePutCard( String putCardId , String studentId);
}
