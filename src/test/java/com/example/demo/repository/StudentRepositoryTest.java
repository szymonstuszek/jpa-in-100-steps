package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.entities.Course;
import com.example.demo.entities.Passport;
import com.example.demo.entities.Student;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Autowired
    StudentRepository courseRepository;

    @Test
    @Transactional
    public void retrieveStudentWithPassport() {
        Student student = em.find(Student.class, 20001L);

        Passport passport = student.getPassport();

        passport.setNumber("X123456");

        student.setName("Updated name");
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport", passport);
        logger.info("associated student", passport.getStudent().toString());
    }
}
