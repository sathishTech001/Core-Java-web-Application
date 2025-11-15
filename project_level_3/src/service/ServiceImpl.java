package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import doa.Dao;
import exception.StudentProjectException;
import model.Student;

public class ServiceImpl {
	
	private Scanner obj = new Scanner(System.in);
	public void viewAll() throws StudentProjectException, SQLException {
		Dao dao = new Dao();
	    ArrayList<Student> allData = dao.viewAll();
	    if (allData.isEmpty()) {
	        System.out.println("No students found!");
	        return;
	    }

	    System.out.println("--------------------------------------------------------------------------------");
	    System.out.printf("%-5s %-15s %-5s %-10s %-10s %-15s %-8s%n", 
	                      "ID", "Name", "Age", "Gender", "Year", "Department", "Active");
	    System.out.println("--------------------------------------------------------------------------------");
	    
	    for (Student obj : allData) {
	        Student s = (Student) obj;
	        System.out.printf("%-5d %-15s %-5d %-10s %-10s %-15s %-8s%n",
	                          s.getId(), s.getName(), s.getAge(),
	                          s.getGender(), s.getYear(),
	                          s.getDepartment(), s.isActive());
	    }
	    System.out.println("--------------------------------------------------------------------------------");
	}

	public void addMap() throws Exception{
		Dao dao = new Dao();
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		data.setName(obj.nextLine());
		System.out.println("please enter the age : ");
		data.setAge(obj.nextInt());
		obj.nextLine();
		System.out.println("please enter the gender : ");
		data.setGender(obj.nextLine());
		System.out.println("please enter the  year : ");
		data.setYear(obj.nextLine());
		System.out.println("please enter the department : ");
		data.setDepartment(obj.nextLine());
		dao.addMap(data);
	}
	public void update() throws Exception{
		Dao dao = new Dao();
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
//		Map<String, Object> all_data = util.viewAll();
//		if(!all_data.containsKey(name)) {
//			throw new StudentProjectException("the given name is not exsist!");
//		}
//		else {
			data.setName(name);
			System.out.println("please enter the age : ");
			data.setAge(obj.nextInt());
			obj.nextLine();
			System.out.println("please enter the gender : ");
			data.setGender(obj.nextLine());
			System.out.println("please enter the  year : ");
			data.setYear(obj.nextLine());
			System.out.println("please enter the department : ");
			data.setDepartment(obj.nextLine());
			dao.update(data);
//		}
	}
	public void put() throws Exception{
		Dao dao = new Dao();
		String Key="",name="";Object value = null;
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		name = obj.nextLine();
//		Map<String, Object> all_data = dao.viewAll();
//		if(!all_data.containsKey(name)) {
//			throw new StudentProjectException("the given name is not exsist!");
//		}
//		else {
			System.out.println("please enter the data you want to change : ");
			Key = obj.nextLine();
			System.out.println("please enter the value : ");
			value = obj.nextLine();
			
//		}
		dao.put(name,Key,value);
	}
	public void delete() throws Exception{
		Dao dao = new Dao();
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
//		Map<String, Object> all_data = util.viewAll();
//		if(!all_data.containsKey(name)) {
//			throw new StudentProjectException("the given name is not exsist!");
//		}
		dao.delete(name);
		System.out.println("Data delete successfully");
	}
	public void search() throws StudentProjectException {
		Dao dao = new Dao();
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
	    Student s =  dao.getByName(name);
	    if(s!=null) {
	    	
	    System.out.println("--------------------------------------------------------------------------------");
	    System.out.printf("%-5s %-15s %-5s %-10s %-10s %-15s %-8s%n", 
	                      "ID", "Name", "Age", "Gender", "Year", "Department", "Active");
	    System.out.println("--------------------------------------------------------------------------------");
	    
	        System.out.printf("%-5d %-15s %-5d %-10s %-10s %-15s %-8s%n",
	                          s.getId(), s.getName(), s.getAge(),
	                          s.getGender(), s.getYear(),
	                          s.getDepartment(), s.isActive());
	    System.out.println("--------------------------------------------------------------------------------");
	    }
	}
}
