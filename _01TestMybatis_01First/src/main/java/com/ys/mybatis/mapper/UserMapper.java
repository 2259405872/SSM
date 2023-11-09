package com.ys.mybatis.mapper;

import com.ys.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 插入用户到表
     * @return 插入的数量，负值代表插入失败
     */
    public int insertUser();

    /**
     * 删除用户
     * @return 删除用户的数量，负值代表删除失败
     */
    public int deleteUser();

    /**
     * 修改用户
     * @return 删除用户的数量，负值代表修改失败
     */
    public int updateUser();

    /**
     * 通过id查询用户
     * @return 用户的Bean
     */
    public User getUserById();

    /**
     * 查询所有用户
     * @return 所有用户组成的一个集合
     */
    public List<User> getUserList();
}
