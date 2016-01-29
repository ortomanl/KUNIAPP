package com.example.kitanoskan.json.Models;

/**
 * Created by kitanoskan on 4.12.2015.
 */
public class User {

    int id;
    String userName;
    String pass;
    String positon;

    User(){}

    public User(int i, String userName, String pass, String positon) {

        this.id = i;
        this.userName = userName;
        this.pass = pass;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass()
    {
        return this.pass;
    }
    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPossition()
    {
        return this.positon;
    }
    public void setPossition(String positon)
    {
        this.positon = positon;
    }


}
