package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import doa.Dao;
import exception.StudentProjectException;
import model.Student;

public class ServiceImpl {
	Dao dao = new Dao();
	public ArrayList<Student> viewAll() throws StudentProjectException, SQLException {
	    ArrayList<Student> allData = dao.viewAll();
	    if (allData.isEmpty()) {
	        System.out.println("No students found!");
	        return new ArrayList<>();
	    }else{
	    	return allData;
	    }
	}

	public void addMap(Student data) throws Exception{
		dao.addMap(data);
	}
	public void update(Student data) throws Exception{
		dao.update(data);
	}
//	public void put() throws Exception{
//		Dao dao = new Dao();
//		String Key="",name="";Object value = null;
//		Student data = new Student();
//		System.out.println("please enter the name of the student : ");
//		name = obj.nextLine();
////		Map<String, Object> all_data = dao.viewAll();
////		if(!all_data.containsKey(name)) {
////			throw new StudentProjectException("the given name is not exsist!");
////		}
////		else {
//			System.out.println("please enter the data you want to change : ");
//			Key = obj.nextLine();
//			System.out.println("please enter the value : ");
//			value = obj.nextLine();
//			
////		}
//		dao.put(name,Key,value);
//	}
	public void delete(int id) throws Exception{

		dao.delete(id);
	}
	public Student search(String key,Object value) throws StudentProjectException, SQLException {
		Dao dao = new Dao();
	    Student s =  dao.getByName(key,value);
	    return s;
	}
}
