package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    // 测试
    // http://localhost:8080/index
    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "hello index";
    }

    @Autowired
    private UserService userService;

    // http://localhost:8080/getReceiveAddressByMemberId?memberId=1
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

    // 查询所有
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    // 根据id查询 http://localhost:8080/getUserById?id=1
    @RequestMapping("getUserById")
    @ResponseBody
    public UmsMember getUserById(String id){
        return userService.getUserById(id);
    }

    // 根据id删除 http://localhost:8080/deleteUserById?id=10
    @RequestMapping("deleteUserById")
    @ResponseBody
    public int deleteUserById(String id){
        try {
            int i = userService.deleteUserById(id);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 增加一条数据
    public int addUser(){
        try {
            UmsMember umsMember = new UmsMember();
            umsMember.setId("10");
            umsMember.setMemberLevelId("4");
            int i = userService.insertUser(umsMember);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return  0;
        }
    }





}
