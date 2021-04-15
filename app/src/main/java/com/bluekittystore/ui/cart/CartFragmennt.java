package com.bluekittystore.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bluekittystore.R;

public class CartFragmennt extends Fragment {
    CartViewModel cartViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel = new CartViewModel();
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        return root;
    }
}
