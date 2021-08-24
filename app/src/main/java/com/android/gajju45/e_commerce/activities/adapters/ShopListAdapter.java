package com.android.gajju45.e_commerce.activities.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.android.gajju45.e_commerce.activities.models.Product;
import com.android.gajju45.e_commerce.databinding.ShopRowBinding;

public class ShopListAdapter extends ListAdapter<Product, ShopListAdapter.shopVH> {

    ShopInterface shopInterface;
    public ShopListAdapter(ShopInterface shopInterface) {
        super(Product.itemCallback);
        this.shopInterface=shopInterface;
    }

    @NonNull
    @Override
    public shopVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopRowBinding shopRowBinding = ShopRowBinding.inflate(layoutInflater, parent, false);
        shopRowBinding.setShopInterface(shopInterface);//for click to details fragments
        return new shopVH(shopRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull shopVH holder, int position) {

        Product product=getItem(position);
        holder.shopRowBinding.setProduct(product);

    }

    public class shopVH extends RecyclerView.ViewHolder {
        ShopRowBinding shopRowBinding;

        public shopVH(ShopRowBinding binding) {
            super(binding.getRoot());
            this.shopRowBinding=binding;
        }
    }


    //interface for clicks
    public interface ShopInterface {
        void addItem(Product product);

        void onItemClick(Product product);
    }
}
