package com.yxp.eguodu.wxcontroller;


import com.alibaba.fastjson.JSONObject;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.basemsg.StudentService;
import com.yxp.eguodu.service.basemsg.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Api(value="微信登录",tags={"微信登录webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxlogin",  produces = "application/json;charset=UTF-8")
public class WxLoginCtrl {
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private TeacherService tsvr;
    @Autowired
    private StudentService ssvr;

    @ApiOperation( value = "根据code获取openid",notes = "" +
            " 返回字段：{" +
            "    data : openId 值 ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "小程序code", required = true, dataType = "String", paramType = "query"),
}
    )
    @GetMapping(value="/getOpenId")
    public Map<String,Object> getOpenId(String code){
        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("resultMsg", "code 不能为空");
            map.put("resultCode","1");
            return map;
        }
              String wechatAppId = appid;
               // mini-Program's session-key
                String wechatSecretKey = secret;

               String grantType = "authorization_code";
               // using login code to get sessionId and openId
               String params = "appid=" + wechatAppId + "&secret=" + wechatSecretKey + "&js_code=" + code + "&grant_type=" + grantType;

               // sending request
               String url ="https://api.weixin.qq.com/sns/jscode2session?"+ params;

                String str = httpRequest(url, "GET", null);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);

        // 我们需要的openid，在一个小程序中，openid是唯一的
        String openid ="";
        try{
            openid = jsonObject.get("openid").toString();
            map.put("data",openid);
            map.put("resultMsg","ok");
            map.put("resultCode","0");
        }catch (Exception ex){
            map.put("data","openId 获取异常");
            map.put("resultMsg","ok");
            map.put("resultCode","2");
        }
        return  map;
    }

    @ApiOperation( value = "根据openId获取当前用户信息",notes = "" +
            " 返回字段：{" +
            "    data : {" +
            "               teachers : [ { " +
            "                                  teacherId: string; // 老师编号 " +
            "                                  teacherPaperId: string; // 身份证 " +
            "                                   tel: string ; // 电话 " +
            "                                   teacherName: string ; // 老师姓名 " +
            "                                   teacherDutyId: string ; // 当前职务id " +
            "                                 teacherDutyName: string ;//当前职务  " +
            "                                          master: boolean; // 是否校领导 " +
            "                                         address: string; // 家庭住址" +
            "                                         schoolId: string; // 学校id " +
            "                                       schoolName : string; // 学校名称" +
            "                                           regTime: Date; // 入校时间" +
            "                              }       " +
            "                            ]      // 老师信息,多个老师身份" +
            "               students : [" +
            "                             {" +
            "                                    id: number; // id " +
            "                                  studentPaperId: string; // 身份证号 " +
            "                                        studentId: string; // 学籍号 " +
            "                                      studentName: string; // 名称 " +
            "                                               sex: number; // 性别 1.男，2.女 " +
            "                                              birthday: Date; // 出生日期 " +
            "                                               schoolId: string; // 学校编号 " +
            "                                             schoolName: string; // 学校名称 " +
            "                                                address: string ; // 家庭住址 " +
            "                                                    tel: string; // 联系电话 " +
            "                                                headimg: string; // 头像 " +
            "                                               nickname: string; // 昵称 " +
            "                                                regTime: Date; // 入校时间 " +
            "                                              wxcode: string; // 小程序openid " +
            "                              } " +
            "                         ]      // 学生信息,多个学生身份 " +
            "            } ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openId", value = "小程序openId", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/openIdSignin")
    public Map<String,Object> openIdSignin(String openId){
        Map map = new HashMap();
        //登录凭证不能为空
        if (openId == null || openId.length() == 0) {
            map.put("resultMsg", "openId 不能为空");
            map.put("resultCode", "3");
            return map;
        }
        map.put("data", new HashMap<String,Object>(){{
              put("teachers" , tsvr.teacherListByOpenId(openId));
              put("students" ,ssvr.studentListByOpenId(openId));
        }} );
        map.put("resultMsg","ok");
        map.put("resultCode", "0");
        return map;
    }

    @ApiOperation( value = "邀请码绑定 ",notes = "" +
            " 返回字段：{" +
            " data :  student 类 " +
            "    resultMsg : 'ok' ：成功，验证码有效 ，否则返回fail ： 无效验证码" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openId", value = "小程序openId", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "inviteCode", value = "学生邀请码", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentInviteCodeBind")
    public Map<String,Object> studentInviteCodeBind(@PathVariable String openId,String inviteCode){
        Map map = new HashMap();
        //登录凭证不能为空
        if (openId == null || openId.length() == 0) {
            map.put("resultMsg", "openId 不能为空");
            map.put("resultCode","3");
            return map;
        }
        Student student= ssvr.bindStudentInviteCode(inviteCode,openId);
        map.put("data", student );
        map.put("resultMsg", student == null ? "fail" :"ok");
        map.put("resultCode","0");
        return map;
    }


    @ApiOperation( value = "非验证码学生绑定 ",notes = "" +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回失败信息 " +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效,9.写数据库错误 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student", value = "学生类", required = true, dataType = "Student"),
    }
    )

    @PostMapping(value="/noInviteCodeStudentBind")
    public Map<String,Object> noInviteCodeStudentBind(@RequestBody Student student){
        Map map = new HashMap();
        //登录凭证不能为空
        if (student.getWxcode() == null || student.getWxcode().length() == 0) {
            map.put("resultMsg", "openId 不能为空");
            map.put("resultCode","3");
            return map;
        }
        int d = ssvr.insertStudent(student);
        if (d>0)
            return new HashMap<String,Object>(){{
                put("resultMsg","ok") ;
                map.put("resultCode","0");
           }} ;
        else
            return new HashMap<String,Object>(){{
                put("resultMsg","fail") ;
                map.put("resultCode","9");
        }} ;
    }




    private String httpRequest(String requestUrl,String requestMethod,String output){
        try{
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            if(null != output){
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("utf-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }


}
