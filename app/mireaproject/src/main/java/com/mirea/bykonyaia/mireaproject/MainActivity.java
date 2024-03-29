package com.mirea.bykonyaia.mireaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.mirea.bykonyaia.mireaproject.databinding.ActivityMainBinding;
import com.mirea.bykonyaia.mireaproject.databinding.ActivitySignInBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding = null;
    private FirebaseAuth mAuth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
    }
    private void CheckCurrentState() {
        if(mAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, SignInActivity.class));
        }
    }
    public void OnSignOutButtonClicked(View v) {
        mAuth.signOut();
        CheckCurrentState();
    }
}
