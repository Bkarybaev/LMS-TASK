package task;

import task.db.DataBase;
import task.enums.Gender;
import task.enums.Role;
import task.models.Group;
import task.models.Lesson;
import task.models.Student;
import task.models.User;
import task.service.impl.GroupServiceImpl;
import task.service.impl.LessonServiceImpl;
import task.service.impl.StudentServiceImpl;
import task.service.impl.UserServiceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static GroupServiceImpl groupService = new GroupServiceImpl();
    static UserServiceImpl userService = new UserServiceImpl();
    static StudentServiceImpl studentService = new StudentServiceImpl();
    static LessonServiceImpl lessonService = new LessonServiceImpl();

    public static void main(String[] args) {

        userService.addUser(new User("Peaksoft", "Hous", "school@peaksoft.us", "Peaksoft@123", Role.ADMIN));


        clock();
        while (true) {
            System.out.println("kattalgan bolsonuz 1 basynyz, password ozgorduu uchun 2 bozynyz!");
            System.out.print("choice: ");
            String choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1" -> adminChas(userService.admin(admin()));
                case "2" -> System.out.println(updatePassword());
                default -> System.out.println("Error choice try again!!");
            }

        }
    }

    public static User updatePassword() {
        System.out.println(DataBase.users);
        System.out.print("write email: ");
        String email = new Scanner(System.in).nextLine();

        System.out.print("write new password: ");
        String password = new Scanner(System.in).nextLine();
        return userService.updatePassword(email, password);
    }

    public static void adminChas(boolean b) {
        if (!b) {
            System.out.println("myndai email tabylgan jok!!");
        } else {
            while (true) {
                System.out.print("""
                             *** choice command! ***
                        1. add new group
                        2. get group by name
                        3. update group name
                        4. get all groups
                        5. add new student to group
                        6. update student
                        7. find student firs name
                        8. get all student by group name
                        9. get all student's lesson
                        10.delete student by email
                        11.add new lesson to group
                        12.get lesson by name
                        13.get all lesson by group name
                        14.delete lesson by id
                        15.delete group by name
                        """);
                System.out.print("choice: ");
                switch (new Scanner(System.in).nextLine()){
                    case "1" -> System.out.println(groupService.save(addGroup()));
                    case "2" -> System.out.println(groupService.getByName(nameGroup()));
                    case "3" -> System.out.println(groupService.updateGroupName(nameGroup(), addGroup()));
                    case "4" -> System.out.println(groupService.getAllGroups());
                    case "5" -> studentService.addNewStudentToGroup(addStudent(),nameGroup());
                    case "6" -> System.out.println(studentService.updateStudent(getEmail(), getPassword(), getStudentUpdate()));
                    case "7" -> System.out.println(studentService.findStudentByFirstName(getStudentName()));
                    case "8" -> System.out.println(studentService.getAllStudentsByGroupName(nameGroup()));
                    case "9" -> System.out.println(studentService.getStudentLessons(getEmail()));
                    case "10" -> studentService.deletedStudentByEmail(getEmail());
                    case "11" -> lessonService.addNewLessonToGroup(getNewLesson(),nameGroup());
                    case "12" -> System.out.println(lessonService.getLessonByName(getLessonName()));
                    case "13" -> System.out.println(lessonService.getAllLessonByGroupName(nameGroup()));
                    case "14" -> lessonService.deleteLessonById(getIdLesson());
                    case "15" -> groupService.deletedGroupName(nameGroup());
                    default -> System.out.println("Error choice!!");
                }
            }
        }
    }
    public static Long getIdLesson(){
        System.out.print("write id lesson: ");
        return new Scanner(System.in).nextLong();
    }
    public static String getLessonName() {
        System.out.print("write lesson name: ");
        return new Scanner(System.in).nextLine();
    }
    public static Lesson getNewLesson(){
        System.out.print("lesson name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.print("task Description: ");
        String taskDescription = new Scanner(System.in).nextLine();

        return new Lesson(name,taskDescription);
    }
    public static String getStudentName(){
        System.out.print("write name: ");
        return new Scanner(System.in).nextLine();
    }
    public static Student getStudentUpdate(){
        System.out.print("write new first Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.print("write new Last name: ");
        String lastname = new Scanner(System.in).nextLine();

        return new Student(name,lastname);
    }
    public static String getPassword(){
        System.out.print("write password: ");
        return new Scanner(System.in).nextLine();
    }

    public static String getEmail(){
        System.out.print("write email: ");
        return new Scanner(System.in).nextLine();
    }
    public static Student addStudent(){
        System.out.print("write fist name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.print("write last name: ");
        String lastname = new Scanner(System.in).nextLine();

        System.out.print("write last email: ");
        String email = new Scanner(System.in).nextLine();

        System.out.print("write last password: ");
        String password = new Scanner(System.in).nextLine();

        Role role = Role.STUDENT;

        System.out.print("write last gender(1-MALE, 2-FEMALE): ");
        String gender = new Scanner(System.in).nextLine().toUpperCase();
        Gender gen = null;
        switch (gender){
            case "1","MALE" -> gen = Gender.MALE;
            case "2","FEMALE" -> gen = Gender.FEMALE;
            default -> System.out.println("tuura emes tandoo!!");

        }
        return new Student(name,lastname,email,password,role,gen);
    }
    public static String nameGroup(){
        System.out.print("write Group Name: ");
        return new Scanner(System.in).nextLine();
    }

    public static User admin() {
        System.out.print("write email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.print("write password: ");
        String password = new Scanner(System.in).nextLine();
        return new User(email, password);
    }

    public static Group addGroup() {
        Group group = new Group();
            System.out.print("write new group name: ");
            group.setGroupName(new Scanner(System.in).nextLine());

            System.out.print("write description: ");
            group.setDescription(new Scanner(System.in).nextLine());
        return group;
    }

    public static void clock() {
        LocalTime clock = LocalTime.now();
        DateTimeFormatter p = DateTimeFormatter.ofPattern("HH:mm");
        String format = clock.format(p);
        String now;
        if (clock.isAfter(LocalTime.of(5, 59)) && clock.isBefore(LocalTime.of(9, 0))) {
            now = "Кутман таң! Caaт  ->  ";
        } else if (clock.isAfter(LocalTime.of(9, 0)) && clock.isBefore(LocalTime.of(18, 0))) {
            now = "Кутман кун! Caaт  ->  ";
        } else {
            now = "Кутман кеч! Caaт  ->  ";
        }
        System.out.println(now + format);
    }
}