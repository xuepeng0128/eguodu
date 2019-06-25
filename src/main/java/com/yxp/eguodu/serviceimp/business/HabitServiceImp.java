package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.dao.business.HabitMapper;
import com.yxp.eguodu.entity.*;
import com.yxp.eguodu.service.business.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HabitServiceImp implements HabitService {
    @Autowired
    private HabitMapper mapper;
    @Override
    public List<Habit> habitList(HabitQueryParams habitQueryParams) {
        return mapper.habitList(habitQueryParams);
    }

    @Override
    public List<Map<String, Object>> habitListTotal(HabitQueryParams habitQueryParams) {
        return mapper.habitListTotal(habitQueryParams);
    }

    @Override
    public int insertExamHabit(HabitExam habitExam, List<Habit> habits,String[] studentIds) {
        mapper.insertHabitExam(habitExam);
        for(Habit habit : habits)
        {
              for (int i=0 ;i< studentIds.length;i++)
              {
                  mapper.insertHabitStudent(new HabitStudent(habit.getHabitId(),studentIds[i],null));
              }
              mapper.insertHabit(habit);


        }
        for (int i=0 ;i< studentIds.length;i++)
        {
            mapper.groupInsertStudentPutCardPlan(calStudentPutCardPlan(studentIds[i],habitExam,habits));
        }

        List<Map<String,Object>> slist= mapper.examPutCards(habitExam.getHabitExamId());
        float canGetScore = ((float) habitExam.getTotalScore())/  ((float) slist.get(0).get("puts"));
        mapper.setCanGetScore(habitExam.getHabitExamId(),canGetScore);

        return 1;
    }

    @Override
    public int insertNoExamHabit(Habit habit,String[] studentIds) {

            for (int i=0 ;i< studentIds.length;i++)
            {
                mapper.insertHabitStudent(new HabitStudent(habit.getHabitId(),studentIds[i],null));
            }
            mapper.insertHabit(habit);


        for (int i=0 ;i< studentIds.length;i++)
        {
            mapper.groupInsertStudentPutCardPlan(calStudentPutCardPlan(studentIds[i],null,new ArrayList<Habit>(){{
                add(habit);
            }}));
        }
        return 1;
    }

    @Override
    public List<HabitExam> habitExamByHabitId(String habitId) {
        return mapper.habitExamByHabitId(habitId);
    }

    @Override
    public List<Habit> examHabits(String habitExamId) {
        return mapper.examHabits(habitExamId);
    }

    @Override
    public List<Habit> thisStudenthabitList(HabitQueryParams habitQueryParams) {
        return mapper.thisStudenthabitList(habitQueryParams);
    }


    // 学生准备打卡，获取打卡信息
    @Override
    public List<StudentPutCard> currentStudentPrepareHabitPutCard(String habitId, String studentId) {
        return mapper.currentStudentPrepareHabitPutCard(habitId,studentId);
    }






    @Override
    public int studentPutCard(WxPutCard wxPutCard) {
         mapper.studentPutCardSetFinish(wxPutCard);
         mapper.studentPutCart(wxPutCard);
         return 1;
    }

    @Override
    public List<Map<String, Object>> habitStudentPutCards(String habitId,String pageBegin,String pageSize) {
        return mapper.habitStudentPutCards(habitId,pageBegin,pageSize);
    }

    @Override
    public List<Map<String, Object>> currentStudentPutCardList(String habitId, String studentId,String pageBegin,String pageSize) {
        return mapper.currentStudentPutCardList(habitId,studentId,pageBegin,pageSize);
    }

    @Override
    public List<Student> habitStudents(String habitId, String schoolId) {
        return mapper.habitStudents(habitId,schoolId);
    }

    @Override
    public List<WxPutCardDiary> putCardDiaryList(String circleId,String longitude ,
                                                 String latitude , String mostHoldDays,
                                                  String mostAgree, String putCardTimeBegin ,
                                                  String putCardTimeEnd ,String pageBegin, String pageSize) {
        if (putCardTimeEnd != null && !putCardTimeEnd.equals("")){
            putCardTimeEnd = putCardTimeEnd + " 23:59:59 ";
        }
        return mapper.putCardDiaryList(circleId,longitude ,
               latitude ,mostHoldDays,mostAgree, putCardTimeBegin, putCardTimeEnd,pageBegin,pageSize);
    }

    @Override
    public int agreePutCard(String putCardId, String studentId) {
        return mapper.agreePutCard(putCardId,studentId);
    }

    @Override
    public List<Habit> lessonTohabitList(String lessonId) {
        return mapper.lessonTohabitList(lessonId);
    }


    private List<StudentPutCard> calStudentPutCardPlan(String studentId,HabitExam habitExam, List<Habit> habits){
        Date beginPutCardTime =null;
        List<StudentPutCard> studentPutCardList = new ArrayList<StudentPutCard>();
        for(Habit h : habits)
        {
            beginPutCardTime= h.getPutCardBeginDate();
            int perTime=h.getPirTime();
            String timeUnit=h.getTimeUnit();
            do{
                     StudentPutCard putCard = new StudentPutCard();
                     putCard.setShouldPutCardDateBegin(beginPutCardTime);


                     Calendar calendar = new GregorianCalendar();
                     calendar.setTime(beginPutCardTime);
                     if(timeUnit.equals("天"))
                            calendar.add(Calendar.DATE,perTime);
                     else if (timeUnit.equals("周"))
                            calendar.add(Calendar.WEEK_OF_MONTH,perTime);
                         else //月
                            calendar.add(Calendar.MONTH,perTime);

                     beginPutCardTime=calendar.getTime();

                     if (beginPutCardTime.after(h.getPutCardEndDate()))
                         beginPutCardTime=h.getPutCardEndDate();

                     putCard.setShouldPutCardDateEnd(beginPutCardTime);
                     putCard.setCanGetGuodubi(h.getGuoduCoin());
                     putCard.setHabitId(h.getHabitId());
                     if (h.getMode()==1 ){
                         putCard.setShouldFinish(h.getTimeModeNum());
                         putCard.setFinishCompare(h.getTimeCompare());
                     }
                     else if (h.getMode()== 2){
                         putCard.setShouldFinish(h.getCountModeNum().toString());
                         putCard.setFinishCompare("gt");
                     }
                     else{
                         putCard.setShouldFinish(h.getValueModeNum().toString());
                         putCard.setFinishCompare("gt");
                     }


                     putCard.setStudentId(studentId);
                     studentPutCardList.add(putCard);
            }while(beginPutCardTime.before(h.getPutCardEndDate()));

        }

        if (habitExam != null)
        {
            float score = habitExam.getTotalScore();
            for(StudentPutCard putCard : studentPutCardList){
                putCard.setCanGetScore(score/studentPutCardList.size());
            }
        }
        return studentPutCardList;
    }


}
