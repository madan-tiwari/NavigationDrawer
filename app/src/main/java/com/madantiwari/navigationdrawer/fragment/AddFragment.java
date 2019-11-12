package com.madantiwari.navigationdrawer.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.madantiwari.navigationdrawer.R;

public class AddFragment extends Fragment implements View.OnClickListener{

    private EditText etFirstn,etSecondn;
    Button btnAdd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        etFirstn = view.findViewById(R.id.etFirst);
        etSecondn = view.findViewById(R.id.etSecond);
        btnAdd = view.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int first = Integer.parseInt(etFirstn.getText().toString());
        int second = Integer.parseInt(etSecondn.getText().toString());
        int result = first+second;

        Toast.makeText(getActivity(), "Sum is "+result, Toast.LENGTH_SHORT).show();
    }
}

