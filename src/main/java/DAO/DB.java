package DAO;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    public Connection connect_to_db(String dbname, String user, String pass)
    {
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
            if(conn!= null)
            {
                System.out.println("connection established successfully");
            }
            else System.out.println("Connection failed");
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return conn;

    }
    public void CreateTable(Connection conn, String table_name)
    {
        Statement statement;
        try {
            String query = "create table " + table_name +"(courseId SERIAL,courseName varchar(200),mentorName varchar(200),primary key(courseId));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e)
        {
            System.out.println("exception" + e);
        }
    }
    public void InsertRow(Connection conn, String tableName, String courseName, String mentorName)
    {
        Statement statement;
        try
        {
            String query = String.format("insert into %s(courseName,mentorName) values('%s','%s');", tableName, courseName, mentorName);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted successfully");
        } catch (Exception exception)
        {
            System.out.println(exception);
        }

    }
    public ResultSet ReadData(Connection conn, String tableName)
    {
        Statement statement;
        ResultSet rs = null;
        try
        {
            String query = String.format("select * from %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
//            while(rs.next())
//            {
//                System.out.print(rs.getString("courseId") + " ");
//                System.out.print(rs.getString("courseName") + " ");
//                System.out.println(rs.getString("mentorName") + " ");
//
//            }
        } catch (Exception exception)
        {
            System.out.println(exception);
        }
        return rs;
    }
    public void UpdateName(Connection conn,String tableName, String old_name, String new_name)
    {
        Statement statement;
        try
        {
            String query = String.format("update %s set courseName ='%s' where courseName = '%s'", tableName, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("course name has been updated");
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
}
