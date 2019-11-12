package com.madantiwari.navigationdrawer.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.madantiwari.navigationdrawer.MainActivity;
import com.madantiwari.navigationdrawer.R;
import com.madantiwari.navigationdrawer.model.CheckLogin;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText etuser,etpassw;
    Button btnlogin;
    String Username, Password;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etuser=view.findViewById(R.id.etuser);
        etpassw=view.findViewById(R.id.etpass);
        btnlogin=view.findViewById(R.id.btnlogin);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username= etuser.getText().toString().trim();
                Password=etpassw.getText().toString().trim();

                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {

                    CheckLogin checkLogin=new CheckLogin();
                    checkLogin.setUsername(Username);
                    checkLogin.setPassword(Password);
                    Boolean status=checkLogin.chkLogin();



                    if(status){
                        Toast.makeText(getActivity(), "Login Successful, Welcome: " +Username, Toast.LENGTH_LONG).show();
                        etuser.setText("");
                        etpassw.setText("");

                        /// new activcity

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, Username);
                        startActivity(intent);


                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Password did not match", Toast.LENGTH_LONG).show();
                        etuser.setText("");
                        etpassw.setText("");
                    }
                }
                else
                {
                    if(TextUtils.isEmpty(Username)){
                        etuser.setError("Enter Username");}
                    if(TextUtils.isEmpty(Password)){
                        etpassw.setError("Enter Password");}
                    return;
                }

            }
        });

    return view;
    }

}
