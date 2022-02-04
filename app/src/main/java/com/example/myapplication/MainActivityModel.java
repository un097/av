package com.example.myapplication;

import androidx.lifecycle.ViewModel;

public class MainActivityModel extends ViewModel {

    public MainActivityModel(int counterReserved) {
        this.counter = counterReserved;
    }

    protected int counter = 0;
}

