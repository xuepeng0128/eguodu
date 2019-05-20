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
   private  HabitExam habitExam ;
   private List<Habit> habits;
   private String[] studentIds;
}
