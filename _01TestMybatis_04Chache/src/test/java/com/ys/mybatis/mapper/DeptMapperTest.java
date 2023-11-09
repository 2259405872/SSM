package com.ys.mybatis.mapper;

import com.ys.mybatis.utils.SqlSessionUtil;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DeptMapperTest extends TestCase {

    public void testFirstLevelCache() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        /*
        一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就
        会从缓存中直接获取，不会从数据库重新访问
        */
        System.out.println(mapper.selectDeptById(1));
        System.out.println(mapper.selectDeptById(1));

        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        DeptMapper mapper1 = sqlSession1.getMapper(DeptMapper.class);
        System.out.println(mapper1.selectDeptById(1));
    }

    public void testSecondLevelCache() throws IOException {
/*
        二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被
        缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        DeptMapper mapper1 = sqlSession1.getMapper(DeptMapper.class);
        System.out.println(mapper1.selectDeptById(1));
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        DeptMapper mapper2 = sqlSession2.getMapper(DeptMapper.class);
        System.out.println(mapper2.selectDeptById(1));
        sqlSession2.close();
    }

}