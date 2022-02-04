package com.example.myapplication.kotiln.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(version = 2,entities = [User::class,Book::class])
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao():UserDao //提供抽象方法用于获取之前编写的Dao实例 具体方法实现由Room在底层自动自动完成的

    abstract fun bookDao():BookDao

    companion object{
        val MIGRATION_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table if not exists Book (id integer primary key autoincrement not null, name text not null,pages integer not null)")
            }

        }

        private var instance:UserDatabase ?=null
        @Synchronized
        fun getDatabase(context: Context):UserDatabase{
            instance?.let {
                return it
            }
            return  Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"user_database").addMigrations(
                    MIGRATION_1_2).build().apply { instance = this }
        }
    }
}
