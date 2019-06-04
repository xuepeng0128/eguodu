package com.yxp.eguodu.common.queryparams;

import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertExamHabitParams {
   private  HabitExam habitExam ;  // 考核
   private List<Habit> habits;   // 习惯列表
   private String[] studentIds; // 参与习惯的学生ids
}
