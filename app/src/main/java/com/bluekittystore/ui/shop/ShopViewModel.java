package com.bluekittystore.ui.shop;

import androidx.lifecycle.ViewModel;

import com.bluekittystore.MainActivity;
import com.bluekittystore.sql.SQLHelper;

import java.util.ArrayList;

public class ShopViewModel extends ViewModel {
    SQLHelper sqlHelper = MainActivity.sqlHelper;

    public String getText() {
        return "Shop fragment";
    }

    public ArrayList<String> getDate(){
        return sqlHelper.getAllFromDB(); //test
    }
}