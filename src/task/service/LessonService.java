package task.service;

import task.models.Lesson;

import java.util.List;

public interface LessonService {
    void addNewLessonToGroup(Lesson lesson, String groupName);

    Lesson getLessonByName(String lessonName);

    List<Lesson> getAllLessonByGroupName(String groupName);

    void deleteLessonById(Long lessonId);
}