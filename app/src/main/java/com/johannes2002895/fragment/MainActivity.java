package com.johannes2002895.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menampilkan fragment pertama dengan memanggil fragmentManager
        FragmentManager mfragmentManager =  getSupportFragmentManager();
        HomeFragment mHomeFragment = new HomeFragment();

        Fragment fragment = mfragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if(!(fragment instanceof HomeFragment)){
            Log.d("My Fragment","Fragment name:" + HomeFragment.class.getSimpleName());
            mfragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container,mHomeFragment,HomeFragment.class.getSimpleName())
                    .commit();

        }
    }
}