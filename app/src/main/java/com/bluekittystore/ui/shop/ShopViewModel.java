package com.bluekittystore.ui.shop;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ShopViewModel extends ViewModel {
    public String getText() {
        return "Shop fragment";
    }

    public ArrayList<String> getDate(){
        ArrayList<String> date = new ArrayList<>(); //test data
        date.add("test");
        return date;
    }
}