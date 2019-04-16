package com.yxp.eguodu.service.system;

import com.yxp.eguodu.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Map<String,Object>> employeeList(Map<String,Object> paras);
    public int insertEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(String employeeId);
}
