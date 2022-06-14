package com.example.my_books.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.my_books.mapper.SysUserDetailsMapper;
import com.example.my_books.model.SysUserDetails;
import com.example.my_books.service.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysUserDetailsImpl extends ServiceImpl<SysUserDetailsMapper, SysUserDetails> implements SysUserDetailsService {

    @Resource
    private SysUserDetailsMapper sysUserDetailsMapper;


    @Override
    public SysUserDetails findByUserDetailsId(String id) {
        QueryWrapper<SysUserDetails> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(SysUserDetails::getUserId,id)
                .eq(SysUserDetails::getIsDelete,0);
        SysUserDetails sysUserDetails = sysUserDetailsMapper.selectOne(wrapper);
        return sysUserDetails;
    }

    @Override
    public Integer findByAddUserDetails(SysUserDetails sysUserDetails) {

        SysUserDetails data = new SysUserDetails();
        data.setUserId(sysUserDetails.getUserId());
        data.setAvatar(sysUserDetails.getAvatar());
        data.setDescribeUser(sysUserDetails.getDescribeUser());
        data.setUserName(sysUserDetails.getUserName());
        data.setRemarks(sysUserDetails.getRemarks());
        data.setPhone(sysUserDetails.getPhone());
        data.setCity(sysUserDetails.getCity());
        data.setIsDelete(0);
        data.setCenterTime(new Date());
        int insert = sysUserDetailsMapper.insert(data);
        return insert;
    }

    @Override
    public SysUserDetails findByLikeUser(String queryType) {
        QueryWrapper<SysUserDetails> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(SysUserDetails::getUserName,queryType)
                .eq(SysUserDetails::getIsDelete,0);
        return sysUserDetailsMapper.selectOne(wrapper);
    }
}
