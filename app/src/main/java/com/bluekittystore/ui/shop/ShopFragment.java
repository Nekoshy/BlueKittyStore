package com.bluekittystore.ui.shop;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluekittystore.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private Context context;
    private View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopViewModel = new ShopViewModel();
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        context = view.getContext();
        final TextView textView = view.findViewById(R.id.text_gallery);
        textView.setText(shopViewModel.getText());
        setUpRecyclerView();

        return view;
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.shop_recycleview);
        ShopAdapter shopAdapter = new ShopAdapter(shopViewModel.getDate(),view);
        recyclerView.setAdapter(shopAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }
}