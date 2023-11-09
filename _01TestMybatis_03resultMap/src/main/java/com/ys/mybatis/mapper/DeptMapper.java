package com.ys.mybatis.mapper;

import com.ys.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 根据dept_id查询部门信息
     *
     * @param id
     * @return
     */
    public Dept getDeptByStep(@Param("id") int id);

    /**
     * 根据部门id查新部门以及部门中的员工信息
     *
     * @param id
     * @return
     */
    public Dept getDeptEmpById(@Param("id") int id);
}
