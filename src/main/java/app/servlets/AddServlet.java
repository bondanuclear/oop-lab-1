package app.servlets;

import DAO.DB;
import DAO.StudentDB;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req + " REQ ");
        //DB db = new DB();
        //Connection conn = db.connect_to_db("courses", "postgres", "targa");
        //db.CreateTable(conn, "Course_Table");
        //db.InsertRow(conn, "Course_table", "Math analysis", "Q L");
        //db.ReadData(conn, "Course_Table");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mentorName = req.getParameter("mentor");

        String course = req.getParameter("course");
        StudentDB studentDB = new StudentDB();
        Connection conn = studentDB.connect_to_db("studentsdb","postgres", "targa" );
        //studentDB.CreateTable(conn, "Students");
        studentDB.InsertRow(conn, "Students", course, mentorName, name);
        User user = new User(name, course, mentorName);
        Model model = Model.getInstance();
        model.add(user);

        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
