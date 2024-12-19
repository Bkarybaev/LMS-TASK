package task.dao;

import task.models.Lesson;

import java.util.List;

public interface LessonDao {
    void addNewLessonToGroup(Lesson lesson, String groupName);

    Lesson getLessonByName(String lessonName);

    List<Lesson> getAllLessonByGroupName(String groupName);

    void deleteLessonById(Long lessonId);
}
