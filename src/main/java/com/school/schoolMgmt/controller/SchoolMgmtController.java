package com.school.schoolMgmt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.school.schoolMgmt.model.Course;
import com.school.schoolMgmt.model.CourseAssignment;
import com.school.schoolMgmt.model.Student;
import com.school.schoolMgmt.service.CourseAssignmentService;
import com.school.schoolMgmt.service.CourseService;
import com.school.schoolMgmt.service.StudentService;

@Controller
public class SchoolMgmtController {
	
	private StudentService sservice;
	private CourseService cservice;
	private CourseAssignmentService service;
	@Autowired
    public SchoolMgmtController(StudentService sservice,CourseService cservice,CourseAssignmentService service) {
        this.sservice = sservice;
        this.cservice = cservice;
        this.service = service;
    }
	@PostMapping(value = "/add-course", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewCourse(/*@Valid*/ @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-course";
        }
        if(cservice.checkUniqueRecord(course)){
        	cservice.save(course);
        }
        model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }
	@GetMapping("/map-course")
    public String mapCourse(Model model) {
        model.addAttribute("sc", new CourseAssignment() );
        model.addAttribute("students", sservice.findAll());
        model.addAttribute("courses", cservice.findAll());
        return "map-course";
    }
	@PostMapping(value = "/map-course/{sid}/{cid}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String mapNewCourse(/*@Valid*/ @PathVariable Long sid, @PathVariable Long cid, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "map-course";
        }
        service.saveRecord(sid,cid);
        model.addAttribute("sc", service.findAll());
        model.addAttribute("students", sservice.findAll());
        model.addAttribute("courses", cservice.findAll());
        return "map-course";
    }
	
	@GetMapping
    public String showAllStudentss(Model model) {
        model.addAttribute("students", sservice.findAll());
        model.addAttribute("courses", cservice.findAll());
        return "students";
    }

    @GetMapping("/new-student")
    public String showStudentCreationForm(Model model) {
        model.addAttribute("student", new Student());
        return "new-student";
    }
    @PostMapping(value = "/add-student", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewStudent(/*@Valid*/ @ModelAttribute Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-student";
        }
        if(sservice.checkUniqueRecord(student)){
        	sservice.save(student);
        }
        model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String showStudentdById(@PathVariable Long id, Model model) {
    	Student student = sservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "edit-student";
    }
    
    @PutMapping("/{id}/update")
    public String updateStudent(@PathVariable Long id, /*@Valid*/ @ModelAttribute Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-student";
        }
        sservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        System.out.println("Student"+student.getSid()+" name "+student.getSname());
        student.setSid(id);
        sservice.save(student);
        model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }
    @PutMapping("/{id}/update-course")
    public String updateCourse(@PathVariable Long id, /*@Valid*/ @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-course";
        }
        cservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        System.out.println("Course"+course.getCid()+" course name "+course.getCourseName());
        course.setCid(id);
        cservice.save(course);
        model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id, Model model) {
    	sservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    	sservice.deleteById(id);
    	model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }
    
    @PostMapping("/{id}/delete-course")
    public String deleteCourse(@PathVariable Long id, Model model) {
    	cservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
    	cservice.deleteById(id);
    	model.addAttribute("courses", cservice.findAll());
        model.addAttribute("students", sservice.findAll());
        return "students";
    }
    @GetMapping("/new-course")
    public String showCourseCreationForm(Model model) {
        model.addAttribute("course", new Course());
        return "new-course";
    }
    
    @GetMapping("/{id}/edit-course")
    public String showCourseById(@PathVariable Long id, Model model) {
    	Course course = cservice.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course", course);
        return "edit-course";
    }
    
    
    @GetMapping("/get-course-by-sid/(sid)")
    public String showAssignedCoursesToStudent(@PathVariable Long sid, Model model) {
    	Set<Course> courses = cservice.findByStudentId(sid);
        model.addAttribute("courses", courses);
        return "map-course";
    }
    
    @GetMapping("/get-student-by-cid/(cid)")
    public String showAssignedStudentToCourse(@PathVariable Long cid, Model model) {
    	Set<Student> students = sservice.findByStudentId(cid);
        model.addAttribute("students", students);
        return "map-course";
    }
    
    @GetMapping("/get-course-not-assigned")
    public String showNotAssignedCoursesToStudent(Model model) {
    	Set<Course> courses = cservice.notMappedWithAnyCourse();
        model.addAttribute("courses", courses);
        return "map-course";
    }
    
    @GetMapping("/get-student-not-assigned")
    public String showNotAssignedStudentToCourse(Model model) {
    	Set<Student> students = sservice.notMappedWithAnyCourse();
        model.addAttribute("students", students);
        return "map-course";
    }
}
