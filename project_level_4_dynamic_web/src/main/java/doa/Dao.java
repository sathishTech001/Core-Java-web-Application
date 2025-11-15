package doa;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exception.StudentProjectException;
import model.Student;
import utils.DBWapper;

public class Dao {

	public ArrayList<Student> viewAll() throws StudentProjectException, SQLException{
		Statement sm = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			con = DBWapper.getConnection();
			String query = "Select * from masterdb.student_details ";
			sm = con.createStatement();
		    rs = sm.executeQuery(query);
		    while (rs.next()) {
	            Student student = new Student();
	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setAge(rs.getInt("age"));
	            student.setGender(rs.getString("gender"));
	            student.setYear(rs.getString("year"));
	            student.setDepartment(rs.getString("department"));
	            student.setActive(rs.getBoolean("isActive"));
	            studentList.add(student);
	        }
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new StudentProjectException(" find customer error "+e.getMessage());
		}finally {
			rs.close();
			con.close();
			sm.close();
		}
		return studentList; 
	}
	public Student getByName(String key,Object value) throws StudentProjectException, SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBWapper.getConnection();
			String query = "Select * from masterdb.student_details where "+key+"= '"+value+ "' Limit 1 ";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				Student student = new Student();
	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setAge(rs.getInt("age"));
	            student.setGender(rs.getString("gender"));
	            student.setYear(rs.getString("year"));
	            student.setDepartment(rs.getString("department"));
	            student.setActive(rs.getBoolean("isActive"));
	            return student;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new StudentProjectException(" find customer error ");
		}finally {
			if(con!=null )con.close();
		}
		return null; 
	}
	public void addMap(Student data) throws Exception{
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DBWapper.getConnection();
			String query = "INSERT INTO masterdb.student_details (name,age,gender,year,department,isActive) value (?,?,?,?,?,?)";
		    ps = con.prepareStatement(query);
		    ps.setString(1, data.getName());
		    ps.setInt(2, data.getAge());
		    ps.setString(3, data.getGender());
		    ps.setString(4,data.getYear());
		    ps.setString(5, data.getDepartment());
		    ps.setBoolean(6, data.isActive());
		    boolean is_done = ps.execute();
		    if(!is_done) {
		    	System.out.println("insert completed ");
		    }
		    else {
		    	System.out.println("insert failed ");
		    }
		}catch (Exception e) {
			e.printStackTrace();
			throw new StudentProjectException("while insert get this error : "+e);
		}finally {
			ps.close();
			con.close();
		}
	}
	public void update(Student data) throws Exception{
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DBWapper.getConnection();
			String query = "Update masterdb.student_details set name=?,age=?,gender=?,year=?,department=? where name = ?";
		    ps = con.prepareStatement(query);
		    ps.setString(1, data.getName());
		    ps.setInt(2, data.getAge());
		    ps.setString(3, data.getGender());
		    ps.setString(4,data.getYear());
		    ps.setString(5, data.getDepartment());
		    ps.setString(6, data.getName());
		    if(!ps.execute()) {
		    	System.out.println("updated completed successfully");
		    }
		}catch (Exception e) {
			e.printStackTrace();
			throw new StudentProjectException("while update get this error : "+e);
		}finally {
			ps.close();
		}
	}
	public void put(String name, String key, Object value) throws Exception {
	    PreparedStatement ps = null;
	    Connection con = null;

	    try {
	        con = DBWapper.getConnection();

	        // Build query dynamically
	        String query = "UPDATE student_details SET " + key + " = ? WHERE name = ?";
	        ps = con.prepareStatement(query);

	        // Handle value type safely
	        if (value instanceof Integer) {
	            ps.setInt(1, (Integer) value);
	        } else if (value instanceof Boolean) {
	            ps.setBoolean(1, (Boolean) value);
	        } else {
	            ps.setString(1, value.toString());
	        }

	        ps.setString(2, name);

	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("Update completed successfully for " + name);
	        } else {
	            System.out.println("No record found for name: " + name);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new StudentProjectException("Error during update: " + e.getMessage());
	    } finally {
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }
	}

	public void delete(int id) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBWapper.getConnection();
			String query = "delete from masterdb.student_details where id ="+id;
		    ps = con.prepareStatement(query);
		    if(!ps.execute()) {
		    	System.out.println("delete completed successfully");
		    }
		}catch (Exception e) {
			e.printStackTrace();
			throw new StudentProjectException("while delete get this error : "+e);
		}finally {
			ps.close();
			con.close();
		}
	}

}
