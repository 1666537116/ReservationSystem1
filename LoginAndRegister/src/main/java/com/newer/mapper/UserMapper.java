package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 13:01
 */
public interface UserMapper {
    //根据用户名查询(注册功能)
    @Select("select * from  user where user_name=#{userName}")
    User findByUserName(String userName);

    //根据用户名和密码查询(登录功能)
    @Select("select * from  user where user_name=#{userName} adn user_pwd=#{pwd}")
    User findByUserNameAndpwd(@Param("userName") String userName, @Param("pwd") String pwd );
}
