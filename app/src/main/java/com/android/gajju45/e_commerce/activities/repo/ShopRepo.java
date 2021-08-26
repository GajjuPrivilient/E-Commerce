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
        productList.add(new Product(UUID.randomUUID().toString(),"Banana",28.5,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Apple",29.5,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Pinaple",56.8,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Grapes ",87,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Guava",56,false,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Lychee",29,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Mango",170,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Papaya",51,false,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));
        productList.add(new Product(UUID.randomUUID().toString(),"Pears",106,true,"https://firebasestorage.googleapis.com/v0/b/imagessss-loading.appspot.com/o/temptest.png?alt=media&token=66bd6015-e108-47f9-9163-02d97751b233"));

        mutableProductList.setValue(productList);

    }
}
