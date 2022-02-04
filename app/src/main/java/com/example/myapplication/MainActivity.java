package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.kotiln.MainViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private MainActivityModel viewModel;
    private TextView info_text;
    private Button btn_plus;
    private Button btn_clear;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        int counter = sharedPreferences.getInt("counter",0);

        //之所以不直接创建ViewModel的实例是因为要是这样写会导致每次Activity重建都会同步重建ViewModel
        // 旋转屏幕 导致ViewModel数据丢失
        //且ViewModel有其独立的生命周期 长于Activity
        //获取ViewModel的实例 第一个参数为你的Activity或者fragment 第二个参数是与之对应的继承了ViewModel的class文件
        //查看保存的数据 并传递给ViewModel
        viewModel = new ViewModelProvider(this,new MainViewModelFactory(counter)).get(MainActivityModel.class);

        info_text = (TextView)findViewById(R.id.textview);

        btn_plus = (Button)findViewById(R.id.button);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.counter++;
                refreshText();
            }
        });

        btn_clear = (Button)findViewById(R.id.button2);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.counter = 0;
                refreshText();
            }
        });

        refreshText();
    }

    private void refreshText() {
        info_text.setText(viewModel.counter + "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
        editor.putInt("counter",viewModel.counter);
        editor.apply();
    }

}
