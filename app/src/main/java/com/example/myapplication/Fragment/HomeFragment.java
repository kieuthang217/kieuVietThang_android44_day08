package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AdapterProduct;
import com.example.myapplication.Product;
import com.example.myapplication.ProductClick;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Product product;
    List<Product> list,list2;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerViewRe,recyclerViewNew;
    AdapterProduct adapterProduct;


    public static HomeFragment newInstance(Product food1) {

        Bundle args = new Bundle();
        args.putInt("img",food1.getImg());
        args.putString("nameFood",food1.getName());
        args.putFloat("rating",food1.getRating());
        args.putInt("price",food1.getPrice());
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.item2,container,false);
        recyclerViewRe= view.findViewById(R.id.rcvRecommen);
        recyclerViewNew= view.findViewById(R.id.rcvNew);

        //re
        adapterProduct = new AdapterProduct(getReFood());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerViewRe.setLayoutManager(linearLayoutManager);
        recyclerViewRe.setAdapter(adapterProduct);

        //new
        adapterProduct = new AdapterProduct(getNewFood());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerViewNew.setLayoutManager(linearLayoutManager2);
        recyclerViewNew.setAdapter(adapterProduct);

        adapterProduct.setClick(new ProductClick() {
            @Override
            public void onProductClick(Product product) {

            }
        });

        return view;

    }
    private List<Product> getReFood() {
        list = new ArrayList<>();
        list.add(new Product(R.drawable.doan2,"Craff",5,10));
        list.add(new Product(R.drawable.doan1,"Teddy cake",4,11));

        return  list;
    }
    private List<Product> getNewFood() {
        list2 = new ArrayList<>();
        list2.add(new Product(R.drawable.doan2,"Salad",1,20));
        list2.add(new Product(R.drawable.doan2,"Teddy cake",2,11));

        return  list2;
    }

}
