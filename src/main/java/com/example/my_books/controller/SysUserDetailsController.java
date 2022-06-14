package com.example.my_books.controller;

import com.example.my_books.model.SysUserDetails;
import com.example.my_books.service.SysUserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.ServerSocket;

@RestController
@RequestMapping("/sysUserDetails")
public class SysUserDetailsController {

    @Resource
    private SysUserDetailsService sysUserDetailsService;

    @GetMapping("/oneUserDetails/{id}")
    public SysUserDetails findByUserDetailsId(@PathVariable("id") String id){
        return sysUserDetailsService.findByUserDetailsId(id);
    }

    @PostMapping("/addUserDetails")
    public Integer findByAddUserDetails(@RequestBody SysUserDetails sysUserDetails){
        return sysUserDetailsService.findByAddUserDetails(sysUserDetails);
    }

    @GetMapping("/queryUserDetails/{queryType}")
    public SysUserDetails findByLikeUser(@PathVariable("queryType") String queryType){
        System.out.println(queryType);
        return sysUserDetailsService.findByLikeUser(queryType);
    }
}
