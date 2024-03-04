package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.dao.GroupDAO;
import com.example.myapplication.dao.GroupRoomDatabase;
import com.example.myapplication.entity.GroupEntity;

import java.util.List;

public class GroupRepository {
    private GroupDAO groupDAO = null;

    public GroupRepository(Context context) {
        GroupRoomDatabase productRoomDatabase = GroupRoomDatabase.getInstance(context);
        groupDAO = productRoomDatabase.groupDAO();
    }
    public void createGroup(GroupEntity product) {
        groupDAO.insert(product);
    }

    public GroupEntity getProduct(int id) {
        return groupDAO.select(id);
    }

    public List<GroupEntity> getAllProduct(int userId) {
        return groupDAO.selectAllByUserId(userId);
    }

    public void deleteProductById(int id) {
        groupDAO.deleteGroupById(id);
    }
}
