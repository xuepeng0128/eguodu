package com.yxp.eguodu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Cstudent {
    private String classesId;
    private List<Student> studentList;
}
