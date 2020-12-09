package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        // 调用自定义sql语句查询方法
        //List<UmsMember> umsMembers = userMapper.selectAllUser();
        // 通用Mapper方法
        List<UmsMember> umsMembers = userMapper.selectAll();
        return umsMembers;
    }

    // ***************************使用通用 mapper 分界线************************************
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        // 封装参数对象
        /*UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        // 查询
        List<UmsMemberReceiveAddress> receiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);*/

        Example example = new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId", memberId);
        List<UmsMemberReceiveAddress> receiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        return receiveAddresses;
    }

    @Override
    public UmsMember getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUserById(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int insertUser(UmsMember umsMember) {
        int i = userMapper.insertSelective(umsMember);
        return i;
    }
}
