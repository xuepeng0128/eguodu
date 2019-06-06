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
//打卡类
public class StudentPutCard {
    private int id; // id
    private String         habitId ; // 习惯id
    private String studentId ; // 学生id
    private Date         shouldPutCardDateBegin ; // 应打卡开始时间
    private Date shouldPutCardDateEnd ; // 应打卡结束时间
    private int         canGetGuodubi; //应得果度币
    private int haveGuodubi;//实得果度币
    private boolean        upperLimitGuodubi; //是否已达到果度币上限
    private float canGetScore; //应得分值
    private float haveScore;//实际得分
    private Date putCardTime;//打卡时间
    private String         putCardMemo; //打卡文字描述
    private String putCardPicUrls;//打卡图片url，逗号分隔
    private String putCardaudioUrls;//打卡音频url，逗号分隔
    private String putCardvideoUrls;//打卡视频url
    private String        shouldFinish;//本次打卡应完成量
    private String haveFinish;//实际完成量
    private boolean        finished;//本次任务是否完成
    private  String finishCompare;//应完成，实际完成关系 'gt' 大于等于, 'lt' 小于等于
    private String remark;//备注
    private float longitude; // 经度
    private float latitude; //纬度
}
