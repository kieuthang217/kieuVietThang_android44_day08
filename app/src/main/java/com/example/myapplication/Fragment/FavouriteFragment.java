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

import com.example.myapplication.AdapterProduct;
import com.example.myapplication.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {
    Product product;
    List<Product> list;
    RecyclerView recyclerViewFav;
    AdapterProduct adapterProduct;

    public static FavouriteFragment newInstance() {

        Bundle args = new Bundle();

        FavouriteFragment fragment = new FavouriteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.item4,container,false);
        recyclerViewFav = view.findViewById(R.id.rcvFav);

        adapterProduct = new AdapterProduct(getReFood());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        recyclerViewFav.setLayoutManager(gridLayoutManager);
        recyclerViewFav.setAdapter(adapterProduct);


        return view;
    }
    private List<Product> getReFood() {
        list = new ArrayList<>();
        list.add(new Product(R.drawable.doan1,"Nut toast",3,8));
        list.add(new Product(R.drawable.doan2,"Baked salmon",5,14));


        return  list;
    }
}
