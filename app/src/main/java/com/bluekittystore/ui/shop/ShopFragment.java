package com.bluekittystore.ui.shop;

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

import com.bluekittystore.R;

public class ShopFragment extends Fragment {

    private ShopViewModel shopViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shopViewModel = new ShopViewModel();

        View root = inflater.inflate(R.layout.fragment_shop, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        textView.setText(shopViewModel.getText());
        return root;
    }
}