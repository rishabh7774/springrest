package com.springrest.springrest.services;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service
public class courseServiceImpl implements courseService {

//	List<Course> list;
	Course c = null;
	@Autowired
	private CourseDao courseDoa;
	
	public courseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new Course(1,"Java","Java Programming"));
		 * list.add(new Course(2,"Python", "Python Programming"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		/* return list; */
		return courseDoa.findAll();
	}

	@Override
	public Course getCourse(Long courseId) {
		/*
		 * for(Course x : list) { if(x.getId()== courseId) { c = x; break; } }
		 */
		return courseDoa.getById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		/* list.add(course); */
		return courseDoa.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * for(Course c: list) { if(c.getId() == course.getId()) {
		 * c.setTitle(course.getTitle()); c.setDescription(course.getDescription());
		 * return course; } }
		 */
		courseDoa.save(course);
		return course;
	}

	@Override
	public String deleteCourse(long courseId) {
		/*
		 * for(Course x : list) { if(x.getId()== courseId) { list.remove(x); return
		 * "Course Deleted Successfully"; } }
		 */
		courseDoa.delete(courseDoa.getById(courseId));
		return "Course Deleted Successfully";
	}
	

}
