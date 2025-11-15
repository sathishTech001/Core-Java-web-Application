package service;

import java.util.Map;
import java.util.Scanner;

import utils.Util;
import model.Student;

public class ServiceImpl {
	
	private Util util = new Util();
	private Scanner obj = new Scanner(System.in);
	public void viewAll(){
		System.out.println(util.viewAll());
	}
	public void addMap(){
		Map<String, Object> all_data = util.viewAll();
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
			System.out.println("the given name is already exsist!");
		}
		else {
			util.addMap(data);
		}
		System.out.println("Data inserted  successfully");
	}
	public void update(){
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		data.setName(obj.nextLine());
		Map<String, Object> all_data = util.viewAll();
		if(!all_data.containsKey(data.getName())) {
			System.out.println("the given name is not exsist!");
		}
		else {
			System.out.println("please enter the age : ");
			data.setAge(obj.nextInt());
			obj.nextLine();
			System.out.println("please enter the gender : ");
			data.setGender(obj.nextLine());
			System.out.println("please enter the  year : ");
			data.setYear(obj.nextLine());
			System.out.println("please enter the department : ");
			data.setDepartment(obj.nextLine());
			util.update(data);
		}
		System.out.println("Data updated  successfully");
	}
	public void put(){
		String Key="",name="";Object value = null;
		Student data = new Student();
		System.out.println("please enter the name of the student : ");
		name = obj.nextLine();
		Map<String, Object> all_data = util.viewAll();
		if(!all_data.containsKey(name)) {
			System.out.println("the given name is not exsist!");
		}
		else {
			System.out.println("please enter the data you want to change : ");
			Key = obj.nextLine();
			System.out.println("please enter the value : ");
			value = obj.nextLine();
			
		}
		util.put(name,Key,value);
		
		System.out.println("Data put  successfully");
	}
	public void delete(){
		System.out.println("please enter the name of the student : ");
		String name = obj.nextLine();
		Map<String, Object> all_data = util.viewAll();
		if(!all_data.containsKey(name)) {
			System.out.println("the given name is not exsist!");
		}
		util.delete(name);
		System.out.println("Data delete successfully");
	}
}
