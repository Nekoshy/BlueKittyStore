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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluekittystore.MainActivity;
import com.bluekittystore.R;
import com.bluekittystore.sql.SQLHelper;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView newsRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    View root;
    private ArrayList<String> data = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new HomeViewModel();
        root = inflater.inflate(R.layout.fragment_home, container, false);

        data = homeViewModel.testDB();
        System.out.println(data);
        initRecyclerViewNews();
        return root;
    }

    private void initRecyclerViewNews() {
        newsRecyclerView = root.findViewById(R.id.main_recyclerview_news);
        layoutManager = new LinearLayoutManager(root.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewAdapter = new RecyclerViewAdapter(data,root.getContext());
        newsRecyclerView.setLayoutManager(layoutManager);
        newsRecyclerView.setAdapter(recyclerViewAdapter);
    }
}