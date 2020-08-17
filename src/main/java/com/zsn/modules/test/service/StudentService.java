package com.zsn.modules.test.service;


import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.pojo.SearchVo;
import com.zsn.modules.test.pojo.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Result<Student> insertStudent(Student student);

    Student getStudentByStudentId(int studentId);

    Page<Student> getStudentsBySearchVo(SearchVo searchVo);

    List<Student> findByStudentName(String studentName,int cardId);
}
