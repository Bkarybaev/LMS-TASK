package task.service.impl;

import task.dao.impl.GroupDaoImpl;
import task.db.DataBase;
import task.exceptions.EqualException;
import task.exceptions.NullPointerException;
import task.models.Group;
import task.models.User;
import task.service.GroupService;

import java.util.List;
import java.util.Objects;

public class GroupServiceImpl implements GroupService {
    GroupDaoImpl groupDao = new GroupDaoImpl();

    @Override
    public String save(Group group) {
        try {
            if (group.getGroupName().isEmpty() || Objects.equals(group.getGroupName(), " ")) {
                throw new NullPointerException("Group name null!!");
            } else {
                for (Group g : DataBase.groups) {
                    if (g.getGroupName().equals(group.getGroupName())) {
                        throw new EqualException("myndai groupa bar ozgortuunuz kerek bolot!!");
                    }
                }
            }
            if (group.getDescription().isEmpty() || Objects.equals(group.getDescription(), " ")) {
                throw new NullPointerException("description tolturulgan jok!!");
            }
            groupDao.save(group);
            return "Successfully added ";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }


    }

    @Override
    public Group getByName(String groupName) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)) {
                return groupDao.getByName(groupName);
            }
        }
        System.out.println("not fount!!");
        return null;
    }

    @Override
    public Group updateGroupName(String groupName, Group g) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)) {
                return groupDao.updateGroupName(groupName, g);
            }
        }
        System.out.println("not fount!!");
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void deletedGroupName(String groupName) {
        try {
            if (groupName.isEmpty()){
                throw new NullPointerException("group name null!!");
            }
            for (Group g : DataBase.groups) {
                if (g.getGroupName().equals(groupName)){
                    groupDao.deletedGroupName(groupName);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
