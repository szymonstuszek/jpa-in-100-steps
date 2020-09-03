package com.example.demo.repository;

import com.example.demo.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = em.find(Course.class, id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    //flush - sends the current changes to the database
    public void entityManagerFlush() {
        logger.info("Playing with entity manager.");

        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);
        em.flush();

        course1.setName("UPDATE - Web Services in 100 steps");
        em.flush();

        Course course2 = new Course("Bootstrap in 100 steps");
        em.persist(course2);
        em.flush();

        em.detach(course2);

        course2.setName("UPDATE - Bootstrap in 100 steps");
        em.flush();
    }

    //detach - stops tracking of an entity
    public void entityManagerDetachCourse() {
        logger.info("Playing with entity manager.");

        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);
        em.flush();

        em.detach(course1);

        course1.setName("UPDATE - Web Services in 100 steps");
        em.flush();
    }

    public void entityManagerRefresh() {
        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);
        Course course2 = new Course("Bootstrap in 100 steps");
        em.persist(course2);

        em.flush();

        course1.setName("UPDATE - Web Services in 100 steps");
        course2.setName("UPDATE - Bootstrap in 100 steps");

        em.refresh(course1);

        em.flush();
    }

    public void updateTimestamp() {
        Course course = new Course("JHipster course");

        Course savedCourse = save(course);

        Long savedCourseId = savedCourse.getId();

        Course retrievedCourse = findById(savedCourseId);

        retrievedCourse.setName("UPDATED - JHipster course");
    }
}
