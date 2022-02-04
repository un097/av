package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private int counterReserved;

    public MainViewModelFactory(int counterReserved) {
        this.counterReserved = counterReserved;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //由于create方法的执行时机和Acticity的生命周期无关 所以可以创建ViewModel的实例
        // 不存在之前说的问题
        return (T)new MainActivityModel(counterReserved);
    }
}

