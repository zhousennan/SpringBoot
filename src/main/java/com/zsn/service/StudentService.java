package com.zsn.service;

import com.zsn.pojo.Result;
import com.zsn.pojo.Student;

public interface StudentService {
    public Result<Student> insertStudent(Student student);
}
