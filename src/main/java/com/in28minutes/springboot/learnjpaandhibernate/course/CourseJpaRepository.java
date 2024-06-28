package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    //엔티티 관리함
    private final EntityManager entityManager;

    public CourseJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findbyID(long id){
        return entityManager.find(Course.class, id);
    }

    public void deletebyID(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.merge(course);
    }
}
