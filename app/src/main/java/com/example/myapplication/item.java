package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Fragment.ChatFragment;
import com.example.myapplication.Fragment.FavouriteFragment;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.MenuFragment;

public class item extends AppCompatActivity {
    TextView tvHome,tvMenu,tvFavou,tvChat;
    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item);

        tvHome = findViewById(R.id.tvHome);
        tvMenu = findViewById(R.id.tvMenu);
        tvFavou = findViewById(R.id.tvFavou);
        tvChat = findViewById(R.id.tvChat);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new HomeFragment()).commit();
        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragment(HomeFragment.newInstance(product));
            }
        });
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragment(MenuFragment.newInstance());
            }
        });
        tvFavou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragment(FavouriteFragment.newInstance());
            }
        });
        tvChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragment(ChatFragment.newInstance());
            }
        });

    }
    private void onFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragContainer,fragment)
                .commit();
    }
}
