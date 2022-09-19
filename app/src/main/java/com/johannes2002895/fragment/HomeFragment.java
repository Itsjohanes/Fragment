package com.johannes2002895.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


//dia mengextend fragment
public class HomeFragment extends Fragment implements View.OnClickListener {


    @Override
    //memanggil fragment home
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCategory = view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_category){
            Category_Fragment mCategoryFragment = new Category_Fragment();
            //getParent = mendapatkan parent dari parent dari main activity
            FragmentManager mfragmentManager = getParentFragmentManager();
            mfragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,mCategoryFragment, Category_Fragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }
}