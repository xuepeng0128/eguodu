package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPutCard {
    private int id;
    private String         habitId ;
    private String studentId ;
    private Date         shouldPutCardDateBegin ;
    private Date shouldPutCardDateEnd ;
    private int         canGetGuodubi;
    private int haveGuodubi;
    private boolean        upperLimitGuodubi;
    private float canGetScore;
    private float haveScore;
    private Date putCardTime;
    private String         putCardMemo;
    private String putCardPicUrls;
    private String putCardaudioUrls;
    private String putCardvideoUrls;
    private String        shouldFinish;
    private String haveFinish;
    private boolean        finished;
    private  String finishCompare;
    private String remark;

}
