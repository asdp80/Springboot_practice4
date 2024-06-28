package com.in28minutes.springboot.learnjpaandhibernate.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    //spring jdbc를 사용해서 쿼리 실행할 때
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
            """
                    insert into course(id, name, author)
                    values(?, ?, ?); 
                    """;

    private static String DELECT_QUERY =
            """
                    delete from course
                    where id = ?
                    """;

    private static String SELECT_QUERY =
            """
                   select * from course
                    where id = ?
                    """;


    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());

    }
    public void deletebyID(long id) {
        jdbcTemplate.update(DELECT_QUERY, id);
    }

    public Course findbyID(long id){
       //ResultSet -> Bean mapping -> Row mapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
