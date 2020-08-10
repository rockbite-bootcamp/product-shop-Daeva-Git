package com.rockbite.bootcamp.user;
import com.rockbite.bootcamp.item.ItemType;
import com.rockbite.bootcamp.item.container.ItemContainerImpl;

import java.util.ArrayList;

public interface IUser {

    ArrayList<UserImpl> getUsers();

    UserImpl getUser(int userID);

    void addItems (ItemType item, int count);

    void removeItems (ItemType item, int count);

    String getName();

    void setName(String name);

    void setItems (ItemContainerImpl items);

    int getId();

    void setId(int id);
}
