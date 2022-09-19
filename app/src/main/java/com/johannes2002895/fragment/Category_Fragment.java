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


public class Category_Fragment extends Fragment implements View.OnClickListener {



    public Category_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btndetailCategory = view.findViewById(R.id.btn_detail_category);
        btndetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_detail_category){
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();
            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME,"Life Style");
            String description = "Kategori ini berisikan produk life style";

            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);
            FragmentManager mfragmentManager = getParentFragmentManager();
            if(mfragmentManager != null){
                mfragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container,mDetailCategoryFragment,DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();

            }

        }
    }
}