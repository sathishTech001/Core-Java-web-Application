package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Student;
import service.ServiceImpl;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    
    private ServiceImpl service = new ServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String option = req.getParameter("option") != null ? req.getParameter("option") : "";

        try {
            String idStr = req.getParameter("id");
            Student data = new Student();
            data.setName(req.getParameter("name"));
            data.setAge(Integer.parseInt(req.getParameter("age")));
            data.setGender(req.getParameter("gender"));
            data.setYear(req.getParameter("year"));
            data.setDepartment(req.getParameter("department"));

            switch (option) {
                case "addStudent":
                    service.addMap(data);
                    break;
                case "update":
                    data.setId(Integer.parseInt(idStr));
                    service.update(data);
                    break;
                default:
                    System.out.println("Unknown option: " + option);
            }

            // after operation, redirect to list page
            resp.sendRedirect("student?option=list");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String option = req.getParameter("option") != null ? req.getParameter("option") : "list";

        try {
            switch (option) {
                case "new":
                    req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
                    break;

                case "edit":
                    int id = Integer.parseInt(req.getParameter("id"));
                    Student s = service.search("id", id);
                    req.setAttribute("student", s);
                    req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
                    break;

                case "delete":
                    int deleteId = Integer.parseInt(req.getParameter("id"));
                    service.delete(deleteId);
                    resp.sendRedirect("student?option=list");
                    break;

                default:
                    List<Student> list = service.viewAll();
                    req.setAttribute("students", list);
                    req.getRequestDispatcher("listStudents.jsp").forward(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
