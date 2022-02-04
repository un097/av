package com.example.myapplication.kotiln.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Book (var name:String,var pages:Int){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
