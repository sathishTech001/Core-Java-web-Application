package utils;

import java.util.HashMap;
import java.util.Map;
import database.Database;
import model.Student;

public class Util {
	
	private Map<String , Object> local_storage =  Database.getTemporary_database();

	public Map<String , Object>viewAll(){
		 Map<String , Object> data = new HashMap<String, Object>();
		 data.putAll(local_storage);
		return data; 
	}
	public void addMap(Student data){
		data.setId(local_storage.size()+1);
		local_storage.put(data.getName(), data);
	}
	public void update(Student data){
		local_storage.put(data.getName(), data);
	}
	public void put(String name,String Key,Object value){
		Student data = new Student();
		data =  (Student) local_storage.get(name);
		switch (Key) {
		case "name":
			data.setName(""+value);
			break;
		case "age":
			data.setAge((int)value);
			break;
		case "year":
			data.setYear(""+value);
			break;
		case "department":
			data.setDepartment(""+value);
			break;
		case "active":
			data.setActive((boolean)value);
			break;
		case "gender":
			data.setGender(""+value);
			break;

		default:
			break;
		}
		local_storage.put(name, data);
	}
	public void delete(String name){
		local_storage.remove(name);
	}
}
