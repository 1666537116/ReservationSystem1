package com.newer;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.servcie.LogReg;
import com.newer.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 14:46
 */
public class test {
   // private UserMapper userMapper;


    /**
     * 初始化userMapper
     */
    /*@Before
    private  void init(){

        SqlSessionFactory    sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper  userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper);
    }*/
    @Test
     public  void testfindByUserName(){

        SqlSessionFactory    sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //System.out.println(sqlSessionFactory);
         SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper  userMapper = sqlSession.getMapper(UserMapper.class);
        //System.out.println(userMapper);
       // LogReg logReg = new LogReg();


         User user = userMapper.findByUserName("lqs") ;
         System.out.println(user.toString());
     }

    @Test
    public  void testadduser(){

        SqlSessionFactory    sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper  userMapper = sqlSession.getMapper(UserMapper.class);
        //System.out.println(userMapper);
        // LogReg logReg = new LogReg();
   User user = new User();
     user.setPassword("1111");
     user.setPhone("666666");
     user.setUserName("dddd");
       userMapper.addUser(user);
        System.out.println(user);
        //User user11 = userMapper.findByUserName("dddd") ;
       //System.out.println(user.toString());
    }

    @Test
    public  void testisreg(){
 LogReg logReg = new LogReg();
   // User user = new User();
   // user.setUserName("aaa");
    //.setPassword("111111");
       // System.out.println(logReg.isreg(user));
       // System.out.println(user);
    User user =    logReg.islogin("aaa","111111");
        System.out.println(user);
    }
}
