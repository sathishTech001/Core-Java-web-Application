package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import database.Database;
import model.Student;

public class DaoServiceImpl implements DaoService{
	
	private Map<String , Object> local_storage =  Database.getTemporary_database();
	private final String FILE_NAME = "student.csv";

	public DaoServiceImpl() {
	        loadFromFile(); // Load existing students when app starts
	}
	public Map<String , Object>viewAll(){
		 Map<String , Object> data = new HashMap<String, Object>();
		 data.putAll(local_storage);
		return data; 
	}
	public void addMap(Student data){
		data.setId(local_storage.size()+1);
		local_storage.put(data.getName(), data);
		saveToFile();
	}
	public void update(Student data){
		local_storage.put(data.getName(), data);
		saveToFile();
	}
	public void put(String name,String Key,Object value){
		Student data = new Student();
		data =  (Student) local_storage.get(name);
		switch (Key) {
		case "name":
			data.setName(""+value);
			break;
		case "age":
		    data.setAge(Integer.parseInt(value.toString()));
		    break;
		case "year":
			data.setYear(""+value);
			break;
		case "department":
			data.setDepartment(""+value);
			break;
		case "active":
		    data.setActive(Boolean.parseBoolean(value.toString()));
		    break;
		case "gender":
			data.setGender(""+value);
			break;

		default:
			break;
		}
		local_storage.put(name, data);
		saveToFile();
	}
	public void delete(String name){
		local_storage.remove(name);
		saveToFile();
	}
	
	// Save all students to CSV
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Object obj : local_storage.values()) {
                Student s = (Student) obj;
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," +
                             s.getGender() + "," + s.getYear() + "," +
                             s.getDepartment() + "," + s.isActive());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load students from CSV when program starts
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; // No file yet

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Student s = new Student();
                    s.setId(Integer.parseInt(parts[0]));
                    s.setName(parts[1]);
                    s.setAge(Integer.parseInt(parts[2]));
                    s.setGender(parts[3]);
                    s.setYear(parts[4]);
                    s.setDepartment(parts[5]);
                    s.setActive(Boolean.parseBoolean(parts[6]));
                    local_storage.put(s.getName(), s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
    
}
