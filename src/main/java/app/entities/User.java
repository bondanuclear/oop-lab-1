package app.entities;

public class User {
    private String name;
    private String mentorName;
    private String course;
    public User() {
    }

    public User(String name, String course, String mentorName) {
        this.name = name;
        this.mentorName = mentorName;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }







    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }
}
