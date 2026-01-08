package model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Institution {
    private final String name;
    private final String address;
    private final List<Person> people;

    public Institution(String name, String address) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
            this.address = address != null ? address : "Unknown";
            this.people = new ArrayList();
        } else {
            throw new IllegalArgumentException("Institution name cannot be empty");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void register(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        } else {
            if (!this.people.contains(person)) {
                this.people.add(person);
            }

        }
    }

    public boolean unregister(String id) {
        return this.people.removeIf((person) -> person.getId().equals(id));
    }

    public Optional<Person> findPersonById(String id) {
        return this.people.stream().filter((person) -> person.getId().equals(id)).findFirst();
    }

    public List<Person> searchPeopleByName(String query) {
        String normalizedQuery = query.toLowerCase().trim();
        return (List)this.people.stream().filter((person) -> person.getName().toLowerCase().contains(normalizedQuery)).collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return (List)this.people.stream().filter((person) -> person instanceof Student).map((person) -> (Student)person).collect(Collectors.toList());
    }

    public List<Teacher> getTeachers() {
        return (List)this.people.stream().filter((person) -> person instanceof Teacher).map((person) -> (Teacher)person).collect(Collectors.toList());
    }

    public List<Student> filterStudentsByMinGpa(double minimumGpa) {
        return (List)this.getStudents().stream().filter((student) -> student.hasMinimumGpa(minimumGpa)).collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByGpa() {
        return (List)this.getStudents().stream().sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())).collect(Collectors.toList());
    }

    public void displayAllPeople() {
        if (this.people.isEmpty()) {
            System.out.println("No records available.");
        } else {
            List var10000 = this.people;
            PrintStream var10001 = System.out;
            Objects.requireNonNull(var10001);
            var10000.forEach(var10001::println);
        }
    }
}
