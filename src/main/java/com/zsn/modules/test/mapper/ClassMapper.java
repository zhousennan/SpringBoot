package com.zsn.modules.test.mapper;

import com.zsn.modules.test.pojo.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    int deleteByPrimaryKey(Integer claasId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer claasId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> queryAllClass();
}