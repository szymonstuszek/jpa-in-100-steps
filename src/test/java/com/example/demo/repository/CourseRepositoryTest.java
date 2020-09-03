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
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void testSaveCourse() {
        Course newCourse = new Course("Angular in 500 steps.");
        Course savedCourse = courseRepository.save(newCourse);

        assertEquals("Angular in 500 steps.", savedCourse.getName());
        assertNotNull(savedCourse.getId());
    }

    @Test
    @DirtiesContext
    public void testUpdateCourse() {
        Course course = courseRepository.findById(10001L);
        course.setName("Updated name.");

        courseRepository.save(course);

        Course savedCourse = courseRepository.findById(10001L);

        assertEquals("Updated name.", savedCourse.getName());
        assertEquals(10001L, savedCourse.getId());
    }

    @Test
    void testJPQLSampleQuery() {
        List resultList = em.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    void testJPQLTypedQuery() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("Select c From Course c -> {}", courses);
    }

    @Test
    @Transactional
    void testPersistCourseWithCourseNameNull() {
        Course course = new Course(null);

        assertThrows(PersistenceException.class, () -> em.persist(course));
    }

    @Test
    void testCheckUpdateTimestamp() {
        courseRepository.updateTimestamp();
    }

    @Test
    @DirtiesContext
    void testPlayWithEntityManager() {
        courseRepository.entityManagerRefresh();
    }

    @Test
    @Transactional
    @DirtiesContext
    void testRetrieveReviewsForCourse() {
        Course course = courseRepository.findById(10001L);

        logger.info("course.getReviews() - > {}", course.getReviews());
    }
}
