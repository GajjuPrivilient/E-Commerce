package com.android.gajju45.e_commerce.activities.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.android.gajju45.e_commerce.R;
import com.android.gajju45.e_commerce.activities.models.CartItem;
import com.android.gajju45.e_commerce.activities.view.CartFragment;
import com.android.gajju45.e_commerce.activities.view.ShopFragment;
import com.android.gajju45.e_commerce.activities.viewModels.ShopViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    NavController navController;
    ShopViewModel shopViewModel;
    int cartQuantity=0;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new ShopFragment()).commit();


      /*  bottomNavigation=findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.home_menu: temp=new ShopFragment();
                        break;
                    case R.id.cart_menu: temp=new CartFragment();
                        break;
                    case R.id.profile_menu: temp=new ShopFragment();
                        break;
                }
                return true;
            }
        });

       */






        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                //Log.d(TAG, "OnChanged" + cartItems.size());

                int quantity=0;
                for (CartItem cartItem: cartItems)
                {
                    quantity+=cartItem.getQuantity();
                }
                cartQuantity=quantity;
                invalidateOptionsMenu();
            }
        });







    }



    //Back button
    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    //cart menu item
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem menuItem=menu.findItem(R.id.cartFragment);
        View actionView=menuItem.getActionView();

        TextView cartBadgeTV=actionView.findViewById(R.id.cart_badge_text_view);
        cartBadgeTV.setText(String.valueOf(cartQuantity));
        cartBadgeTV.setVisibility(cartQuantity == 0 ? View.GONE :View.VISIBLE );
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }


    //Bottom Navigation

}