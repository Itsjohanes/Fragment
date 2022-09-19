package com.johannes2002895.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionalDialogFragment extends DialogFragment  {
    Button btnChose, btnClose;
    RadioGroup rgOption;
    RadioButton rbpg, rbjg, rbtt, rbags, rba;
    OnOptionDialogListener optionDialogListener;

    public OptionalDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_optional_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChose = view.findViewById(R.id.btn_chose);
        btnClose = view.findViewById(R.id.btn_close);
        rgOption = view.findViewById(R.id.rg_option);
        rbpg = view.findViewById(R.id.rg_pg);
        rbjg = view.findViewById(R.id.rg_jg);
        rbtt = view.findViewById(R.id.rg_tc);
        rbags = view.findViewById(R.id.rg_ogs);
        rba = view.findViewById(R.id.arteta);
        btnChose.setOnClickListener(view1 -> {
            int checkedRadioButtonId = rgOption.getCheckedRadioButtonId();
            if (checkedRadioButtonId != -1) {
                String coach = null;
                if (checkedRadioButtonId == R.id.rg_pg) {
                    coach = rbpg.getText().toString();
                } else if (checkedRadioButtonId == R.id.rg_jg) {
                    coach = rbjg.getText().toString();
                } else if (checkedRadioButtonId == R.id.rg_tc) {
                    coach = rbtt.getText().toString();
                } else if (checkedRadioButtonId == R.id.rg_ogs) {
                    coach = rbags.getText().toString();
                } else if (checkedRadioButtonId == R.id.arteta) {
                    coach = rba.getText().toString();
                }
                getDialog().dismiss();
            }
        });
        btnClose.setOnClickListener(view1 -> getDialog().cancel());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();
        if(fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    public interface OnOptionDialogListener{
        void OnOptionChosen(String text);

    }

}
