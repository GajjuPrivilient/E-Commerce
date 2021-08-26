package com.android.gajju45.e_commerce.activities.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.gajju45.e_commerce.activities.models.CartItem;
import com.android.gajju45.e_commerce.activities.models.Product;
import com.android.gajju45.e_commerce.activities.repo.CardRepo;
import com.android.gajju45.e_commerce.activities.repo.ShopRepo;

import java.util.List;

public class ShopViewModel  extends ViewModel {
    ShopRepo shopRepo=new ShopRepo();
    CardRepo cardRepo=new CardRepo();


    MutableLiveData<Product> mutableLiveData=new MutableLiveData<>();
    public LiveData<List<Product>> getProducts()
    {
        return shopRepo.getProducts();
    }

    public void setProduct(Product product){
        mutableLiveData.setValue(product);
    }

    public LiveData<Product>getProduct(){
        return mutableLiveData;
    }

    public LiveData<List<CartItem>> getCart(){
        return cardRepo.getCart();

    }

    public boolean addItemToCart(Product product)
    {
        return cardRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem)
    {
        cardRepo.removeItemFromCart( cartItem);
    }
    public void changeQuantity(CartItem cartItem, int quantity){
        cardRepo.changeQuantity(cartItem,quantity);
    }

    public LiveData<Double> getTotalPrice(){
       return cardRepo.getTotalPrice();
    }

}
