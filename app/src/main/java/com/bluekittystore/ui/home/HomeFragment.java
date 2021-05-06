package com.bluekittystore.ui.home;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new HomeViewModel();
        root = inflater.inflate(R.layout.fragment_home, container, false);


        ImageView newsImageFirst = root.findViewById(R.id.news_image_first);
        ImageView newsImageSec = root.findViewById(R.id.news_image_sec);
        ImageView newsImageThird = root.findViewById(R.id.news_image_third);

        ImageView promImageFirst = root.findViewById(R.id.prom_image_first);
        ImageView promImageSec = root.findViewById(R.id.prom_image_sec);
        ImageView promImageThird = root.findViewById(R.id.prom_image_third);


        return root;
    }


}