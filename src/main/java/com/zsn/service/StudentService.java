package com.zsn.service;


import com.zsn.pojo.Result;
import com.zsn.pojo.SearchVo;
import com.zsn.pojo.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Result<Student> insertStudent(Student student);

    Student getStudentByStudentId(int studentId);

    Page<Student> getStudentsBySearchVo(SearchVo searchVo);

    List<Student> findByStudentName(String studentName,int cardId);
}
