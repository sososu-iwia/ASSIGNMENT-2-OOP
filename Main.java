public class Main {
    private java.util.List<Institution> institutions;
    private java.util.List<Student> allStudents;
    private java.util.List<Teacher> allTeachers;
    private java.util.Scanner scanner;

    public Main() {
        this.institutions = new java.util.ArrayList<>();
        this.allStudents = new java.util.ArrayList<>();
        this.allTeachers = new java.util.ArrayList<>();
        this.scanner = new java.util.Scanner(System.in);
    }

    public void run() {
        System.out.println("=== Educational Institution Management System ===\n");

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addInstitution(); break;
                case 2: addCourse(); break;
                case 3: registerStudent(); break;
                case 4: hireTeacher(); break;
                case 5: enrollStudent(); break;
                case 6: assignTeacher(); break;
                case 7: searchCourses(); break;
                case 8: viewInstitutions(); break;
                case 9: viewStudents(); break;
                case 10: viewTeachers(); break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }

        scanner.close();
    }

    private void showMainMenu() {
        System.out.println("1. Add institution");
        System.out.println("2. Add course");
        System.out.println("3. Register student");
        System.out.println("4. Hire teacher");
        System.out.println("5. Enroll student in course");
        System.out.println("6. Assign teacher to course");
        System.out.println("7. Search courses");
        System.out.println("8. View institutions");
        System.out.println("9. View students");
        System.out.println("10. View teachers");
        System.out.println("0. Exit");
    }

    private void addInstitution() {
        System.out.println("\n--- Add Institution ---");
        String name = readString("Name: ");
        String location = readString("Location: ");
        institutions.add(new Institution(name, location));
        System.out.println("Institution created!");
    }

    private void addCourse() {
        if (institutions.isEmpty()) {
            System.out.println("Create an institution first!");
            return;
        }

        System.out.println("\n--- Add Course ---");
        showInstitutions();
        int idx = readInt("Select institution: ") - 1;

        if (idx < 0 || idx >= institutions.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Institution institution = institutions.get(idx);
        String name = readString("Course name: ");
        String code = readString("Course code: ");
        int credits = readInt("Credits: ");
        String level = readString("Level: ");

        Course course = new Course(name, code, credits, level);
        institution.addCourse(course);
    }

    private void registerStudent() {
        if (institutions.isEmpty()) {
            System.out.println("Create an institution first!");
            return;
        }

        System.out.println("\n--- Register Student ---");
        String name = readString("Name: ");
        String phone = readString("Phone: ");
        String email = readString("Email: ");
        String studentId = readString("Student ID: ");

        Student student = new Student(name, phone, email, studentId);
        allStudents.add(student);

        showInstitutions();
        int idx = readInt("Select institution: ") - 1;

        if (idx >= 0 && idx < institutions.size()) {
            institutions.get(idx).registerStudent(student);
        }
    }

    private void hireTeacher() {
        if (institutions.isEmpty()) {
            System.out.println("Create an institution first!");
            return;
        }

        System.out.println("\n--- Hire Teacher ---");
        String name = readString("Name: ");
        String phone = readString("Phone: ");
        String email = readString("Email: ");
        String department = readString("Department: ");
        String specialization = readString("Specialization: ");

        Teacher teacher = new Teacher(name, phone, email, department, specialization);
        allTeachers.add(teacher);

        showInstitutions();
        int idx = readInt("Select institution: ") - 1;

        if (idx >= 0 && idx < institutions.size()) {
            institutions.get(idx).hireTeacher(teacher);
        }
    }

    private void enrollStudent() {
        if (allStudents.isEmpty() || institutions.isEmpty()) {
            System.out.println("Need students and institutions first!");
            return;
        }

        System.out.println("\n--- Enroll Student ---");
        showStudentsList();
        int sIdx = readInt("Select student: ") - 1;

        if (sIdx < 0 || sIdx >= allStudents.size()) {
            System.out.println("Invalid student!");
            return;
        }

        showInstitutions();
        int iIdx = readInt("Select institution: ") - 1;

        if (iIdx < 0 || iIdx >= institutions.size()) {
            System.out.println("Invalid institution!");
            return;
        }

        Institution institution = institutions.get(iIdx);
        java.util.List<Course> courses = institution.getCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses available!");
            return;
        }

        System.out.println("\nAvailable courses:");
        showCoursesList(courses);

        int cIdx = readInt("Select course: ") - 1;
        if (cIdx >= 0 && cIdx < courses.size()) {
            allStudents.get(sIdx).enrollCourse(courses.get(cIdx));
        }
    }

    private void assignTeacher() {
        if (allTeachers.isEmpty() || institutions.isEmpty()) {
            System.out.println("Need teachers and institutions first!");
            return;
        }

        System.out.println("\n--- Assign Teacher ---");
        showTeachersList();
        int tIdx = readInt("Select teacher: ") - 1;

        if (tIdx < 0 || tIdx >= allTeachers.size()) {
            System.out.println("Invalid teacher!");
            return;
        }

        showInstitutions();
        int iIdx = readInt("Select institution: ") - 1;

        if (iIdx < 0 || iIdx >= institutions.size()) {
            System.out.println("Invalid institution!");
            return;
        }

        Institution institution = institutions.get(iIdx);
        java.util.List<Course> courses = institution.getCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses available!");
            return;
        }

        System.out.println("\nAvailable courses:");
        showCoursesList(courses);

        int cIdx = readInt("Select course: ") - 1;
        if (cIdx >= 0 && cIdx < courses.size()) {
            allTeachers.get(tIdx).assignCourse(courses.get(cIdx));
        }
    }

    private void searchCourses() {
        if (institutions.isEmpty()) {
            System.out.println("No institutions!");
            return;
        }

        System.out.println("\n--- Search Courses ---");
        System.out.println("1. By level");
        System.out.println("2. By credits range");
        System.out.println("3. Sort by credits");
        System.out.println("4. Sort by name");

        int choice = readInt("Option: ");
        showInstitutions();
        int idx = readInt("Select institution: ") - 1;

        if (idx < 0 || idx >= institutions.size()) {
            System.out.println("Invalid institution!");
            return;
        }

        Institution institution = institutions.get(idx);
        java.util.List<Course> results = new java.util.ArrayList<>();

        switch (choice) {
            case 1:
                String level = readString("Level: ");
                results = institution.searchByLevel(level);
                break;
            case 2:
                int min = readInt("Min credits: ");
                int max = readInt("Max credits: ");
                results = institution.filterByCredits(min, max);
                break;
            case 3:
                institution.sortCoursesByCredits();
                results = institution.getCourses();
                break;
            case 4:
                institution.sortCoursesByName();
                results = institution.getCourses();
                break;
        }

        if (!results.isEmpty()) {
            System.out.println("\nFound " + results.size() + " course(s):");
            showCoursesList(results);
        } else {
            System.out.println("No courses found.");
        }
    }

    private void viewInstitutions() {
        System.out.println("\n=== Institutions ===");
        if (institutions.isEmpty()) {
            System.out.println("No institutions yet.");
        } else {
            showInstitutions();
        }
    }

    private void viewStudents() {
        System.out.println("\n=== Students ===");
        if (allStudents.isEmpty()) {
            System.out.println("No students yet.");
        } else {
            for (Student s : allStudents) {
                System.out.println(s);
                for (Course c : s.getEnrolledCourses()) {
                    System.out.println("  - " + c.getName());
                }
            }
        }
    }

    private void viewTeachers() {
        System.out.println("\n=== Teachers ===");
        if (allTeachers.isEmpty()) {
            System.out.println("No teachers yet.");
        } else {
            for (Teacher t : allTeachers) {
                System.out.println(t);
                for (Course c : t.getTeachingCourses()) {
                    System.out.println("  - " + c.getName());
                }
            }
        }
    }

    private void showInstitutions() {
        for (int i = 0; i < institutions.size(); i++) {
            System.out.println((i + 1) + ". " + institutions.get(i));
        }
    }

    private void showStudentsList() {
        for (int i = 0; i < allStudents.size(); i++) {
            System.out.println((i + 1) + ". " + allStudents.get(i).getName());
        }
    }

    private void showTeachersList() {
        for (int i = 0; i < allTeachers.size(); i++) {
            System.out.println((i + 1) + ". " + allTeachers.get(i).getName());
        }
    }

    private void showCoursesList(java.util.List<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}