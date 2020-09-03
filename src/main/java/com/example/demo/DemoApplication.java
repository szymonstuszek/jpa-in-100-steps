package com.example.demo;

import com.example.demo.entities.Course;
import com.example.demo.entities.Review;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Review> reviews = new ArrayList<>();
//
//        Review firstReview = new Review();
//        firstReview.setRating("5");
//        firstReview.setDescription("My favourite course.");
//
//        Review secondReview = new Review();
//        secondReview.setRating("2");
//        secondReview.setDescription("Not enough content.");
//
//        reviews.add(firstReview);
//        reviews.add(secondReview);
//
//        courseRepository.addReviewsForCourse(10001L, reviews);
    }
}
