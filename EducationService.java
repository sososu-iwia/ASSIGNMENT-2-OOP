package service;
import dao.StudentDAO;
import dao.TeacherDAO;
import model.*;
import ui.ConsoleReader;
import ui.Menu;

import java.util.List;

public class EducationService {

    private final Institution institution;
    private final ConsoleReader reader;
    private final Menu menu = new Menu();
    private boolean running = true;

    private final StudentDAO studentDAO = new StudentDAO();
    private final TeacherDAO teacherDAO = new TeacherDAO();

    public EducationService(Institution institution, ConsoleReader reader) {
        this.institution = institution;
        this.reader = reader;
        setupMenu();
    }

    private void setupMenu() {
        menu.addOption(1, "Add Student", this::addStudent);
        menu.addOption(2, "Add Teacher", this::addTeacher);
        menu.addOption(3, "Display All", institution::displayAllPeople);
        menu.addOption(4, "Search by Name", this::searchByName);
        menu.addOption(5, "Filter Students by GPA", this::filterByGpa);
        menu.addOption(6, "Sort Students by GPA", this::sortByGpa);
        menu.addOption(0, "Exit", this::exit);
    }

    public void start() {
        System.out.println("\n=== " + institution.getName() + " Management System ===\n");

        while (running) {
            menu.display();
            int choice = reader.readInt("Choose option: ");
            if (!menu.executeOption(choice)) {
                System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private void addStudent() {
        try {
            Student s = new Student(
                    reader.readLine("ID: "),
                    reader.readLine("Name: "),
                    reader.readInt("Age: "),
                    reader.readLine("Major: ")
            );

            if (reader.readYesNo("Set GPA? (y/n): ")) {
                s.setGpa(reader.readDouble("GPA: "));
            }

            institution.register(s);
            studentDAO.save(s);

            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addTeacher() {
        try {
            Teacher t = new Teacher(
                    reader.readLine("ID: "),
                    reader.readLine("Name: "),
                    reader.readInt("Age: "),
                    reader.readLine("Department: "),
                    reader.readDouble("Salary: ")
            );

            institution.register(t);
            teacherDAO.save(t);

            System.out.println("Teacher added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchByName() {
        String q = reader.readLine("Name: ");
        institution.searchPeopleByName(q).forEach(System.out::println);
    }

    private void filterByGpa() {
        double gpa = reader.readDouble("Min GPA: ");
        institution.filterStudentsByMinGpa(gpa).forEach(System.out::println);
    }

    private void sortByGpa() {
        institution.getStudentsSortedByGpa().forEach(System.out::println);
    }

    private void exit() {
        running = false;
        System.out.println("Goodbye!");
    }
}