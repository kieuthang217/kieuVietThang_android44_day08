package com.example.myapplication;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    List<Product> productList;
    Context context;
    ProductClick productClick;

    public AdapterProduct(List<Product> productList) {
        this.productList = productList;

    }
    public void setClick(ProductClick productClick) {
        this.productClick = productClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product = productList.get(position);
        if (product == null) {
            return;
        }
        holder.img.setImageResource(product.getImg());
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(product.getPrice()+"");
        holder.ratingBar.setRating(product.getRating());
       holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                productClick.onProductClick(productList.get(position));
           }
       });
    }

    @Override
    public int getItemCount() {
        if (productList != null) {
            return productList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvPrice;
        ImageView img;
        RatingBar ratingBar;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgRcv);
            tvName = itemView.findViewById(R.id.tvNameFood);
            tvPrice = itemView.findViewById(R.id.tvGia);
            ratingBar= itemView.findViewById(R.id.rating);
            relativeLayout= itemView.findViewById(R.id.relativeRcv);

        }
    }
}
