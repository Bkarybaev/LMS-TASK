package task.service.impl;

import task.dao.impl.LessonDaoImpl;
import task.db.DataBase;
import task.exceptions.NullPointerException;
import task.models.Group;
import task.models.Lesson;
import task.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    LessonDaoImpl lessonDao  = new LessonDaoImpl();
    @Override
    public void addNewLessonToGroup(Lesson lesson, String groupName) {
        try {
            if (lesson.getLessonName().isEmpty()){
                throw new NullPointerException("lesson name null!!");
            }
            if (groupName.isEmpty()){
                throw new NullPointerException("group name null!!");
            }

            for (Group g : DataBase.groups) {
               if (g.getGroupName().equals(groupName)){
                   lessonDao.addNewLessonToGroup(lesson, groupName);
               }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Lesson getLessonByName(String lessonName) {
        try {
            if (lessonName.isEmpty()){
                throw new NullPointerException("lesson name null!!");
            }
            for (Lesson l : DataBase.lessons) {
                if (l.getLessonName().equals(lessonName)){
                    lessonDao.getLessonByName(lessonName);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        try {
            if (groupName.isEmpty()){
                throw new NullPointerException("group name null!!");
            }
            for (Group g : DataBase.groups) {
                if (g.getGroupName().equals(groupName)){
                    lessonDao.getAllLessonByGroupName(groupName);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public void deleteLessonById(Long lessonId) {
        boolean is = false;
        for (Lesson l : DataBase.lessons) {
            if (l.getId().equals(lessonId)){
                is = true;
                lessonDao.deleteLessonById(lessonId);
            }
        }
        if (!is){
            System.out.println("not fount!!");
        }
    }
}
