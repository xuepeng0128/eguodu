package com.yxp.eguodu.controller.corp.system;

import com.yxp.stuhabit.entity.Employee;
import com.yxp.stuhabit.service.dic.CorpDutyService;
import com.yxp.stuhabit.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/corp/system/employee", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class EmployeeCtrl {
    @Autowired
    private EmployeeService svr;
    @Autowired
    private CorpDutyService corpDutyService;

    @GetMapping(value="/employeeList")
    public Map<String,Object> employeeList(String paperId, String employeeName, String tel, String dutyName, String pageSize, String pageNo,String getTotal){
        return svr.employeeList(paperId, employeeName,tel,  dutyName,pageSize,pageNo,getTotal);
    }

    @GetMapping(value="/singleEmployee")
    public Employee singleEmployee(String paperId){
        return svr.singleEmployee(paperId);
    }


    @PostMapping(value="/insertEmployee")
    public Employee insertEmployee(@RequestBody Employee employee){
        employee.setDuty( corpDutyService.findCorpDutyById(employee.getDuty().getCorpDutyId()));
        return svr.insertEmployee(employee);
    }
    @PostMapping(value="/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        employee.setDuty( corpDutyService.findCorpDutyById(employee.getDuty().getCorpDutyId()));
        return svr.updateEmployee(employee);
    }

    @GetMapping(value="/deleteEmployee")
    public String deleteEmployee(String paperId){
        try {
            svr.deleteEmployee(paperId);
            return "ok";
        }catch (Exception ex){
            return "fail" + ex.toString();
        }
    }    

    
}
