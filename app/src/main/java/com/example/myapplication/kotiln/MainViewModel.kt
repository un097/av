package com.example.myapplication.kotiln

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.kotiln.Room.User

class MainViewModel(counter: Int) :ViewModel() {

    private val _counterData = MutableLiveData<Int>()
    val counterData : LiveData<Int> get() =_counterData

    init {
        _counterData.value = counter
    }

    private val userData = MutableLiveData<User>()
    val userName:LiveData<String> = Transformations.map(userData){
        user ->"${user.firstName} ${user.lastName}"
    }

    private val userIdData = MutableLiveData<String>()
    val userId:LiveData<User> = Transformations.switchMap(userIdData){
        input -> Repository.getUser(input)
    }

    fun getUser(userId:String){
        userIdData.value =userId
    }


    fun plusone(){
        val count = _counterData.value?:0
        _counterData.value = count + 1
    }

    fun clear(){
        _counterData.value = 0
    }
}