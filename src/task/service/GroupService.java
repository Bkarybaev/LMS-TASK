package task.service;

import task.models.Group;

import java.util.List;

public interface GroupService {

    String save(Group group);

    Group getByName(String groupName);

    Group updateGroupName(String groupName,Group g);

    List<Group> getAllGroups();

    void deletedGroupName(String groupName);
}
