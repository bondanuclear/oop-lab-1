package app.servlets;

import DAO.ResultsDB;
import DAO.StudentDB;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req + " LIST REQ");
        Model model = Model.getInstance();
        List<String> names = model.list();
        for (String name:
             names) {
            System.out.println(name + " name is");
        }
        StudentDB studentDB = new StudentDB();
        Connection conn = studentDB.connect_to_db("studentsdb","postgres", "targa" );
        ResultSet rs = studentDB.ReadData(conn, "students_table");

        req.setAttribute("userNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mentorName = req.getParameter("mentor");
        String course = req.getParameter("course");
        String mark = req.getParameter("mark");
        String review = req.getParameter("review");
        ResultsDB db = new ResultsDB();
        Connection conn = db.connect_to_db("resultsdb", "postgres", "targa");
        //db.CreateTable(conn, "Results_Table");
        db.InsertRow(conn,"Results_Table", course, mentorName, name, mark, review);
        // User user = new User(name, course, mentorName);
        // Model model = Model.getInstance();
        //model.add(user);

        /// req.setAttribute("userName", name);
        doGet(req, resp);
    }
}