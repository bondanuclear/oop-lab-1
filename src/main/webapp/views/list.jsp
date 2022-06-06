<%@ page import="DAO.StudentDB" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Users list</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Admins page!</h1>
        </div>
        <div class="w3-container w3-light-blue">
                            <h2>Users</h2>
        </div>
        <div>
            <table border="1" class="w3-table w3-striped w3-border">
                    <tr>
                        <td>Id</td>
                        <td>Course Name</td>
                        <td>Mentor Name</td>
                        <td>Student Name</td>
                     </tr>
                 <% try{
                 StudentDB db = new StudentDB();
                            Connection conn = db.connect_to_db("studentsdb","postgres", "targa" );
                            ResultSet resultSet = db.ReadData(conn, "Students");
                            while(resultSet.next()) {
                  %>
                    <tr>
                    <td><%=resultSet.getString("courseId") %></td>
                    <td><%=resultSet.getString("courseName") %></td>
                    <td><%=resultSet.getString("mentorName") %></td>
                    <td><%=resultSet.getString("studentName") %></td>

                    </tr>
                    <%
                    }
                        conn.close();
                        } catch (Exception e) {
                             e.printStackTrace();
                            }
                    %>
            </table>

        </div>

        <%--
        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                    <h2>Users</h2>
                </div>
                <%
                    List<String> names = (List<String>) request.getAttribute("userNames");

                    if (names != null && !names.isEmpty()) {
                        out.println("<ul class=\"w3-ul\">");
                        for (String s : names) {
                            out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
                        }
                        out.println("</ul>");

                    } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
+
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                            "   <h5>There are no users yet!</h5>\n" +
                            "</div>");
                %>
            </div>
        </div>
        --%>
        <div class="w3-container w3-padding">
                    <%
                        if (request.getAttribute("userName") != null) {
                            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                                    "   <h5>Student '" + request.getAttribute("userName") + "' added!</h5>\n" +
                                    "</div>");
                        }
                    %>
                    <div class="w3-card-4">
                        <div class="w3-container w3-center w3-green">
                            <h2> Fill in the info: </h2>
                        </div>
                        <form method="post" class="w3-selection w3-light-grey w3-padding">
                            <label>Name:
                                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                            </label>
                            <label>Mentor:
                                <input type="text" name="mentor" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                            </label>
                            <label> Enter the course:
                                <input type="text" name="course" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />

                            </label>
                            <label> Enter the mark:
                                <input type="text" name="mark" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />

                            </label>
                            <label> Enter the review:
                                <input type="text" name="review" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />

                            </label>
                            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom"> Send the result to the database! </button>
                        </form>
                    </div>
                </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
        </div>
    </body>
</html>