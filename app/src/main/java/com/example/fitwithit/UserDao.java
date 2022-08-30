package com.example.fitwithit;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users where email = :email LIMIT 1 ")
    User getUserWithEmail(String email);

    @Query("SELECT * FROM users where nameSurname = :fullName LIMIT 1")
    User getUserWithFullName(String fullName);

    @Insert
    void add(User user);

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    User getbyId(long id);

    @Query("SELECT * FROM users WHERE id=:id LIMIt 1")
    User modify(long id);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
