package com.fj.dao;
import com.fj.domain.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> selectStu();
    public int insertStu(Student student);
    public Student selectStuById( int id);
}
