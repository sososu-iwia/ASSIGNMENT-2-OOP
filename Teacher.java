
package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private final String department;
    private double salary;
    private final List<String> subjects;

    public Teacher(String id, String name, int age, String department, double salary) {
        super(id, name, age);
        if (department != null && !department.trim().isEmpty()) {
            if (salary < (double)0.0F) {
                throw new IllegalArgumentException("Salary cannot be negative");
            } else {
                this.department = department;
                this.salary = salary;
                this.subjects = new ArrayList();
            }
        } else {
            throw new IllegalArgumentException("Department cannot be empty");
        }
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public List<String> getSubjects() {
        return new ArrayList(this.subjects);
    }

    public void setSalary(double salary) {
        if (salary < (double)0.0F) {
            throw new IllegalArgumentException("Salary cannot be negative");
        } else {
            this.salary = salary;
        }
    }

    public void assignSubject(String subject) {
        if (subject != null && !subject.trim().isEmpty()) {
            this.subjects.add(subject);
        }

    }

    public String getRole() {
        return "Teacher";
    }

    protected String getDetails() {
        return String.format(", Dept=%s, Salary=%.2f, Subjects=%d", this.department, this.salary, this.subjects.size());
    }
}
