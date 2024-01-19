package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService pservice;
	
	@GetMapping("/getemployee")
	public ModelAndView getEmployee(HttpSession session) {
		MyUser u = (MyUser)session.getAttribute("user");
		
		if(u!=null) {
			List<Employee> plist = pservice.getAllEmployee();
			return new ModelAndView("displayemployee","plist",plist);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/insert")
	public String displayAddForm(HttpSession session) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user!=null) {
			return "addemployee";
		}
		return "redirect:/login/";
	}
	
	@PostMapping("/insertemployee")
	public ModelAndView insertEmployee(@RequestParam("pid") int id,@RequestParam("pname") String name, @RequestParam String gender,@RequestParam double price) {
		Employee p = new Employee(id,name,gender,price);
		pservice.addNewEmployee(p);
		return new ModelAndView("redirect:/employee/getemployee");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editEmployee(HttpSession session,@PathVariable int id) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user != null) {
			Employee p = pservice.getById(id);
			return new ModelAndView("editemployee","p",p);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@PostMapping("/updateemployee")
	public ModelAndView updateEmployee(@RequestParam("pid") int id,@RequestParam("pname") String name, @RequestParam String gender,@RequestParam double price) {
		Employee p = new Employee(id,name,gender,price);
		pservice.updateEmployee(p);
		return new ModelAndView("redirect:/employee/getemployee");
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteById(@PathVariable("id") int id,HttpSession session) {
		MyUser user = (MyUser)session.getAttribute("user");
		if(user != null) {
			pservice.deleteById(id);
			return new ModelAndView("redirect:/employee/getemployee");
		}
		return new ModelAndView("redirect:/login/");
	}
	@GetMapping("/login/")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/";
	}
}
