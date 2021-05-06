package com.bluekittystore.ui.home;

import androidx.lifecycle.ViewModel;

import com.bluekittystore.MainActivity;
import com.bluekittystore.sql.SQLHelper;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    SQLHelper sqlHelper = MainActivity.sqlHelper;

    public String getText() {
        return "Home Fragment";
    }


}