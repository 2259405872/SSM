package mybatis;

import com.ys.mybatis.mapper.UserMapper;
import com.ys.mybatis.pojo.User;
import com.ys.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestUserMapper {

    @Test
    public void testInsert() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, String> map=new HashMap<String, String>();
        map.put("username","admin1");
        map.put("password","yssyyc");
        int i = mapper.insertUser(map);
        System.out.println("结果:"+i);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("结果："+mapper.deleteUser());
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("结果："+mapper.updateUser(2,"admin2"));
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("结果："+mapper.getUserById(8));
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("结果："+mapper.getUserList());
    }

    @Test
    public void testInsertByUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null,"ys","yssyyc",20,"男","123456@qq.com");

        System.out.println("结果："+mapper.insertByUser(user));
    }

    @Test
    public void testGetAllUserToMapList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Map<String,Object>> list =mapper.getAllUserToMapList();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map =mapper.getAllUserToMap();
        map.values().forEach(System.out::println);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null,"yc","123456",20,"女","123156");
        int i=mapper.insertUserAuto(user);
        System.out.println("结果:"+i+"\n"+"id:"+user.getId());
    }
}
