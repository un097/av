package com.example.myapplication.kotiln

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.myapplication.R
import com.example.myapplication.kotiln.Room.SimpleWorker
import com.example.myapplication.kotiln.Room.User
import com.example.myapplication.kotiln.Room.UserDatabase
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class MainActivity2 : AppCompatActivity() {

//    @BindView(R.id.menu_title_text_view_id)
    lateinit var mainViewModel: MainViewModel

    lateinit var plusone: Button
    lateinit var clear: Button
    lateinit var getUser: Button
    lateinit var add: Button
    lateinit var update: Button
    lateinit var delete: Button
    lateinit var query: Button
    lateinit var dowork: Button
    var TAG:String = "123"







    lateinit var textview: TextView

    lateinit var sp : SharedPreferences





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        plusone = findViewById(R.id.button)
        textview = findViewById(R.id.textview)
        clear = findViewById(R.id.clear)
        getUser = findViewById(R.id.getUser)
        add = findViewById(R.id.add)
        update = findViewById(R.id.update)
        delete = findViewById(R.id.delete)
        query = findViewById(R.id.query)
        dowork = findViewById(R.id.dowork)

        GlobalScope.launch {
            Log.d(TAG, Thread.currentThread().name)
        }

        GlobalScope.launch(Dispatchers.Main) {
            var name = getMessageFromNetwork()
            showMessage(name)
        }



//        Log.e(TAG, "主线程id：${mainLooper.thread.id}")
//        test()
//        Log.e(TAG, "协程执行结束")
//
//        Log.e(TAG, "主线程id：${mainLooper.thread.id}")
//        val job = GlobalScope.launch {
//            delay(6000)
//            Log.e(TAG, "协程执行结束 -- 线程id：${Thread.currentThread().id}")
//        }
//        Log.e(TAG, "主线程执行结束")

//        GlobalScope.launch {
//            val token = getToken()
//            val userInfo = getUserInfo(token)
//            setUserInfo(userInfo)
//        }
//        repeat(8){
//            Log.e(TAG,"主线程执行$it")
//        }

        GlobalScope.launch {
            val result1 = GlobalScope.async {
                getResult1()
            }
            val result2 = GlobalScope.async {
                getResult2()
            }
            val result = result1.await() + result2.await()
            Log.e(TAG,"result = $result")
        }






        sp = getSharedPreferences("data_jetpack", Context.MODE_PRIVATE)
        val counter = sp.getInt("counter",0)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(counter)).get(MainViewModel::class.java)

        plusone.setOnClickListener{
            //mainViewModel.counter++
            //textview.text = mainViewModel.counter.toString()
            mainViewModel.plusone()
        }
        clear.setOnClickListener{
            //mainViewModel.counter = 0
            //textview.text = mainViewModel.counter.toString()
            mainViewModel.clear()
        }
        //textview.text = mainViewModel.counter.toString()
        mainViewModel.counterData.observe(this, Observer {
            input -> textview.text = input.toString()//input变量名随意指定
        })

        getUser.setOnClickListener {
            val userId = (0..1000).random().toString()
            mainViewModel.getUser(userId)
        }

        mainViewModel.userId.observe(this, Observer {
            user -> textview.text = user.firstName
        })

        var userDao = UserDatabase.getDatabase(this).userDao()
        var user1 = User("Tom","Brady",22)
        var user2 = User("Andy","Hanks",33)

        add.setOnClickListener{
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        update.setOnClickListener{
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        delete.setOnClickListener{
            thread {
                userDao.deleteByLastName("Hanks")
            }
        }
        query.setOnClickListener{
            thread {
                for (user in userDao.loadAllUsers()){
                    Log.d("MainActivity",user.firstName+" " +user.lastName + " " +user.age)
//                    textview.text = user.firstName+" " +user.lastName + " " +user.age
//                    Toast.makeText(this, "Androidly Short Toasts", Toast.LENGTH_SHORT).show();
                }
            }
        }

        dowork.setOnClickListener{
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            WorkManager.getInstance().enqueue(request)
        }




    }


    @SuppressLint("NewApi")
    override fun onPause() {
        super.onPause()

        sp.edit().putInt("counter",mainViewModel.counterData.value?:0)

//        sp.edit {
//            //putInt("counter",mainViewModel.counter)
//            putInt("counter",mainViewModel.counterData.value?:0)
//        }
    }

    private fun test() = runBlocking {
        repeat(8) {
            Log.e(TAG, "协程执行$it 线程id：${Thread.currentThread().id}")
            delay(1000)
        }
    }

    private fun setUserInfo(userInfo: String) {
        Log.e(TAG, userInfo)
    }

    private suspend fun getToken(): String {
        delay(2000)
        return "token"
    }

    private suspend fun getUserInfo(token: String): String {
        delay(2000)
        return "$token - userInfo"
    }

    private suspend fun getResult1(): Int {
        delay(3000)
        return 11
    }

    private suspend fun getResult2(): Int {
        delay(4000)
        return 2
    }

    /**
     * 从服务器取信息
     */
    private suspend fun getMessageFromNetwork(): String {

        var name = ""
        withContext(Dispatchers.IO) {
            for (i in 0..1000000) {
                //这里模拟一个耗时操作
            }

            name = "Huanglinqing1111"
        }

        return name
    }

    /**
     * 显示信息
     * @message :信息
     */
    private fun showMessage(message: String) {
        textview.text = message
    }

}