package model;

import java.util.Objects;

public abstract class Person {
    private final String id;
    private String name;
    private int age;

    protected Person(String id, String name, int age) {
        if (id != null && !id.trim().isEmpty()) {
            if (name != null && !name.trim().isEmpty()) {
                if (age >= 0 && age <= 120) {
                    this.id = id;
                    this.name = name;
                    this.age = age;
                } else {
                    throw new IllegalArgumentException("Age must be between 0 and 120");
                }
            } else {
                throw new IllegalArgumentException("Name cannot be empty");
            }
        } else {
            throw new IllegalArgumentException("ID cannot be empty");
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Person other = (Person)obj;
            return Objects.equals(this.id, other.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public abstract String getRole();

    protected abstract String getDetails();

    public String toString() {
        return String.format("%s[ID=%s, Name=%s, Age=%d%s]", this.getRole(), this.id, this.name, this.age, this.getDetails());
    }
}
