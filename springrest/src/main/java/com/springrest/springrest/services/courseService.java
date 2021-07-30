package com.springrest.springrest.services;
import java.util.List;

import com.springrest.springrest.entities.*;

public interface courseService {
	
	public List<Course> getCourses();

	public Course getCourse(Long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public String deleteCourse(long parseLong);

}
