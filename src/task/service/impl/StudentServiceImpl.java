package task.service.impl;

import task.dao.impl.StudentDaoImpl;
import task.db.DataBase;
import task.exceptions.EmailException;
import task.exceptions.EqualException;
import task.exceptions.NullPointerException;
import task.models.Lesson;
import task.models.Student;
import task.service.StudentService;
import task.valudation.RegexPattern;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDaoImpl studentDao = new StudentDaoImpl();

    @Override
    public void addNewStudentToGroup(Student student,String groupName) {
        try {
            if (student.getFirstName().isEmpty()) {
                throw new NullPointerException("first name null!!");
            }
            if (student.getLastName().isEmpty()) {
                throw new NullPointerException("last name null!!");
            }
            if (!RegexPattern.emailPattern(student.getEmail())) {
                throw new EmailException("Invalid email!!");
            } else {
                for (Student s : DataBase.students) {
                    if (s.getEmail().equals(student.getEmail())) {
                        throw new EqualException("myndai email bar!!");
                    }
                }
            }
            if (!RegexPattern.passwordPattern(student.getPassword())) {
                throw new EmailException("Invalid password!!");
            }
            studentDao.addNewStudentToGroup(student,groupName);
            System.out.println("Successfully added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student updateStudent(String email, String password, Student newStudent) {
        try {
            if (!RegexPattern.passwordPattern(password)) {
                throw new EmailException("password tuura emes terilgen!!");
            }
            if (!RegexPattern.emailPattern(email)) {
                throw new EmailException("email tuura emes!!");
            } else {
                for (Student u : DataBase.students) {
                    if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                        return studentDao.updateStudent(email, password, newStudent);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> findStudentByFirstName(String studentName) {
        try {
            if (studentName.isEmpty()) {
                throw new NullPointerException("first name null!!");
            }
            studentDao.findStudentByFirstName(studentName);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        try {
            if (groupName.isEmpty()) {
                throw new NullPointerException("group name null!!");
            }
            studentDao.getAllStudentsByGroupName(groupName);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lesson> getStudentLessons(String studentEmail) {
        try {
            if (!RegexPattern.emailPattern(studentEmail)) {
                throw new EmailException("Invalid email!!");
            }
            studentDao.getStudentLessons(studentEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deletedStudentByEmail(String studentEmail) {
        try {
            if (!RegexPattern.emailPattern(studentEmail))
                throw new EmailException("Invalid email!!");
            else {
                boolean is = false;
                for (Student s : DataBase.students) {
                    if (s.getEmail().equals(studentEmail)){
                        is = true;
                        studentDao.deletedStudentByEmail(studentEmail);
                    }
                }
                if (!is){
                    System.out.println("not fount!!");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
