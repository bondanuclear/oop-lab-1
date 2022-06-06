package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDB extends DB {
    public void CreateTable(Connection conn, String table_name)
    {
        Statement statement;
        try {
            String query = "create table " + table_name +"(courseId SERIAL,courseName varchar(200),mentorName varchar(200),studentName varchar(200), primary key(courseId));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e)
        {
            System.out.println("exception" + e);
        }
    }
    public void InsertRow(Connection conn, String tableName, String courseName, String mentorName, String studentName)
    {
        Statement statement;
        try
        {
            String query = String.format("insert into %s(courseName,mentorName,studentName) values('%s','%s','%s');", tableName, courseName, mentorName, studentName);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted successfully");
        } catch (Exception exception)
        {
            System.out.println(exception);
        }

    }


}
