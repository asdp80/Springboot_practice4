package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.SecureRandom;
import java.util.List;

//spring data jpa 이용할때는 인터페이스 활용한다.
//jparepository라는 특정 인터페이스를 extends로 상속 받아야 한다.
//
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

List<Course> findByAuthor(String author);

}
