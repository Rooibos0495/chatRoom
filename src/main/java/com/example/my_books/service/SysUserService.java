package com.example.my_books.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.my_books.base.Result;
import com.example.my_books.model.SysUser;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 管理用户表(SysUser)�����ӿ�
 *
 * @author makejava
 * @since 2022-04-15 10:46:34
 */

public interface SysUserService extends IService<SysUser> {

    /**
     * 用户登录验证接口
     * @param userName
     * @param password
     * @return
     */
    Result<Map<String, String>> login(String userName, String password);

    /**
     * 验证token
     * @param token
     * @return
     */
    Result<Object> isToken(String token);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    SysUser queryUser(Integer id);

    //查询全部用户
    List<SysUser> findListUserData();

    //添加用户信息
    Integer findAddUserInfo(String userName, String password);
}
