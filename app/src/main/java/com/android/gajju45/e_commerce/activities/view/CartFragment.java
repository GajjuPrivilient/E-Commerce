package com.android.gajju45.e_commerce.activities.view;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gajju45.e_commerce.R;
import com.android.gajju45.e_commerce.activities.adapters.CardListAdapter;
import com.android.gajju45.e_commerce.activities.models.CartItem;
import com.android.gajju45.e_commerce.activities.viewModels.ShopViewModel;
import com.android.gajju45.e_commerce.databinding.FragmentCartBinding;

import java.util.List;

public class CartFragment extends Fragment {
    private static final String TAG = "CartFragment";
    ShopViewModel shopViewModel;
    FragmentCartBinding fragmentCartBinding;




    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding=FragmentCartBinding.inflate(inflater,container,false);
        return fragmentCartBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CardListAdapter cardListAdapter=new CardListAdapter();
        fragmentCartBinding.cartRecyclerView.setAdapter(cardListAdapter);
        fragmentCartBinding.cartRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));
        shopViewModel=new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {

                cardListAdapter.submitList(cartItems);
            }
        });
    }
}