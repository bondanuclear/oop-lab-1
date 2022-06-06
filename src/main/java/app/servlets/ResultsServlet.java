package app.servlets;

import DAO.ResultsDB;
import DAO.StudentDB;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ResultsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req + " Results REQ");

       // db.InsertRow(conn, "Results_Table", "Math analysis", "Q L", );
        //db.ReadData(conn, "Course_Table");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/results.jsp");
        requestDispatcher.forward(req, resp);

    }


}
