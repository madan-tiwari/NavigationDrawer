package com.madantiwari.navigationdrawer.model;

import java.util.List;

public class CheckLogin {
    static List<User> UserList;
    boolean result=false;
    String Username, Password;


    public void setUserList(List<User> userList) {
        UserList=userList;

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<User> getUserList() {
        return UserList;
    }

    public boolean chkLogin() {





        if(getUserList()!= null) {

            for (int i = 0; i < getUserList().size(); i++) {
                final User userdetail = getUserList().get(i);
                if (Username.equals(userdetail.getUser()) && Password.equals(userdetail.getPass())) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        else
        {
            result=false;

        }


        return result;

    }



}
