package com.ys.mybatis.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ys.mybatis.pojo.Emp;
import com.ys.mybatis.pojo.EmpExample;
import com.ys.mybatis.utils.SqlSessionUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

public class Test extends TestCase {
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andAgeBetween(19,25);
        System.out.println(mapper.selectByExample(empExample));
    }

    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Page<Emp> page = PageHelper.offsetPage(0, 3);
        System.out.println(mapper.selectByExample(null));
    }

}