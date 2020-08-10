package com.rockbite.bootcamp.user;
import java.util.ArrayList;

public abstract class UserAbstract implements IUser{

    public static ArrayList<UserImpl> users = new ArrayList<>();

    @Override
    public ArrayList<UserImpl> getUsers () {
        return users;
    }

    @Override
    public  UserImpl getUser (int userID) {
        return users.get(userID);
    }
}
