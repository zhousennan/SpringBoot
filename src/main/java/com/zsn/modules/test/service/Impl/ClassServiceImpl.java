package com.zsn.modules.test.service.Impl;


import com.zsn.modules.test.mapper.ClassMapper;
import com.zsn.modules.test.pojo.Class;
import com.zsn.modules.test.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
@Resource
ClassMapper classMapper;

    @Override
    public List<Class> queryAllClass() {
        List<Class> classes = classMapper.queryAllClass();
        return classes;
    }
}
