package dao;

import java.util.Map;

import model.Student;

public interface DaoService {
	 Map<String , Object>viewAll();
	void addMap(Student data);
	 void update(Student data);
	 void put(String name,String Key,Object value);
	 void delete(String name);
	 void saveToFile() ;
	 void loadFromFile();
}
