package com.yxp.eguodu.controller.system;

import com.yxp.eguodu.entity.Employee;
import com.yxp.eguodu.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/system/employee", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class EmployeeCtrl {
    @Autowired
    private EmployeeService svr;


    @GetMapping(value="/employeeList")
    public List<Employee> employeeList(String employeeId,String employeeName){
        Map<String,Object> paras = new HashMap<String,Object>();
        paras.put("employeeId",employeeId);
        paras.put("employeeName",employeeName);
        return svr.employeeList( paras);
    }



    @PostMapping(value="/insertEmployee")
    public Map<String,Object>  insertEmployee(@RequestBody  Employee employee){
        int d = svr.insertEmployee(employee);
        if (d>=0)
            return  new HashMap<String,Object>()
                     {{
                         put( "result","ok");
                     }};

        else
            return  new HashMap<String,Object>()
            {{
                put( "result","ok");
            }};
    }


    @PostMapping(value="/updateEmployee")
    public Map<String, Object> updateEmployee(@RequestBody Employee employee){
        int d = svr.updateEmployee(employee);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteEmployee")
    public Map<String, Object> deleteEmployee(String employeeId){
        int d = svr.deleteEmployee(employeeId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

}
