package com.zsn;

import com.zsn.mapper.ClassMapper;
import com.zsn.pojo.Class;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBoot03ApplicationTests {
@Resource
    ClassMapper classMapper;
    @Test
    void contextLoads() {
        List<Class> classes = classMapper.queryAllClass();
        for (Class aClass : classes) {
            System.out.println(aClass);
        }

    }

}
