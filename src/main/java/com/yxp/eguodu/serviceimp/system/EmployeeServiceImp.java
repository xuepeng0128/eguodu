package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.dao.system.EmployeeMapper;
import com.yxp.eguodu.entity.Employee;
import com.yxp.eguodu.service.system.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<Employee> employeeList(Map<String,Object> paras) {
        return mapper.employeeList(paras);
    }

    @Override
    public int insertEmployee(Employee employee) {
        return mapper.insertEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return mapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(String employeeId) {
        return mapper.deleteEmployee(employeeId);
    }
}
