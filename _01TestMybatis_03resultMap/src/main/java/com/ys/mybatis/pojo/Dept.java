package com.ys.mybatis.pojo;

import java.util.List;

public class Dept {
    private Integer DeptId;
    private String  DeptName;
    List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        DeptId = deptId;
        DeptName = deptName;
    }

    public Integer getDeptId() {
        return DeptId;
    }

    public void setDeptId(Integer deptId) {
        DeptId = deptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "DeptId=" + DeptId +
                ", DeptName='" + DeptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
