package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    @Select("<script> select employeeId,employeeName,tel,paperId,ifnull(e.corpDutyId,'') as corpDutyId, " +
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
    public List<Map<String,Object>> employeeList(Map<String,Object> paras);
    @Insert("<script>" +
            " insert into employee(employeeId,employeeName,tel,paperId, corpDutyId, " +
            " address,enterDate) values('${employeeId}','${employeeName}','${tel}','${paperId}', '${corpDutyId}'," +
            "  '${address}','${enterDate}')" +
            " </script> ")
    public int insertEmployee(Employee employee);

    @Update("<script>" +
            " update employee set employeeName='${employeeName}',tel='${tel}',paperId='${paperId}', corpDutyId='${corpDutyId}'," +
            "address='${address}', enterDate='${enterDate}' where  employeeId='${employeeId}'  " +
            " </script>"
          )
    public int updateEmployee(Employee employee);
    @Delete("delete from employee where employeeId='${employeeId}'")
    public int deleteEmployee(@Param("employeeId") String employeeId);

}
