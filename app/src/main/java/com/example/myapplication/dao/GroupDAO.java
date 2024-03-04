package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entity.GroupEntity;

import java.util.List;

@Dao
public interface GroupDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GroupEntity group);
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    void insert(GroupEntity ...groupEntities);
    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(GroupEntity groupEntity);
    @Query("SELECT * FROM GroupEntity P WHERE P.id=:id")
    GroupEntity select(int id);
    @Query("SELECT * FROM GroupEntity P WHERE P.userId=:userId")
    List<GroupEntity> selectAllByUserId(int userId);
    @Query("DELETE FROM GroupEntity WHERE GroupEntity.id=:id")
    void deleteGroupById(int id);
}
