package com.newer.mapper;

import com.newer.domain.User;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 13:01
 */
public interface UserMapper {
    //根据用户名查询
    User findByUserName(String userName);
}
