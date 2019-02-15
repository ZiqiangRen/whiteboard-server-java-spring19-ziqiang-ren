package com.example.whiteboardsp19.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.whiteboardsp19.model.Course;
import com.example.whiteboardsp19.model.Module;



@RestController
public class CourseService {
	private static CourseService instance = new CourseService();
	List<Course> courses = new ArrayList<Course>();
	private CourseService() {
		Course cs5610 = new Course(123, "CS5610");
		Course cs4500 = new Course(234, "CS4500");
		Module cs4500W1 = new Module(123, "Week 1");
		Module cs4500W2 = new Module(234, "Week 2");
		//Course[] courses = {cs5610, cs4500};
		List<Module> cs4500Modules = new ArrayList<Module>();
		{
			cs4500Modules.add(cs4500W1);
			cs4500Modules.add(cs4500W2);
			cs4500.setModules(cs4500Modules);
			courses.add(cs4500);
			courses.add(cs5610);
		}
	}

 public static CourseService getInstance(){
      return instance;
   }
	
	@DeleteMapping("/api/courses/{id}")
	public List<Course> deleteCourse(
			@PathVariable("id") int courseId) {
		courses = courses.stream()
					.filter(course -> course.getId() != courseId)
					.collect(Collectors.toList());
		return courses;
	}
	
	
	@PutMapping("/api/courses/{courseId}")
	public Course updateCourse(
			@PathVariable("courseId") Integer id,
			@RequestBody Course newCourse) {
		for(Course course: courses) {
			if(course.getId().equals(id)) {
				course.setTitle(newCourse.getTitle());
				return course;
			}
		}
		return null;
	}
	
	@PostMapping("/api/courses")
	public List<Course> createCourse(
			@RequestBody Course course) {
		course.setId((int)(Math.random() * 1000));
		courses.add(course);
		return courses;
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses() {
		return courses;
	}
	@GetMapping("/api/courses/{courseId}")
	public Course findCourseById(
			@PathVariable("courseId") Integer id) {
		for(Course course: courses) {
			if(course.getId().equals(id)) {
				return course;
			}
		}
		return null;
	}

}
