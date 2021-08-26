package com.android.gajju45.e_commerce.activities.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.gajju45.e_commerce.R;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        getSupportActionBar().setTitle("Mobile Verification");
    }

    public void otp_req(View view) {
        Intent intent = new Intent(getApplicationContext(), VerificationActivity.class);
        startActivity(intent);
    }
}