package com.employee.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emoloyee.DeletedEmployee;
import com.emoloyee.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeDao;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("message","Welcome to the Employee Management System");
		return "index";		
	}
	
	@RequestMapping("/getForm")
	public String showForm(Model view) {
		view.addAttribute("header","Employee Registration form");
		return "getForm";
	}
	
//   save Employee
	@RequestMapping( path ="/processform", method=RequestMethod.POST )
	public String saveEmp(@ModelAttribute Employee employee ,Model model) {
		
	try {		
		Integer integer = employee.getSalary();
		
		int length = employee.getMobile().length();
		
		if(length == 10) {
			
			if((employee.getName().isEmpty() == false)&&
				(employee.getLastName().isEmpty() == false)&&
				(employee.getDepartment().isEmpty() == false)&&
				(employee.getEmail().isEmpty()== false) &&
				(employee.getAddress().isEmpty() == false) &&(employee.getSalary() != null)){
				
				Employee employee1 = employeeDao.saveEmployee(employee);

				if(employee1 != null) {
					
					model.addAttribute("message","Employee Registration Successfull.");
					return "saveResult";
					
					}else {
						model.addAttribute("message","Employee Already Registered.");
						return "saveResult";							
						}
			
			}else{
				model.addAttribute("message","Employee registration unsuccessfull. Please Make Sure That You Fill All of the Details.");
				return "saveResult";
			}
			
		}else {
			
			model.addAttribute("message","Employee registration unsuccessfull. Please Make Sure that You Have Filled Right Mobile Number.");
			return "saveResult";
		}
	}catch (Exception e) {
			model.addAttribute("message","Employee Registration Unsuccessfull Please Enter Valid Salary");
			return "saveResult";		
		}
	  }
	
	
	
	@RequestMapping( path ="/getAllEmployees", method=RequestMethod.GET )
	public String getAllEmployees(Model model) {
		
		List<Employee> employees =  employeeDao.getAllEmployees();
		if(employees != null) {
			
			model.addAttribute("employees",employees);
			model.addAttribute("employee",new Employee());

			System.out.println("-----" + employees + "------");
			model.addAttribute("message", "Employee List");

			return "getAllEmployees";
			
		}else {
			model.addAttribute("message","No Employee is  Registered");
			return "saveResult";
		}

	}
	
	@RequestMapping( path ="/provideEmployeeEmail")
	public String updateEmployee() {
		return "getEmployeeEmail";
	}
	
	Employee employeeOne;
	String email= "";
	
	@RequestMapping( path ="/updateEployeeByEmail", method=RequestMethod.POST )
	public String updateEmployeeValidation(@ModelAttribute Employee empEmail,Model model) {
		
		System.out.println("inside controllers update by");
		System.out.println(empEmail.getEmail());
		 email = empEmail.getEmail();
		 
		 if(email.isEmpty()) {
			 model.addAttribute("message","No Employee Registered With Provided Email.");
				return "saveResult";
		 }
		 
		System.out.println("inside Controller byEmail ->" + email);
		System.out.println(empEmail.getEmail());
		
		employeeOne =  employeeDao.getEmployeeByEmail(email);
		
		if(employeeOne != null) {
			System.out.println("Inside update Form");
			return "updateEmployeeForm";
		}else {
			model.addAttribute("message","No Employee Registered With Provided Email.");
			return "saveResult";
		}
	}
	
	@RequestMapping( path ="/updateEployeeByEmailProcess", method=RequestMethod.POST )
	public String updateEmployee(@ModelAttribute Employee getEmployee,Model model) {
		 
		System.out.println("process");
		 if(email.isEmpty()) {
			 model.addAttribute("message","No Employee Registered With Provided Email.");
				return "saveResult";
		 }
		 
		System.out.println(employeeOne + "updateEployeeByEmailProcess inside controller");
		
		Employee employee =  employeeDao.updateEmployeeByEmailProcess(getEmployee,employeeOne.getEmail());
		
		if(employee != null) {
			model.addAttribute("message","Employee Details Updated Successfully.");
			return "saveResult";

		}else {
			System.out.println("inside updateProcess");
			model.addAttribute("message","No Employee Registered With Provided Email.");
			return "saveResult";
		}
		
	}
