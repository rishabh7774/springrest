package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springrest.springrest.services.*;

import com.springrest.springrest.entities.*;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private courseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
	 	return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/courses", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping(path="/courses",consumes = "application/json")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Long.parseLong(courseId));
	}
}
