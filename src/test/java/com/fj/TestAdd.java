package com.fj;

import com.fj.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestAdd {
    @Test
    public void testSelectStu(){
        String resource = "mybatis-cofig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            String id="com.fj.dao.StudentDao.selectStu";
            List<Student> studentList=sqlSession.selectList(id);
            for (Student stu : studentList){
                System.out.println(stu);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testInsertStu(){
        String resource = "mybatis-cofig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            String id="com.fj.dao.StudentDao"+"."+"insertStu";
            Student student=new Student(3,"ww",24);
            int date=sqlSession.insert(id,student);
           System.out.println(date);
           sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSelectStuById(){
        String resource = "mybatis-cofig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            String id="com.fj.dao.StudentDao"+"."+"selectStuById";
            List<Student> stu=sqlSession.selectList(id,2);
          for(Student Stu: stu){
              System.out.println(Stu);
          }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
