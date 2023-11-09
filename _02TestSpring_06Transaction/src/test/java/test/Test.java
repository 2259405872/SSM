package test;

import com.ys.spring.pojo.Emp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcTemplateContext.xml")
public class Test {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //测试增删改功能
    public void testUpdate(){
        String sql = "insert into t_emp (emp_name, age, gender) values(?,?,?)";
        int result = jdbcTemplate.update(sql, "张三", 23, "男");
        System.out.println(result);
    }

    //测试增删改功能
    //查询一条数据为一个实体类对象
    public void testSelectEmpById(){
        String sql = "select * from t_emp where emp_id = ?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                (Emp.class), 1);
        System.out.println(emp);
    }

    //查询多条数据为一个list集合
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>
                (Emp.class));
        list.forEach(emp -> System.out.println(emp));
    }

    //查询单行单列的值
    public void selectCount(){
        String sql = "select count(emp_id) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
