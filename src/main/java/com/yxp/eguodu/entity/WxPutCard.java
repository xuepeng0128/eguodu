package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//打卡
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxPutCard {
    private int id;
    private String putCardMemo; //打卡文字描述
    private String putCardPicUrls;//打卡图片url，逗号分隔
    private String putCardaudioUrls;//打卡音频url，逗号分隔
    private String putCardvideoUrls;//打卡视频url
    private String haveFinish;//实际完成量
    private float longitude; // 经度
    private float latitude; //纬度
}
