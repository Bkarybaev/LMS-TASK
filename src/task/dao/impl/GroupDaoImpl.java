package task.dao.impl;

import task.dao.GroupDao;
import task.db.DataBase;
import task.models.Group;

import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void save(Group group) {
        DataBase.groups.add(group);
    }

    @Override
    public Group getByName(String groupName) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)){
                return group;
            }
        }
        return null;
    }

    @Override
    public Group updateGroupName(String groupName,Group g) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equals(groupName)){
                group.setGroupName(g.getGroupName());
                group.setDescription(g.getDescription());
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return DataBase.groups;
    }

    @Override
    public void deletedGroupName(String groupName) {
        for (int i = 0; i < DataBase.groups.size(); i++) {
            if (DataBase.groups.get(i).getGroupName().equals(groupName)){
                DataBase.groups.remove(i);
                break;
            }
        }
    }
}
