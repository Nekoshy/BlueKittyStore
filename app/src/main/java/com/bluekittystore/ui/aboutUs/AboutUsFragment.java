package com.bluekittystore.ui.aboutUs;

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

public class AboutUsFragment extends Fragment {

    private AboutUsViewModel aboutUsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutUsViewModel =  new AboutUsViewModel();
        View root = inflater.inflate(R.layout.fragment_about_us, container, false);
        final TextView textView = root.findViewById(R.id.text_aboutus);
        textView.setText(aboutUsViewModel.getText());

        return root;
    }
}