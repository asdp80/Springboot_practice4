package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner는 bean이 springApplication 안에 포함되어 있을 때 실행된다는 의미로 쓰이는 인터페이스
//springApplication 시작 시에 실행될 로직이 있을 때 CommandLineRunner를 활용할 수 있다.
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJpaRepository repository;
    //쿼리를 실행한다.

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
    //새 과정을 생성해서 보내야 한다.
        repository.save(new Course(1, "LEARN JAVA", "IN28MINUTES"));
        repository.save(new Course(2, "LEARN AWS", "IN28MINUTES"));
        repository.save(new Course(3, "LEARN C++", "IN28MINUTES"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());

        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("IN28MINUTES"));
        System.out.println(repository.findByAuthor(""));

    }
}
