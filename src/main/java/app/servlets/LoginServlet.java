package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req + " REQ LOGIN");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        Model model = Model.getInstance();
        if(name.equals(model.GetLogin()) && password.equals(model.GetPassword()))
        {
            System.out.println(model.list().size() + " SIZE ");
            //req.setAttribute("userName", name);
            //doGet(req,resp);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
//            requestDispatcher.forward(req, resp);
            resp.sendRedirect("http://localhost:8080/list");
        } else
        {
            System.out.println("Osechka");
            doGet(req,resp);
        }
       // doGet(req,resp);

    }
}
