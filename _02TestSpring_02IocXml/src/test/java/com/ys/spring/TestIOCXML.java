package com.ys.spring;

import com.ys.spring.bean.Clazz;
import com.ys.spring.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCXML {
    @org.junit.Test
    public void testBySet(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student1 = ac.getBean("student1", Student.class);

        System.out.println(student1);
    }

    @org.junit.Test
    public void testByConstructor(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student2 = ac.getBean("student2", Student.class);

        System.out.println(student2);
    }

    @org.junit.Test
    public void testSpecial(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student3", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testClassByRef(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student4", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testClassByInnerBean(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student5", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testClassByJL(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student6", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testArray(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student7", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testList(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Clazz clazz = ac.getBean("clazzTwo", Clazz.class);

        System.out.println(clazz);
    }

    @org.junit.Test
    public void testMap(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student8", Student.class);

        System.out.println(student);
    }

    @org.junit.Test
    public void testCollection(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc_xml.xml");
        Student student = ac.getBean("student9", Student.class);

        System.out.println(student);
    }
}
