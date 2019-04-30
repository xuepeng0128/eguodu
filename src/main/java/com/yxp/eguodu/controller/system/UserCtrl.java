package com.yxp.eguodu.controller.system;

import com.yxp.eguodu.common.DesUtil;
import com.yxp.eguodu.common.queryparams.UserQueryParams;
import com.yxp.eguodu.entity.User;
import com.yxp.eguodu.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/system/user", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class UserCtrl {

    @Autowired
    private UserService svr;

    @GetMapping(value="/userList")
    public List<Map<String,Object>> userList(String schoolId, String account, String employeeName, String teacherName, String schoolAdmin, String kind, String pageSize, String pageNo, String pageBegin){

        UserQueryParams params= new UserQueryParams( schoolId,  account,  employeeName,  teacherName,  schoolAdmin,  kind,  pageSize,  pageNo,  pageBegin);
       
        List<Map<String,Object>> userlist = svr.userList(params);
        return userlist;
    }

    @GetMapping(value="/userListTotal")
    public Map<String,Object> userListTotal(String schoolId, String account, String employeeName, String teacherName, String schoolAdmin, String kind, String pageSize, String pageNo, String pageBegin){
        UserQueryParams params= new UserQueryParams( schoolId,  account,  employeeName,  teacherName,  schoolAdmin,  kind,  pageSize,  pageNo,  pageBegin);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total", Integer.parseInt( svr.userListTotal(params).get(0).get("total").toString()));
        return re;

    }


    @PostMapping(value="/validateUser")
    public List<User> validateUser(@RequestBody User user) throws Exception {
        List<User> ruser = svr.validateUser(user);
        return ruser;
    }



    @PostMapping(value="/insertUser")
    public Map<String, Object> insertUser(@RequestBody User user) throws Exception {
        user.setPassWord(DesUtil.encrypt("123456"));
        int d = svr.insertUser(user);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @PostMapping(value="/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user){
        int d = svr.updateUser(user);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

//    @GetMapping(value="/deleteUser")
//    public String deleteUser(String account){
//        try {
//            svr.deleteUser(account);
//            return "ok";
//        }catch (Exception ex){
//            return "fail" + ex.toString();
//        }
//    }




}
