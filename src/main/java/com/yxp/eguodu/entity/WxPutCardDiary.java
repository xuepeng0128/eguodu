package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//  微信圈子日记
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxPutCardDiary {
     private int id; // 打卡id
     private String nickname; // 昵称
     private String headimg ; // 头像
     private int sex; // 性别
     private String  putCardaudioUrls;
     private String putCardMemo;
     private String putCardPicUrls;
     private String putCardvideoUrls;
     private String putCardTime ; // 本次打卡时间
     private int  holdDays ; // 坚持天数
     private String lessonTitle ;// 主题
     private String agrees ; // 点赞昵称集合
     private String[] zans;


}
