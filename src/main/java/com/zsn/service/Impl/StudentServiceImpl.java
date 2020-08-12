package com.zsn.service.Impl;

import com.zsn.pojo.Result;
import com.zsn.pojo.Student;
import com.zsn.repository.StudentRepository;
import com.zsn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Transactional
    public Result<Student> insertStudent(Student student){
        studentRepository.saveAndFlush(student);
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,
                "insert success",student);
    }
}
