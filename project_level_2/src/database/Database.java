package database;

import java.util.*;

public class Database {
	
	private Map<String,Object> temporary_database = new HashMap<>();
	
	private static Database object = null;

	//achiving a single ton object creation
	//once the object is created the same object only return;
	public static Map<String, Object> getTemporary_database() {
		if(object != null) {
			return object.temporary_database;
		}
		else {
			object =  new Database();
			return object.temporary_database;
		}
	}
}
