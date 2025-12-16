class Institution extends BaseEntity {
    private String name;
    private String location;
    private java.util.List<Course> courses;
    private java.util.List<Student> students;
    private java.util.List<Teacher> teachers;

    public Institution(String name, String location) {
        super();
        this.name = name;
        this.location = location;
        this.courses = new java.util.ArrayList<>();
        this.students = new java.util.ArrayList<>();
        this.teachers = new java.util.ArrayList<>();
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public java.util.List<Course> getCourses() { return new java.util.ArrayList<>(courses); }
    public java.util.List<Student> getStudents() { return new java.util.ArrayList<>(students); }
    public java.util.List<Teacher> getTeachers() { return new java.util.ArrayList<>(teachers); }

    public void addCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("Course already exists!");
            return;
        }
        courses.add(course);
        course.setInstitution(this);
        System.out.println("Course " + course.getName() + " added to " + name);
    }

    public void registerStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Student already registered!");
            return;
        }
        students.add(student);
        System.out.println(student.getName() + " registered at " + name);
    }

    public void hireTeacher(Teacher teacher) {
        if (teachers.contains(teacher)) {
            System.out.println("Teacher already hired!");
            return;
        }
        teachers.add(teacher);
        System.out.println(teacher.getName() + " hired at " + name);
    }

    public java.util.List<Course> searchByLevel(String level) {
        java.util.List<Course> result = new java.util.ArrayList<>();
        for (Course course : courses) {
            if (course.getLevel().equalsIgnoreCase(level) && course.isActive()) {
                result.add(course);
            }
        }
        return result;
    }

    public java.util.List<Course> filterByCredits(int minCredits, int maxCredits) {
        java.util.List<Course> result = new java.util.ArrayList<>();
        for (Course course : courses) {
            if (course.getCredits() >= minCredits && course.getCredits() <= maxCredits && course.isActive()) {
                result.add(course);
            }
        }
        return result;
    }

    public void sortCoursesByCredits() {
        courses.sort((c1, c2) -> Integer.compare(c1.getCredits(), c2.getCredits()));
    }

    public void sortCoursesByName() {
        courses.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
    }

    @Override
    public String toString() {
        return String.format("Institution[ID=%d, Name=%s, Location=%s, Courses=%d, Students=%d, Teachers=%d]",
                getId(), name, location, courses.size(), students.size(), teachers.size());
    }
}