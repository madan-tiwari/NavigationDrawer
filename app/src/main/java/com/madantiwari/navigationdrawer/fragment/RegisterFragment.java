package com.madantiwari.navigationdrawer.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.madantiwari.navigationdrawer.R;
import com.madantiwari.navigationdrawer.model.CheckLogin;
import com.madantiwari.navigationdrawer.model.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    EditText etrUser, etrPassword, etrCPassword;
    Button btnSignup;
    private String Username, Password, CPassword;

    static List<User> userList = new ArrayList<>();

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        etrUser=view.findViewById(R.id.etuserr);
        etrPassword=view.findViewById(R.id.etpassr);
        etrCPassword=view.findViewById(R.id.etCpassr);
        btnSignup=view.findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Username= etrUser.getText().toString().trim();
                Password=etrPassword.getText().toString().trim();
                CPassword=etrCPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {
                    if (!Password.equals(CPassword)) {
                        etrCPassword.setError("Password Do not match");
                        Toast.makeText(getActivity(), "" + Password + " : another : " + CPassword, Toast.LENGTH_LONG).show();
                        onStop();
                    }

                    else
                    {

                        User user= new User();
                        user.setUser(Username);
                        user.setPass(Password);
                        userList.add(user);



                        CheckLogin checkLogin=new CheckLogin();
                        checkLogin.setUserList(userList);

                        for (int i = 0; i < checkLogin.getUserList().size(); i++) {
                            final User userdetail = checkLogin.getUserList().get(i);
                            Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_SHORT).show();
                        }




                        Toast.makeText(getActivity(), "Signup Sucessful : " + Username, Toast.LENGTH_LONG).show();
                        etrUser.setText("");
                        etrPassword.setText("");
                        etrCPassword.setText("");




                    }
                }
                else
                {
                    if(TextUtils.isEmpty(Username)){
                        etrUser.setError("Enter Username");}
                    if(TextUtils.isEmpty(Password)){
                        etrPassword.setError("Enter Password");}
                    if(TextUtils.isEmpty(CPassword)){
                        etrCPassword.setError("Confirm Password");}
                    return;
                }

            }

        });



        return view;
    }

}
