package com.zsn.service.Impl;

import com.github.pagehelper.util.StringUtil;
import com.zsn.pojo.Result;
import com.zsn.pojo.SearchVo;
import com.zsn.pojo.Student;
import com.zsn.repository.StudentRepository;
import com.zsn.service.StudentService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
        return new Result<Student>(Result.ResultStatus.SUCCESS.status,
                "insert success", student);
    }

    @Override
    public Student getStudentByStudentId(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Page<Student> getStudentsBySearchVo(SearchVo searchVo) {
        //获取orderby
        String orderBy = StringUtils.isBlank(searchVo.getOrderBy()) ?
                "studentId" : searchVo.getOrderBy();
        //获取direction
        Sort.Direction direction = StringUtils.isBlank(searchVo.getSort()) ||
                searchVo.getSort().equalsIgnoreCase("asc") ?
                Sort.Direction.ASC : Sort.Direction.DESC;
        //排序 对象
        Sort sort = Sort.by(direction, orderBy);
        //设置页和大小
        Pageable pageable = PageRequest.of(searchVo.getCurrentPage() - 1, searchVo.getPageSize(), sort);

        Student student = new Student();
        student.setStudentName(searchVo.getKeyWord());

        ExampleMatcher matcher = ExampleMatcher.matching().
                // 全部模糊查询，即 %{studentName} %
                        withMatcher("studentName", match -> match.contains()).
                // 忽略字段，即不管id是什么值都不加入查询条件
                        withIgnorePaths("studentId");
        // where studentName=student.getName  matcher是一种匹配
        Example<Student> example = Example.of(student, matcher);
        return studentRepository.findAll(example, pageable);
    }

    @Override
    public List<Student> findByStudentName(String studentName, int cardId) {

        //第一种
//        return Optional.
//                ofNullable(studentRepository.findByStudentName(studentName)).
//                orElse(Collections.emptyList());
//        第二种
/*        return Optional
               .ofNullable(studentRepository.findByStudentNameLike(
                        String.format("%s%S%s", "%", studentName, "%")))
               .orElse(Collections.emptyList());*/
        if (cardId > 0) {

            return Optional.ofNullable(studentRepository.getStudentsByParams(studentName, cardId)).
                    orElse(Collections.emptyList());
        } else {
            return Optional
                    .ofNullable(studentRepository.findTop2ByStudentNameLike(
                            String.format("%s%S%s", "%", studentName, "%")))
                    .orElse(Collections.emptyList());
        }
    }
}
