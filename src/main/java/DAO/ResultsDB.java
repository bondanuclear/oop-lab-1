package DAO;

import java.sql.Connection;
import java.sql.Statement;

public class ResultsDB extends DB{
    public void CreateTable(Connection conn, String table_name)
    {
        Statement statement;
        try {
            String query = "create table " + table_name +"(courseId SERIAL,courseName varchar(200),mentorName varchar(200),studentName varchar(200),mark varchar(10),review varchar(200), primary key(courseId));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e)
        {
            System.out.println("exception" + e);
        }
    }
    public void InsertRow(Connection conn, String tableName, String courseName, String mentorName, String studentName, String mark, String review)
    {
        Statement statement;
        try
        {
            String query = String.format("insert into %s(courseName,mentorName,studentName, mark, review) values('%s','%s','%s', '%s', '%s');", tableName, courseName, mentorName, studentName, mark, review);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted successfully");
        } catch (Exception exception)
        {
            System.out.println(exception);
        }

    }
}
