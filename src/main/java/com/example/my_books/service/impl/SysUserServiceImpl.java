package com.example.my_books.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.my_books.base.Result;
import com.example.my_books.mapper.SysUserMapper;
import com.example.my_books.model.SysUser;
import com.example.my_books.service.SysUserService;
import com.example.my_books.util.JwtUtil;
import com.example.my_books.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 管理用户表(SysUser)�����ʵ����
 *
 * @author makejava
 * @since 2022-04-15 10:46:34
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RedisTemplate<String, Map<String, String>> redisTemplate;

    /**
     * 用户登录验证接口
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Result<Map<String,String>> login(String userName, String password) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUserName,userName)
                            .eq(SysUser::getPassword,password)
                            .eq(SysUser::getStart,1)
                            .eq(SysUser::getIsDelete,0);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);

        if (ObjectUtils.isEmpty(sysUser)){
            return ResultUtil.error("请确认用户名密码是否正确!");
        }
        Map<String, String> map =new HashMap<>();
        map.put("name",sysUser.getUserName());
        map.put("password",sysUser.getPassword());
        //生成token
        String s = JwtUtil.InserToken(map);
        Map<String, String> map1 = new HashMap<>();
        map1.put("token",s);
        map1.put("id",String.valueOf(sysUser.getId()));
        //redis存储数据设置缓存时间为 30 min
        redisTemplate.opsForValue().set(s,map,30, TimeUnit.MINUTES);
            return ResultUtil.success(map1);
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @Override
    public Result<Object> isToken(String token) {
        if (StringUtils.isEmpty(token)){
            return ResultUtil.error("Token不存在请重新登录");
        }
        //校验token的合法性
        JwtUtil.SelectToken(token);

        Object o = redisTemplate.opsForValue().get(token);
        if (ObjectUtils.isEmpty(o)){
            return ResultUtil.error("redis为空");
        }
        return ResultUtil.success(o);
    }


    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public SysUser queryUser(Integer id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        return sysUser ;
    }

    @Override
    public List<SysUser> findListUserData() {
        return sysUserMapper.findListUserData();
    }

    @Override
    public Integer findAddUserInfo(String userName, String password) {

        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        sysUser.setIsAdmin(0); // 0 不是管理员
        sysUser.setStart(1); // 1是正常使用
        sysUser.setCenterTime(new Date());
        sysUser.setIsDelete(0);
        int addInfo = sysUserMapper.insert(sysUser);
        return addInfo;
    }
}
