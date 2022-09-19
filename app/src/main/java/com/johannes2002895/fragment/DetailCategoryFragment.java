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
import android.widget.TextView;
import android.widget.Toast;


public class DetailCategoryFragment extends Fragment {

    TextView tvCategoryName , tvCategoryDescription;
    Button btnProfile,btnShowDialog;
    public static String EXTRA_NAME = "extra_name";
    public static  String EXTRA_DESCRIPTION = "extra_description";
    private String description;



    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);

        btnShowDialog.setOnClickListener(view1 -> {
            OptionalDialogFragment mOptionDialogFragment = new OptionalDialogFragment();
            FragmentManager mFragmentManager = getParentFragmentManager();
            mOptionDialogFragment.show(mFragmentManager, OptionalDialogFragment.class.getSimpleName());
        });
        if(savedInstanceState != null){
            String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }
        if(getArguments() != null){
            String categoryName = getArguments().getString(EXTRA_NAME);
            tvCategoryName.setText(categoryName);
            tvCategoryDescription.setText(getDescription());
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_DESCRIPTION, getDescription());

    }

    public final OptionalDialogFragment.OnOptionDialogListener optionDialogListener = new OptionalDialogFragment.OnOptionDialogListener() {
        @Override
        public void OnOptionChosen(String text) {
            Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
        }
    };
}