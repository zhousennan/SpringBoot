package com.zsn.controller;

import com.zsn.pojo.Result;
import com.zsn.pojo.SearchVo;
import com.zsn.pojo.Student;
import com.zsn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 127.0.0.1/api/student ---- post
     * {"studentName":"hujiang1","studentCard":{"cardId":"1"}}
     */
    @PostMapping(value = "student", consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }


    /**
     * @param studentId 127.0.0.1/student/1=====get
     */
    @GetMapping(value = "student/{studentId}")
    public Student getStudentByStudentId(@PathVariable("studentId") int studentId) {
        return studentService.getStudentByStudentId(studentId);
    }

    /**
     * 127.0.0.1/api/students ---- post
     * {"currentPage":"1","pageSize":"5","keyWord":"hu","orderBy":"studentName","sort":"desc"}
     */
//    @GetMapping(value = "students", consumes = "application/json")
//    public Page<Student> getStudentsBySearchVo(@RequestBody SearchVo searchVo) {
//        return studentService.getStudentsBySearchVo(searchVo);
//    }

    /**
     * 127.0.0.1/api/students?studentName=hujiang ---- get
     */
    @GetMapping(value = "/students")
    public List<Student> findByStudentName(@RequestParam String studentName,
                                           @RequestParam(required = false, defaultValue = "0") Integer cardId ) {
        return studentService.findByStudentName(studentName,cardId);
    }
}
