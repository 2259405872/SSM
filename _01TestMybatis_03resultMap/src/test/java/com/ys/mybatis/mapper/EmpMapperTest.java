package com.ys.mybatis.mapper;

import com.ys.mybatis.utils.SqlSessionUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

public class EmpMapperTest extends TestCase {

    public void testGetEmpByEmpId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        System.out.println(mapper.getEmpByEmpId(1));
    }
    public void testGetEmpByEmpIdMapResult(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpByEmpIdMapResult(2));
    }

    public void testGetEmpAndDeptById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpAndDeptById(3));
    }
}