class Teacher extends Person {
    private String department;
    private String specialization;
    private java.util.List<Course> teachingCourses;

    public Teacher(String name, String phone, String email, String department, String specialization) {
        super(name, phone, email);
        this.department = department;
        this.specialization = specialization;
        this.teachingCourses = new java.util.ArrayList<>();
    }

    public String getDepartment() { return department; }
    public String getSpecialization() { return specialization; }
    public java.util.List<Course> getTeachingCourses() { return new java.util.ArrayList<>(teachingCourses); }

    public void assignCourse(Course course) {
        if (teachingCourses.contains(course)) {
            System.out.println("Already teaching " + course.getName());
            return;
        }
        teachingCourses.add(course);
        System.out.println(getName() + " assigned to teach " + course.getName());
    }

    public void removeCourse(Course course) {
        if (teachingCourses.remove(course)) {
            System.out.println(getName() + " removed from " + course.getName());
        }
    }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public String toString() {
        return String.format("Teacher[ID=%d, Name=%s, Phone=%s, Email=%s, Dept=%s, Spec=%s, Courses=%d]",
                getId(), getName(), getPhone(), getEmail(), department, specialization, teachingCourses.size());
    }
}