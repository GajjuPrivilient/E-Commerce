package com.android.gajju45.e_commerce.activities.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.gajju45.e_commerce.activities.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){
        if (mutableProductList==null)
        {
            mutableProductList=new MutableLiveData<>();
            loadProductList();
        }
        return mutableProductList;

    }

    private void loadProductList() {
        List<Product> productList=new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",23.5,false,"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));

        mutableProductList.setValue(productList);

    }
}
