package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDuty {

    public String teacherDutyId;
    public String teacherDutyName;
    public boolean master;
}
