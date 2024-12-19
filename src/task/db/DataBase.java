package task.db;

import task.models.Group;
import task.models.Lesson;
import task.models.Student;
import task.models.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Group> groups = new ArrayList<>();
    public static List<Lesson> lessons = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
}
