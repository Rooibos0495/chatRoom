package com.example.my_books.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.my_books.model.SysUserDetails;

public interface SysUserDetailsService extends IService<SysUserDetails> {

    //根据用户id查询用户信息（初始化用户信息）
    SysUserDetails findByUserDetailsId(String id);

    //添加一个用户信息
    Integer findByAddUserDetails(SysUserDetails sysUserDetails);

    //查询要添加的好友
    SysUserDetails findByLikeUser(String queryType);
}
