package task.dao.impl;

import task.dao.LessonDao;
import task.db.DataBase;
import task.models.Group;
import task.models.Lesson;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public void addNewLessonToGroup(Lesson lesson, String groupName) {
        for (Group g : DataBase.groups) {
            if (g.getGroupName().equals(groupName)){
                g.getLessons().add(lesson);
                DataBase.lessons.add(lesson);
            }
        }
    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        for (Lesson l : DataBase.lessons) {
            if (l.getLessonName().equals(lessonName)){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        for (Group g : DataBase.groups) {
            if (g.getGroupName().equals(groupName)){
                return g.getLessons();
            }
        }
        return List.of();
    }

    @Override
    public void deleteLessonById(Long lessonId) {
        int count = 0;
        for (Lesson l : DataBase.lessons) {
            count++;
            if (l.getId().equals(lessonId)){
                DataBase.lessons.remove(count);
                for (Group g : DataBase.groups) {
                    g.getLessons().remove(count);
                }
            }
        }
    }
}
