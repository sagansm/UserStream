package me.ssagan.userstreamapp._main;

import me.ssagan.userstreamapp.controller.UserController;
import me.ssagan.userstreamapp.model.entity.User;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class _Main {

    public static void main(String[] args) {
        UserController controller = new UserController();

        ArrayList<User> userList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            userList.add(User.newBuilder().build());
        }
        //1
        Supplier<Stream<User>> userStream = controller.getUserStream(userList);

        //2
        controller.sortUserStream(userStream.get());

        //3
        controller.findSomeUser(userStream.get());
    }
}
