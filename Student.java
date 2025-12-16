class Student extends Person {
    private String studentId;
    private java.util.List<Course> enrolledCourses;
    private double gpa;

    public Student(String name, String phone, String email, String studentId) {
        super(name, phone, email);
        this.studentId = studentId;
        this.enrolledCourses = new java.util.ArrayList<>();
        this.gpa = 0.0;
    }

    public String getStudentId() { return studentId; }
    public java.util.List<Course> getEnrolledCourses() { return new java.util.ArrayList<>(enrolledCourses); }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public void enrollCourse(Course course) {
        if (!course.isActive()) {
            System.out.println("Course " + course.getName() + " is not active!");
            return;
        }
        if (enrolledCourses.contains(course)) {
            System.out.println("Already enrolled in " + course.getName());
            return;
        }
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in " + course.getName() + "!");
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.remove(course)) {
            System.out.println(getName() + " dropped " + course.getName());
        }
    }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public String toString() {
        return String.format("Student[ID=%d, StudentID=%s, Name=%s, Phone=%s, Email=%s, GPA=%.2f, Courses=%d]",
                getId(), studentId, getName(), getPhone(), getEmail(), gpa, enrolledCourses.size());
    }
}