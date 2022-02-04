package com.example.myapplication.kotiln

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.kotiln.Room.User

object Repository {
    fun getUser(userId:String): LiveData<User> {
        val livedata = MutableLiveData<User>()
        livedata.value = User(userId, userId, 22)
        return livedata
    }
}