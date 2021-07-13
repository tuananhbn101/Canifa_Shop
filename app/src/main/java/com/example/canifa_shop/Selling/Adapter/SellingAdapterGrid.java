package com.example.canifa_shop.Selling.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canifa_shop.Product.Object.Product;
import com.example.canifa_shop.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SellingAdapterGrid extends RecyclerView.Adapter<SellingAdapterGrid.ViewHolder> {
    List<Product> productList;

    public SellingAdapterGrid(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prodcut_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SellingAdapterGrid.ViewHolder holder, int position) {
        Product product = productList.get(position);
//        Picasso.get().load(product.getProducer()).into(holder.ivProduct);
//        holder.tvPriceProduct.setText(product.getPrice()+"");
//        holder.tvNameProduct.setText(product.getNameProduct());
//        holder.tvAmountProduct.setText(product.getAmount());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView tvNameProduct,tvAmountProduct,tvPriceProduct;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvNameProduct = ivProduct.findViewById(R.id.tvNameProduct);
            tvAmountProduct = ivProduct.findViewById(R.id.tvNameProduct);
            tvPriceProduct = ivProduct.findViewById(R.id.tvNameProduct);
        }
    }
}
