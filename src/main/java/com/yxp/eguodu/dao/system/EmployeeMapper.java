package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    @Select("<script> select employeeId,employeeName,tel,employeePaperId,ifnull(e.corpDutyId,'') as corpDutyId, " +
            " ifnull(d.corpDutyName,'') as corpDutyName " +
            ",address,enterDate,leaveDate from employee e  " +
            "left outer join dic_corpduty d on e.corpDutyId=d.corpDutyId " +
            "where 1=1 " +
            " <if test ='employeeId != null and employeeId !=\"\"'>" +
            "   and employeeId ='${employeeId}'" +
            " </if>" +
            "<if test ='employeeName != null and employeeName !=\"\"'> " +
            "  and employeeName like '%${employeeName}%' " +
            "</if> " +
            "</script>")
    public List<Employee> employeeList(Map<String,Object> paras);
    @Insert("<script>" +
            " insert into employee(employeeId,employeeName,tel,employeePaperId, corpDutyId, " +
            " address,enterDate) values(func_makeDicId('employee'),'${employeeName}','${tel}','${employeePaperId}', '${corpDutyId}'," +
            "  '${address}',now())" +
            " </script> ")
    public int insertEmployee(Employee employee);

    @Update("<script>" +
            " update employee set employeeName='${employeeName}',tel='${tel}',employeePaperId='${employeePaperId}', corpDutyId='${corpDutyId}'," +
            "address='${address}', enterDate='${enterDate}' ,leaveDate='${leaveDate}',wxcode='${wxcode}' where  employeeId='${employeeId}'  " +
            " </script>"
          )
    public int updateEmployee(Employee employee);
    @Delete("delete from employee where employeeId='${employeeId}'")
    public int deleteEmployee(@Param("employeeId") String employeeId);

}
