package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.common.queryparams.InsertExamHabitParams;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.business.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/habit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class HabitCtrl {

    @Autowired
    private HabitService svr;
    @GetMapping(value="/habitList")
    public List<Habit> habitList(    String  habitId, String classesId, String circleId, String circleTitle, String habitName, String habitClassId,
                                      String subHabitClassId, String schoolId, String buildTeacherId, String buildStudentId, String examed,String allHabitStudentId,String todayStudentId,
                                      String pageSize, String pageNo, String pageBegin){
         if (classesId != null && !classesId.equals("")){
             classesId= "'" + classesId.replace(",","','") + "'";
         }
         HabitQueryParams habitQueryParams= new HabitQueryParams(  habitId,  classesId,  circleId,  circleTitle,  habitName,  habitClassId,
                  subHabitClassId,  schoolId,  buildTeacherId,  buildStudentId,  examed, allHabitStudentId,todayStudentId,
                  pageSize,  pageNo,  pageBegin);
        return svr.habitList(habitQueryParams);
    }
    @GetMapping(value="/habitListTotal")
    public Map<String,Object> habitListTotal(String  habitId, String classesId, String circleId, String circleTitle, String habitName, String habitClassId,
                                             String subHabitClassId, String schoolId, String buildTeacherId, String buildStudentId, String examed,String allHabitStudentId, String todayStudentId,
                                             String pageSize, String pageNo, String pageBegin){
        if (classesId != null && !classesId.equals("")){
            classesId= "'" + classesId.replace(",","','") + "'";
        }
        HabitQueryParams habitQueryParams= new HabitQueryParams(  habitId,  classesId,  circleId,  circleTitle,  habitName,  habitClassId,
                subHabitClassId,  schoolId,  buildTeacherId,  buildStudentId,  examed, allHabitStudentId,todayStudentId,
                pageSize,  pageNo,  pageBegin);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total", Integer.parseInt( svr.habitListTotal(habitQueryParams).get(0).get("total").toString()));
        return re;
    }

    //根据习惯id查询考核id
    @GetMapping(value = "/habitExamByHabitId")
    public List<HabitExam> habitExamByHabitId(String habitId){
        List<HabitExam> list= svr.habitExamByHabitId(habitId);
        return list;
    }
 // 根据考核id查所有习惯
    @GetMapping(value="/examHabits")
    public List<Habit> examHabits(String habitExamId){
       List<Habit> list = svr.examHabits(habitExamId);
       return  list;
    }

    @PostMapping(value="/insertExamHabit")
    public Map<String,Object> insertExamHabit(@RequestBody  InsertExamHabitParams insertExamHabitParams){

       int d = svr.insertExamHabit(insertExamHabitParams.getHabitExam(),insertExamHabitParams.getHabits(),insertExamHabitParams.getStudentIds());
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


    @GetMapping(value = "/habitStudentPutCards")
    public List<Map<String,Object>> habitStudentPutCards(String habitId,String pageSize,String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list = svr.habitStudentPutCards(habitId,pageBegin,pageSize);
        return list;

    }
    @GetMapping(value = "/currentStudentPutCardList")
    public List<Map<String,Object>> currentStudentPutCardList(String habitId,String studentId,String pageSize,String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list = svr.currentStudentPutCardList(habitId,studentId,pageBegin,pageSize);
        return list;
    }

    @PostMapping(value="/insertNoExamHabit")
    public Map<String,Object> insertNoExamHabit(@RequestBody  InsertExamHabitParams insertExamHabitParams){
        int d = svr.insertNoExamHabit(insertExamHabitParams.getHabits().get(0),insertExamHabitParams.getStudentIds());
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    public Map<String,Object> studentPutCard( String habitId ,  String studentId){
        return null;
    }



    // 获取习惯参与学生
    @GetMapping(value="/habitStudents")
    public List<Student> habitStudents(String habitId,String schoolId){
       List<Student> list =svr.habitStudents(habitId,schoolId);
       return list;
    }

}
