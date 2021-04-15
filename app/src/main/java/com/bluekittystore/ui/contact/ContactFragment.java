package com.bluekittystore.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bluekittystore.R;
import com.bluekittystore.ui.cart.CartViewModel;

public class ContactFragment extends Fragment {
    ContactViewModel contactViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel = new ContactViewModel();
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        return root;
    }


}