//		----------------------------- Get Employee By ID ---------------------
	
	@RequestMapping( path ="/formToGetEmployeeById")
	public String formToGetEmployeeById( Model model) {
		model.addAttribute("message","Enter the Employee Email to Get Employee details");
		return "getEmployeeByEmail";
	}
	
	@RequestMapping(path="/getEployeeByEmail", method = RequestMethod.GET)
	public String getEployeeByEmail(@ModelAttribute Employee employeeemail,Model model){
		
		if(employeeemail.getEmail().isEmpty()) {
			model.addAttribute("message","No Employee Registered With Provided Email.");
			
			System.out.println("Inside getEmployeeByEamil controller");
			return "saveResult";
		}
		
		List<Employee> employees =  new ArrayList<Employee>();
		
		Employee employeeGetByEmail  = employeeDao.getEmployeeByEmail(employeeemail.getEmail());
		employees.add(employeeGetByEmail);
		
		if(employees.get(0) != null) {
			
			model.addAttribute("employees",employees);
			model.addAttribute("employee", new Employee());

			System.out.println("-----" + employees + "------");
			model.addAttribute("message", "Details of the Employee having the Email " + " " + employeeemail.getEmail() );
			return "showDetails";
			
		}else{
			model.addAttribute("message","Employee Not Registered.");
			return "saveResult";
		}
		
	}
	
//	----------------- delete Employee by email--------------------------
	
	@RequestMapping( path ="/formToDeleteEmployeeById")
	public String formDeleteEmployeeByEmail( Model model) {
		model.addAttribute("message","Enter the Employee Email to Delete Employee details");
		return "deleteEmployeeByEmail";
	}
	
	@RequestMapping(path="/deleteEmployeeByEmail", method = RequestMethod.GET)
	public String deleteEployeeByEmail(@ModelAttribute Employee employeeemail,Model model){
		
		System.out.println("inside delete");
		if(employeeemail.getEmail().isEmpty()) {
			model.addAttribute("message","No Employee Registered With Provided Email.");
			
			System.out.println("Inside getEmployeeByEamil controller");
			return "saveResult";
		}
		
		List<Employee>  employees;
		try {
			
			System.out.println("near list");
			 employees =  new ArrayList<Employee>();
			 Employee employeeGetByEmail  = employeeDao.deleteEmployeeByEmail(employeeemail.getEmail());
			employees.add(employeeGetByEmail);
			
		} catch (Exception e) {
			
			model.addAttribute("message","Employee Not Found.");
			return "saveResult";	
		}
		
		
		if(employees.get(0) != null) {
			
			model.addAttribute("employees",employees);
			model.addAttribute("employee", new Employee());
			
			System.out.println("-----" + employees + "------");
			model.addAttribute("message", "Details of the Deleted Employee Are " );
			return "showDetails";
			
		}else{
			model.addAttribute("message","Employee Not Found.");
			return "saveResult";
		}
		
	}
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[delete employees]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	@RequestMapping( path ="/getAllDeletedEmployees", method=RequestMethod.GET )
	public String getAllDletedEmployees(Model model) {
		
		List<DeletedEmployee> employees =  employeeDao.getAllDeletedEmployees();
		if(employees != null) {
			
			model.addAttribute("employees",employees);
			model.addAttribute("employee",new DeletedEmployee());

			System.out.println("-----" + employees + "------");
			model.addAttribute("message", "Deleted Employee List");

			return "showDetails";
			
		}else {
			model.addAttribute("message","No Employee is  Deleted");
			return "saveResult";
		}

	}
	
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ Update Employee By Id ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	Employee updateEmpById;
	String updateEmpEmail;
	
	@RequestMapping(path="/updateEmployeeById/{id}", method=RequestMethod.GET)
	public String updateEmployeeByID(@PathVariable("id") int id,Model model) {
	
		System.out.println(id);
		updateEmpById = employeeDao.getEmployeeById(id);
		
		updateEmpEmail = updateEmpById.getEmail();
				
		return "updateEmploeeById";		
	}
	
	@RequestMapping(path = "/updateEployeeByIdProcess" , method= RequestMethod.POST)	
	public String updateEployeeByIdProcess(@ModelAttribute Employee getEmployeeId,Model model){
		
		Employee employee = employeeDao.updateEmployeeByEmailProcess( updateEmpById , updateEmpEmail);
		
		model.addAttribute("message","Employee Details Updated Successfully.");
		
	return "saveResult";
	
	}
	
	
//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[Delete Employee By Id]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	Employee deletedEmployee;
	
	@RequestMapping(path="/deleteEmployeeById/{id}", method= RequestMethod.GET)
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		
		deletedEmployee = employeeDao.getEmployeeById(id);
		
		return "redirect:/deleteEmployeeByIdprocess";	
		
	}
	
	@RequestMapping(path="/deleteEmployeeByIdprocess", method = RequestMethod.GET)
	public String deleteEployeeById(Model model){
		
		Employee employeeDelete = employeeDao.deleteEmployeeByEmail(deletedEmployee.getEmail());
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeDelete);
		
			model.addAttribute("employees",employees);
			model.addAttribute("employee", new Employee());
			
			model.addAttribute("message", "Details of the Deleted Employee Are " );
			
			return "showDetails";
		
	}
	
	
	
	
}
