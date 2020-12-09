package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 继承通用 Mapper；
 * 单表通用简单的增删改查可以不用编写，调用方法即可；
 * 联表复杂的还是得手写sql查询语句。
 */
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
