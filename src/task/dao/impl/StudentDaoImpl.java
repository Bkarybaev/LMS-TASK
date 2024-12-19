package task.dao.impl;

import task.dao.StudentDao;
import task.db.DataBase;
import task.models.Group;
import task.models.Lesson;
import task.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addNewStudentToGroup(Student student,String groupName) {
        for (Group g : DataBase.groups) {
            if (g.getGroupName().equals(groupName)){
                g.getStudents().add(student);
            }
        }
        DataBase.students.add(student);
    }

    @Override
    public Student updateStudent(String email, String password, Student newStudent) {
        for (Student s : DataBase.students) {
             if (s.getEmail().equals(email) && s.getPassword().equals(password)){
                 s.setFirstName(newStudent.getEmail());
                 s.setLastName(newStudent.getPassword());
                 return s;
             }
        }
        return null;
    }

    @Override
    public List<Student> findStudentByFirstName(String studentName) {
        List<Student> stud = new ArrayList<>();
        for (Student s : DataBase.students) {
            if (s.getFirstName().equals(studentName)){
               stud.add(s);
            }
        }
        return stud;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)){
                return group.getStudents();
            }
        }
        return List.of();
    }

    @Override
    public List<Lesson> getStudentLessons(String studentEmail) {
        for (Student s : DataBase.students) {
            if (s.getEmail().equals(studentEmail)){
                return s.getStudentLessons();
            }
        }
        return List.of();
    }

    @Override
    public void deletedStudentByEmail(String studentEmail) {
        int count = 0;
        for (Student s : DataBase.students) {
            count++;
            if (s.getEmail().equals(studentEmail)){
                DataBase.students.remove(count);
            }
        }
    }
}
