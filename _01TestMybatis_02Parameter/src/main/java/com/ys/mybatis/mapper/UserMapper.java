package com.ys.mybatis.mapper;

import com.ys.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {
/*
5.1、单个字面量类型的参数
    若mapper接口中的方法参数为单个的字面量类型
    此时可以使用${}和#{}以任意的名称获取参数的值，注意${}需要手动加单引号
*/
    /**
     * 插入用户到表
     * @return 插入的数量，负值代表插入失败
     */
//    public int insertUser(String username);
/*
5.3、map集合类型的参数
    若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在
    只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
            map中
*/
    public int insertUser(Map<String, String> map);

    /**
     * 删除用户
     * @return 删除用户的数量，负值代表删除失败
     */
    public int deleteUser();
/*
5.2、多个字面量类型的参数
            若mapper接口中的方法参数为多个时
    此时MyBatis会自动将这些参数放在一个map集合中，以arg0,arg1...为键，以参数为值；以
    param1,param2...为键，以参数为值；因此只需要通过${}和#{}访问map集合的键就可以获取相
            对应的
    值，注意${}需要手动加单引号
*/
    /**
     * 修改用户
     * @return 删除用户的数量，负值代表修改失败
     */
    public int updateUser(int id, String username);
    /**
     * 查询所有用户
     * @return 所有用户组成的一个集合
     */
    public List<User> getUserList();


/*
5.4、实体类类型的参数
            若mapper接口中的方法参数为实体类对象时
    此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
*/
    public int insertByUser(User user);
/*
5.5、使用@Param标识参数
    可以通过@Param注解标识mapper接口中的方法参数
    此时，会将这些参数放在map集合中，以@Param注解的value属性值为键，以参数为值；以
    param1,param2...为键，以参数为值；只需要通过${}和#{}访问map集合的键就可以获取相对应
    的值，
    注意${}需要手动加单引号
*/
    /**
     * 通过id查询用户
     * @return 用户的Bean
     */
    public User getUserById(@Param("id") int id);
//6.5、查询多条数据为map集合
    //方式一:
    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此
    时可以将这些map放在一个list集合中获取
     */
    public List<Map<String, Object>> getAllUserToMapList();
    //方式二:
    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，并
    且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的
    map集合
     */
    @MapKey("id")
    public Map<String, Object> getAllUserToMap();

    /**
     * 测试模糊查询
     * @param mohu
     * @return
     */
    public List<User> testMohu(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteMore(@Param("ids") String ids);

    /**
     * 动态设置表名，查询所有的用户信息
     * @param tableName
     * @return
     */
    public List<User> getAllUser(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
    数user对象的某个属性中
     */
    public int insertUserAuto(User user);

}
