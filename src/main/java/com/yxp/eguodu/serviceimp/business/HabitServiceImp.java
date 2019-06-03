package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.dao.business.HabitMapper;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import com.yxp.eguodu.entity.HabitStudent;
import com.yxp.eguodu.entity.StudentPutCard;
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
    public int studentPutCard(String habitId, String studentId) {
        return 0;
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
