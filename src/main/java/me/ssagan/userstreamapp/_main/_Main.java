package me.ssagan.userstreamapp._main;

import me.ssagan.userstreamapp.controller.UserController;
import me.ssagan.userstreamapp.model.entity.User;

import java.util.ArrayList;
import java.util.stream.Stream;

public class _Main {

    public static void main(String[] args) {
        UserController controller = new UserController();
        ArrayList<User> userList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            userList.add(User.startBuild().build());
        }
        //инициализация пользователей и запуск потока
        Stream userStream = controller.getUserStream(userList);

        //сортировка потока пользователей по убыванию идентификатора
        ArrayList<User> sortedUserList = controller.sortUserStream(userStream);

        //поиск пользователя с возрастом, совпадающим с его id
        controller.findUserWithEqualsIdAndAge(sortedUserList);
    }
}
