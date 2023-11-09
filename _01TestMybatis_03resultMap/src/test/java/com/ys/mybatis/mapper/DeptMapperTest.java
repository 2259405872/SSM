package com.ys.mybatis.mapper;

import com.ys.mybatis.utils.SqlSessionUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

public class DeptMapperTest extends TestCase {

    public void testGetDeptByStep() {
    }

    public void testGetDeptEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        System.out.println(mapper.getDeptEmpById(1));
    }
}