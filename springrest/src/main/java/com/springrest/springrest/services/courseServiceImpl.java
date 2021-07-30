package com.springrest.springrest.services;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;


@Service
public class courseServiceImpl implements courseService {

	List<Course> list;
	Course c = null;
	
	public courseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1,"Java","Java Programming"));
		list.add(new Course(2,"Python", "Python Programming"));
	}
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(Long courseId) {
		for(Course x : list)
		{
			if(x.getId()== courseId)
			{
				c = x;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		for(Course c: list)
		{
			if(c.getId() == course.getId())
			{
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				return course;
			}
		}
		return course;
	}

	@Override
	public String deleteCourse(long courseId) {
		for(Course x : list)
		{
			if(x.getId()== courseId)
			{
				list.remove(x);
				return "Course Deleted Successfully";
			}
		}
		return "Course Not Found";
	}
	

}
