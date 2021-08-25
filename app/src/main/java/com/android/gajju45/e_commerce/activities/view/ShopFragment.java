package com.android.gajju45.e_commerce.activities.view;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gajju45.e_commerce.R;
import com.android.gajju45.e_commerce.activities.adapters.ShopListAdapter;
import com.android.gajju45.e_commerce.activities.models.Product;
import com.android.gajju45.e_commerce.activities.viewModels.ShopViewModel;
import com.android.gajju45.e_commerce.databinding.FragmentShopBinding;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

    private static final String TAG = "ShopFragment";
    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;

    private NavController navController;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater, container, false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        shopListAdapter = new ShopListAdapter(this);
        fragmentShopBinding.shopRV.setAdapter(shopListAdapter);

        //Divided into HZ & V
        fragmentShopBinding.shopRV.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        fragmentShopBinding.shopRV.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        shopViewModel = new ViewModelProvider(requireActivity()).get((ShopViewModel.class));
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });
        navController = Navigation.findNavController(view);
    }

    //interface
    @Override
    public void addItem(Product product) {
       // Log.d(TAG, "add Item" + product.toString());
        boolean isAddedd = shopViewModel.addItemToCart(product);
        Log.d(TAG, "addItem: " + product.getName() + isAddedd);

    }

    @Override
    public void onItemClick(Product product) {
       // Log.d(TAG, "onItemClick" + product.toString());
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);


    }
}