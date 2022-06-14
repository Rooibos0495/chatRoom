package com.example.my_books.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.my_books.model.SysUser;

import java.util.List;

/**
 * 管理用户表(SysUser)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2022-04-15 10:46:34
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    //查询全部用户
    List<SysUser> findListUserData();
}
