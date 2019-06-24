package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTeacherLesson {
    private String lessonId;
    private int lessonNo;
    private String lessonNoTitle;
    private int mode;
    private String memo;
    private String picUrl;
    private String videoUrl;
    private String  audioUrl;
    private boolean noPay;

}
