package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PutCard {

    private School school;
    private TrainSchool trainSchool;
    private Circle circle;
    private Habit habit;
    private Date putCardTime;
    private String memo;
    private Student student;
    private List<String> picUrl;
    private List<String> videoUrl;
    private List<String> audioUrl;
}
