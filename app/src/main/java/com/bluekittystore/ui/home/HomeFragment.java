package com.bluekittystore.ui.home;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bluekittystore.MainActivity;
import com.bluekittystore.R;
import com.bluekittystore.sql.SQLHelper;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    SQLHelper sqlHelper = MainActivity.sqlHelper;
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new HomeViewModel();
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText(homeViewModel.getText());

        ArrayList<String> myData = sqlHelper.getAllFromDB(); //test
        System.out.println(myData);
        return root;
    }
}