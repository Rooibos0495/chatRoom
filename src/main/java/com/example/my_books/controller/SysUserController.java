package com.example.my_books.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.my_books.base.Result;
import com.example.my_books.common.ResponseMsg;
import com.example.my_books.model.SysUser;
import com.example.my_books.service.SysUserService;
import com.example.my_books.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 管理用户表(SysUser)����Ʋ�
 *
 * @author makejava
 * @since 2022-04-15 10:46:34
 */
@RestController
@RequestMapping("/sysUser")
//@CrossOrigin
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 用户登录验证接口
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("/login")
     public Result<Map<String, String>> login(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return sysUserService.login(userName,password);
    }

    /**
     * 获取用户个人信息
     * @param id
     * @return
     */
    @GetMapping("/queryUser")
    public SysUser queryUser(@RequestParam Integer id){
        SysUser sysUser = sysUserService.queryUser(id);
        return sysUser;
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/allUserData")
    public ResponseMsg findListUserData(){
        ResponseMsg responseMsg = new ResponseMsg();
        List<SysUser> listUserData = sysUserService.findListUserData();
        return responseMsg.setData(listUserData).setMsg("查询成功");
    }

    /**
     * 添加一个用户
     */
    @PostMapping("/addUserInfo")
    public Integer findAddUserInfo(@RequestParam("userName") String userName,@RequestParam("password") String password){
        Integer addUserInfo = sysUserService.findAddUserInfo(userName, password);
        return addUserInfo;
    }
}
