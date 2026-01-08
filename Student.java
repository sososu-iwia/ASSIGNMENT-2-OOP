
package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static final double MIN_GPA = (double)0.0F;
    private static final double MAX_GPA = (double)4.0F;
    private final String major;
    private double gpa;
    private final List<String> courses;

    public Student(String id, String name, int age, String major) {
        super(id, name, age);
        if (major != null && !major.trim().isEmpty()) {
            this.major = major;
            this.gpa = (double)0.0F;
            this.courses = new ArrayList();
        } else {
            throw new IllegalArgumentException("Major cannot be empty");
        }
    }

    public String getMajor() {
        return this.major;
    }

    public double getGpa() {
        return this.gpa;
    }

    public List<String> getCourses() {
        return new ArrayList(this.courses);
    }

    public void setGpa(double gpa) {
        if (!(gpa < (double)0.0F) && !(gpa > (double)4.0F)) {
            this.gpa = gpa;
        } else {
            throw new IllegalArgumentException(String.format("GPA must be between %.1f and %.1f", (double)0.0F, (double)4.0F));
        }
    }

    public void enrollInCourse(String courseName) {
        if (courseName != null && !courseName.trim().isEmpty()) {
            this.courses.add(courseName);
        }

    }

    public boolean hasMinimumGpa(double threshold) {
        return this.gpa >= threshold;
    }

    public String getRole() {
        return "Student";
    }

    protected String getDetails() {
        return String.format(", Major=%s, GPA=%.2f, Courses=%d", this.major, this.gpa, this.courses.size());
    }
}
