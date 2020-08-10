package com.zsn.service.ClasssServiceImpl;

import com.zsn.mapper.ClassMapper;
import com.zsn.pojo.Class;
import com.zsn.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
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
