package task.models;

import task.enums.Gender;
import task.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private Long id;
    private Gender gender;
    private List<Lesson> studentLessons = new ArrayList<>();

    static Long generateId = 1L;


    public Student(String firstName, String lastName, String email, String password, Role role, Gender gender) {
        super(firstName, lastName, email, password, role);
        this.id = generateId++;
        this.gender = gender;
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Lesson> getStudentLessons() {
        return studentLessons;
    }

    public void setStudentLessons(List<Lesson> studentLessons) {
        this.studentLessons = studentLessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender=" + gender +
                super.toString()+
                '}';
    }
}
