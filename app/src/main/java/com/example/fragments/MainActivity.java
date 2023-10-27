package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Button btn_fragment1, btn_fragment2;
    private FirstFragment firstFragment = new FirstFragment();
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fragment1 = findViewById(R.id.btn_fragment1);
        btn_fragment2 = findViewById(R.id.btn_fragment2);


        setNewFragment(firstFragment);

        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(firstFragment);
            }
        });

        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                setNewFragment(secondFragment);
            }
        });

    }

    private void setNewFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }
}