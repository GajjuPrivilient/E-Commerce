package com.android.gajju45.e_commerce.Activities.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.android.gajju45.e_commerce.Activities.models.Product;
import com.android.gajju45.e_commerce.Activities.repo.ShopRepo;

import java.util.List;

public class ShopViewModel  extends ViewModel {
    ShopRepo shopRepo=new ShopRepo();
    public LiveData<List<Product>> getProducts()
    {
        return shopRepo.getProducts();
    }
}
