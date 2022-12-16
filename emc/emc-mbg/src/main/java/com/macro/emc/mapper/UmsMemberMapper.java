package com.macro.emc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.emc.model.UmsMember;


import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);


    UmsMember selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);
}
