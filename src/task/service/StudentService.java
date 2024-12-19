package task.service;

import task.models.Lesson;
import task.models.Student;

import java.util.List;

public interface StudentService {

    void addNewStudentToGroup(Student student,String groupName);

    Student updateStudent(String email,String password ,Student newStudent);

    List<Student> findStudentByFirstName(String studentName);

    List<Student> getAllStudentsByGroupName(String groupName);

    List<Lesson> getStudentLessons(String studentEmail);

    void deletedStudentByEmail(String studentEmail);


}
