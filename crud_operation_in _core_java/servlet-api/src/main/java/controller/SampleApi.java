package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class SampleApi extends HttpServlet {
	
	private static List<Map<String, Object>> users = new ArrayList<>();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException {
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    String json = new Gson().toJson(users);
	    resp.getWriter().write(json);
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
    	BufferedReader br = req.getReader();
    	String line;
    	StringBuilder sb = new StringBuilder();
    	while((line = br.readLine())!=null) {
    		sb.append(line);
    	}
    	//service (logic implementation)
    	String status = "already customer exsit!";
    	Map<String,Object> data = new Gson().fromJson(sb.toString(), Map.class);
    	
    	double id = (Double) data.get("id");
    	int cast_int = (int) id;
    	String name =  (String)data.get("name");
    	String password = (String) data.get("password");
    	Map<String, Object> insertData = new HashMap<String, Object>();
    	boolean customer_exsit = false;
    	for(Map<String, Object> user : users) {
    		if((int)user.get("id")==cast_int) {
    			customer_exsit = true;
    		}
    	}
   		if(!customer_exsit) {
    		insertData.put("id",cast_int);
    		insertData.put("name",name);
    		insertData.put("password",password);
    		users.add(insertData);
    		status = "completed to insert the element";
		}
    	System.out.println(users);
    	//declaring response 
    	resp.setContentType("application/json");
    	resp.setCharacterEncoding("UTF-8");
    	System.out.println(status);
    	resp.getWriter().write("{\"status\":\"Success\",\"message\":\""+status+"\"}");
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
    	BufferedReader br = req.getReader();
    	String line;
    	StringBuilder sb = new StringBuilder();
    	while((line = br.readLine())!=null) {
    		sb.append(line);
    	}
    	//service
    	String status = "customer not exsit!";
    	Map<String,Object> data = new Gson().fromJson(sb.toString(), Map.class);
    	
    	double id = (Double) data.get("id");
    	int cast_int = (int) id;
    	String name =  (String)data.get("name");
    	String password = (String) data.get("password");
    	Map<String, Object> insertData = new HashMap<String, Object>();
    	for(Map<String, Object> user : users) {
    		if((int)user.get("id")==cast_int) {
    			user.put("name",name);
    			user.put("password",password);
	    		status = "completed to update the element";
	    		break;
    		}
    	}
    	System.out.println(users);
    	//declaring response 
    	resp.setContentType("application/json");
    	resp.setCharacterEncoding("UTF-8");
    	System.out.println(status);
    	resp.getWriter().write("{\"status\":\"Success \",\"message\":\""+status+"\"}");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	int id =  Integer.parseInt(req.getParameter("id"));
    	users.removeIf(j-> (Integer)j.get("id")==id);
    	resp.setContentType("application/json");
    	resp.setCharacterEncoding("UTF-8");
    	resp.getWriter().write("{\"status\":\"Success \",\"message\":\"successfully completed\"}");
    }
}