package com.newer.servcie;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.tool.MD5;
import com.newer.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 13:37
 */
public class LogReg {

    private UserMapper userMapper;
   private    SqlSessionFactory sqlSessionFactory;
    /**
     * 初始化userMapper
     */
    private  void init(){
     sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);

    }
    /**
     * 登录校验
     * @param userName 用户名
     * @param pwd 密码
     * @return 如果根据账号密码能查到user不为null就登录成功
     */
    public User islogin (String userName , String pwd){
        init();
        User user =null;
        //对密码进行加密
        String pwd1= MD5.getInstance().getMD5ofStr(pwd);
        user =  userMapper.findByUserNameAndpwd(userName,pwd1);
        return user;
    }

    /**
     * 注册校验
     * @param user
     * @return
     */
    public  boolean isreg(User user){
        init();
        boolean f = false;
     String userName = user.getUserName();
     User user1 =  userMapper.findByUserName(userName);
       if(user1==null){
           //给密码加密
           user.setPassword( MD5.getInstance().getMD5ofStr(user.getPassword()));
           userMapper.addUser(user);
           f=true;
       }
        return f;
    }

}
