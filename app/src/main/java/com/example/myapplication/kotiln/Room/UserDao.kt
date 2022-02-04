package com.example.myapplication.kotiln.Room

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User) : Long

    @Update
    fun updateUser(newUser:User)

    @Query("select * from User")
    fun loadAllUsers():List<User>

    @Delete
    fun deleteUser(user:User)

    @Query("delete from User where lastName = :lastName")
    fun deleteByLastName(lastName:String):Int
}
