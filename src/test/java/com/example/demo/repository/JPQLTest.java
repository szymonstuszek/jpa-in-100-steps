package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.entities.Course;
import com.example.demo.entities.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpqlCoursesWithoutStudents() {
        TypedQuery<Course> query = em.createQuery(
                "SELECT c FROM Course c WHERE c.students IS EMPTY", Course.class
        );
        List<Course> courses = query.getResultList();

        logger.info("Courses without students: " + courses);
    }

    @Test
    public void jpqlCoursesWithAtLeast2Students() {
        TypedQuery<Course> query = em.createQuery(
                "SELECT c FROM Course c WHERE SIZE(c.students) >= 2", Course.class
        );
        List<Course> courses = query.getResultList();

        logger.info("Courses at least 2 students: " + courses);
    }

    @Test
    public void join() {
        Query query = em.createQuery("SELECT c, s FROM Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Results size: " + resultList.size());

        for (Object[] result : resultList) {
            logger.info("{} - {}" , result[0], result[1]);
        }
    }

    @Test
    public void leftJoin() {
        Query query = em.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Results size: " + resultList.size());

        for (Object[] result : resultList) {
            logger.info("{} - {}" , result[0], result[1]);
        }
    }
}
