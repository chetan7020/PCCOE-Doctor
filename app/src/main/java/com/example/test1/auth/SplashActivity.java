package com.example.test1.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.test1.BaseActivity;
import com.example.test1.MainActivity;
import com.example.test1.R;
import com.example.test1.databinding.ActivitySplashBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        checkLoginStatus();

        binding = ActivitySplashBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    private void init(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    private void checkLoginStatus() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (firebaseAuth.getCurrentUser() != null) {
                    Log.d("TAG", "run: " + firebaseAuth.getCurrentUser().getEmail());
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        }, 1000);
    }

}