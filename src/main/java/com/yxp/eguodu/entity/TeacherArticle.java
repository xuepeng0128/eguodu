package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherArticle {
    public String  articleId;
    public String articleTitle;
    public Date makeDate;
    public String teacherId;
    public String teacherName;
    public String schoolId;
    public String schoolName;
    public String articleContent;
    public boolean published;


}
