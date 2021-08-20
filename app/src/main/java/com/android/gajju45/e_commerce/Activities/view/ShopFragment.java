package com.android.gajju45.e_commerce.Activities.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gajju45.e_commerce.Activities.adapters.ShopListAdapter;
import com.android.gajju45.e_commerce.Activities.models.Product;
import com.android.gajju45.e_commerce.Activities.viewModels.ShopViewModel;
import com.android.gajju45.e_commerce.R;
import com.android.gajju45.e_commerce.databinding.FragmentShopBinding;

import java.util.List;


public class ShopFragment extends Fragment implements  ShopListAdapter.ShopInterface {

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;




    public ShopFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding=FragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        shopListAdapter=new ShopListAdapter();
        fragmentShopBinding.shopRV.setAdapter(shopListAdapter);

        shopViewModel =new ViewModelProvider(requireActivity()).get(shopViewModel.getClass());
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });
    }

    //interface
    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}