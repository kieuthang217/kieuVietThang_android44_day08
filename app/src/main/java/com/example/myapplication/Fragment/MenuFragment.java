package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Product;
import com.example.myapplication.R;
import com.example.myapplication.itemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    Product product;
    List<Product> list;
    RecyclerView recyclerView;
    itemAdapter itemadapter;
    int numberPosition =3;

    public static MenuFragment newInstance() {

        Bundle args = new Bundle();

        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.menu,container,false);
        recyclerView= view.findViewById(R.id.rcvMenu);

        itemadapter = new itemAdapter(getReFood(),getActivity());


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberPosition,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(itemadapter);


        return view;
    }
    private List<Product> getReFood() {
        list = new ArrayList<>();
        list.add(new Product(R.drawable.doan1,"Salad",4,10));
        list.add(new Product(R.drawable.doan2,"Main dishes",5,11));
        list.add(new Product(R.drawable.doan1,"Soups",5,12));
        list.add(new Product(R.drawable.doan2,"Paste",2,13));

        return  list;
    }
}
