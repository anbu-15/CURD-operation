package com.example.demo;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired
	StudentDB studentdb;

	@RequestMapping("/studentDetails")
	public String index() {
		return "fbhome.jsp";
	}
	@RequestMapping("Student")
	public ModelAndView addUser(Student stud) {
		
		System.out.println(stud.getIdNo());
		System.out.println(stud.getstudentName());
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("Studentdetails",stud);
		mv.setViewName("added.jsp");
		studentdb.save(stud);
		
		return mv;
		
	}
	@RequestMapping("viewStudent")
	public ModelAndView display(Student stud) {
		
		Optional<Student> op=studentdb.findById(stud.getIdNo());
		Student student=op.get();
		ModelAndView mv=new ModelAndView();
		mv.addObject("Studentdetails",student);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	@RequestMapping("deleteStudent")
public ModelAndView deleteData(Student stud) {
		
		studentdb.deleteById(stud.getIdNo());
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("Studentdetails",stud);
		mv.setViewName("deleted.jsp");
		
		return mv;
		
	}
	@RequestMapping("updateStudent")
	public ModelAndView updateUser(Student stud) {
		studentdb.updateStudent(stud.getstudentName(),stud.getIdNo());
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("Studentdetails",stud);
		mv.setViewName("Updated.jsp");
		return mv;
	}

}
