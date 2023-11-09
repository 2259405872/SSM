package com.ys.mybatis.mapper;

import com.ys.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    public Emp getEmpByEmpId(@Param("id") int id);
    public Emp getEmpByEmpIdMapResult(@Param("id") int id);
    public Emp getEmpAndDeptById(@Param("id") int id);
    /**
     * 根据部门id查询员工信息
     * @param deptId
     * @return
     */
    public List<Emp> getEmpByDeptId(@Param("id") int deptId);
    public List<Emp> getEmpListByMoreTJ(Emp emp);
    public List<Emp> getEmpListByMoreTJ2(Emp emp);
    public List<Emp> getEmpListByMoreTJ3(Emp emp);
    public List<Emp> getEmpListByChoose(Emp emp);
    public int insertMoreEmp(List<Emp> emps);
    public int deleteMoreByArray(int[] empIds);
}
