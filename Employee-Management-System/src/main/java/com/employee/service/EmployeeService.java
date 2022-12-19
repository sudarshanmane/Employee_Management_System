package com.employee.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.emoloyee.DeletedEmployee;
import com.emoloyee.Employee;

@Component
public class EmployeeService implements EmployeeInterface{

	public Employee saveEmployee(Employee employee) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("Select e from Employee e where e.email=:em");
		query.setParameter("em", employee.getEmail());

		Employee employee2 = null;
		try {
			employee2 = (Employee) query.list().get(0);
			System.out.println(employee2);

		}catch(Exception e){
			
			employee2=null;
			
		}
		
		System.out.println(employee2);
	
		if(employee2 == null) {
			session.save(employee);	
			employee2 = employee;
		}else {
			employee2=null;
		}
		
		
		transaction.commit();
		session.close();
		factory.close();
		return employee2;
	
	}

	public List<Employee> getAllEmployees() {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			System.out.println("inside getAll ---------");
			Query query = session.createQuery("Select e from Employee e");
			
			List<Employee> employees= (List<Employee>) query.list();
			System.out.println(employees);
			System.out.println("inside service");
			
			transaction.commit();

			session.close();
			factory.close();
			
			return employees;

		}catch(Exception e){
			
			session.close();
			factory.close();
			return null;
		}
		
		
	}

	public Employee getEmployeeByEmail(String email) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee2 = null;
		
		try {
			System.out.println(email + " inside service");
			Query query = session.createQuery("Select e from Employee e where e.email=:em");
			query.setParameter("em",email);

			employee2 = (Employee) query.list().get(0);
			System.out.println(employee2);
		}catch(Exception e){
			
			employee2=null;
			
		}
		System.out.println(employee2);
		
		transaction.commit();
		session.close();
		factory.close();
		
		return employee2;
	}

	
	public Employee updateEmployeeByEmailProcess(Employee employeeUpdate ,String email) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("Select e from Employee e where e.email=:em");
		query.setParameter("em",email);
		Employee employee2 = (Employee) query.list().get(0);
		
		
		System.out.println("inside updateEmployeeByEmailProcess service" + employee2 );

		
		try {
			
			System.out.println("inside try of updateEmployeeByEmailProcess service");
			Employee getEmployee =(Employee) session.get(Employee.class, employee2.getId());

//			name
			 if(employeeUpdate.getName().isEmpty()) {
			 }{
				 getEmployee.setName(employeeUpdate.getName());
			 }
			 
//			 lastName
			 if(employeeUpdate.getLastName().isEmpty()) {
			 }else {
				 getEmployee.setLastName(employeeUpdate.getLastName());;
			 }
			 
//			 Department
			 if(employeeUpdate.getDepartment().isEmpty()) {
			 }else {
				 getEmployee.setDepartment(employeeUpdate.getDepartment());
			 }
			 
//			 Mobile
			 if(employeeUpdate.getMobile().isEmpty()) {
			 }else {
				 getEmployee.setMobile(employeeUpdate.getMobile());
			 }
//			 address
			 if(employeeUpdate.getAddress().isEmpty()) {
			 }else {
				 getEmployee.setAddress(employeeUpdate.getAddress());
			 }
			 
//			 salary
			 if(employeeUpdate.getSalary() == null) {
			 }else {
				 getEmployee.setSalary(employeeUpdate.getSalary());
			 }
			 
			 session.update(getEmployee);
			
			transaction.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return employeeUpdate;
	}

	
	public Employee deleteEmployeeByEmail(String email) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("Select e from Employee e where e.email=:em");
		query.setParameter("em",email);
		
		Employee employee2 = (Employee) query.list().get(0);
		
		System.out.println("inside DeleteEmployeeByEmailProcess service" + employee2 );
		
		try {
			
			System.out.println("inside try of updateEmployeeByEmailProcess service");
			Query query1 = session.createQuery("Delete From Employee e where e.email=:em");
			
			query1.setParameter("em",email);
			query1.executeUpdate();
			
			DeletedEmployee deletedEmployee = new DeletedEmployee();
			
			deletedEmployee.setName(employee2.getName());
			deletedEmployee.setLastName(employee2.getLastName());
			deletedEmployee.setDepartment(employee2.getDepartment());
			deletedEmployee.setMobile(employee2.getMobile());
			deletedEmployee.setEmail(employee2.getEmail());
			deletedEmployee.setAddress(employee2.getAddress());
			deletedEmployee.setSalary(employee2.getSalary());
			
			session.save(deletedEmployee);
			transaction.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return employee2;
	}
	
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[get all deleted employees]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
	
	public List<DeletedEmployee> getAllDeletedEmployees() {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			System.out.println("inside getAll ---------");
			Query query = session.createQuery("Select e from DeletedEmployee e");
			
			List<DeletedEmployee> employees= (List<DeletedEmployee>) query.list();
			System.out.println(employees);
			System.out.println("inside deleted service");
			
			transaction.commit();

			session.close();
			factory.close();
			
			return employees;

		}catch(Exception e){
			
			session.close();
			factory.close();
			return null;
		}
		
	}
	
//	[[[[[[[[[[[[[[[[[[[[[[[[[[[Update Employee By Id]]]]]]]]]]]]]]]]]]]]]]]]]]]


	public Employee getEmployeeById(Integer empId) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
			Employee employee = (Employee) session.get(Employee.class, empId);
			
			transaction.commit();
			session.close();
			factory.close();
			
		return employee;
		
		
	}

}
