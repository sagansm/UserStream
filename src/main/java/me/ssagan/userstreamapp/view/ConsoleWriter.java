package me.ssagan.userstreamapp.view;

import me.ssagan.userstreamapp.model.entity.User;

import java.util.ArrayList;

public class ConsoleWriter {
    public void display(String str) {
        System.out.println(str);
    }

    public void display(String caption, ArrayList<User> userList) {
        System.out.println(caption);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public void display(String caption, User user) {
        System.out.println(caption);
        System.out.println(user);
    }
}
