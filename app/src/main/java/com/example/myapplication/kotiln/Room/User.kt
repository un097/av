package com.example.myapplication.kotiln.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(var firstName:String,var lastName:String,var age:Int){
    @PrimaryKey(autoGenerate = true)//代表主键自动生成
    var id : Long = 0
}
