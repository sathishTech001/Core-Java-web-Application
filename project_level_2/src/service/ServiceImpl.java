package service;

import java.util.Map;
import dao.*;
import java.util.Scanner;
import model.Student;
import exception.StudentProjectException;
import dao.*;
public class ServiceImpl {
	
	private Scanner obj = new Scanner(System.in);
	private DaoServiceImpl service = new DaoServiceImpl();
	public void viewAll() {
	    Map<String, Object> allData = service.viewAll();
	    if (allData.isEmpty()) {
	        System.out.println("No students found!");
	        return;
	    }

	    System.out.println("--------------------------------------------------------------------------------");
	    System.out.printf("%-5s %-15s %-5s %-10s %-10s %-15s %-8s%n", 
	                      "ID", "Name", "Age", "Gender", "Year", "Department", "Active");
	    System.out.println("--------------------------------------------------------------------------------");
	    
	    for (Object obj : allData.values()) {
	        Student s = (Student) obj;
	        System.out.printf("%-5d %-15s %-5d %-10s %-10s %-15s %-8s%n",
	                          s.getId(), s.getName(), s.getAge(),
	                          s.getGender(), s.getYear(),
	                          s.getDepartment(), s.isActive());
	    }
	    System.out.println("--------------------------------------------------------------------------------");
	}

	public void addMap() throws StudentProjectException{
		Map<String, Object> all_data = service.viewAll();
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
		
		if(all_data.containsKey(data.getName())) {
			throw new StudentProjectException("the given name is already exsist!");
		}
		else {
			service.addMap(data);
		}
		System.out.println("Data inserted  successfully");
	}
	public void update() throws StudentProjectException{
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
		Map<String, Object> all_data = service.viewAll();
		if(!all_data.containsKey(name)) {
			throw new StudentProjectException("the given name is not exsist!");
		}
		else {
			data = (Student) all_data.get(name);
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
			service.update(data);
		}
		System.out.println("Data updated  successfully");
	}
	public void put() throws StudentProjectException{
		String Key="",name="";Object value = null;
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		name = obj.nextLine();
		Map<String, Object> all_data = service.viewAll();
		if(!all_data.containsKey(name)) {
			throw new StudentProjectException("the given name is not exsist!");
		}
		else {
			System.out.println("please enter the data you want to change : ");
			Key = obj.nextLine();
			System.out.println("please enter the value : ");
			value = obj.nextLine();
			
		}
		service.put(name,Key,value);
		
		System.out.println("Data put  successfully");
	}
	public void delete() throws StudentProjectException{
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
		Map<String, Object> all_data = service.viewAll();
		if(!all_data.containsKey(name)) {
			throw new StudentProjectException("the given name is not exsist!");
		}
		service.delete(name);
		System.out.println("Data delete successfully");
	}
	public void search() throws StudentProjectException{
		String name="";
		System.out.println("please enter the name of the student : ");
		name = obj.nextLine();
		Map<String, Object> all_data = service.viewAll();
		if(!all_data.containsKey(name)) {
			throw new StudentProjectException("the given name is not exsist!");
		}
		else {
			System.out.println(all_data.get(name));
		}
	}
}
