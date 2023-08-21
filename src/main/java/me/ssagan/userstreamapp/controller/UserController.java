package me.ssagan.userstreamapp.controller;

import me.ssagan.userstreamapp.model.entity.User;
import me.ssagan.userstreamapp.model.service.UserService;
import me.ssagan.userstreamapp.view.ConsoleWriter;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserController {
    UserService service = new UserService();
    ConsoleWriter writer = new ConsoleWriter();

    public Stream getUserStream(ArrayList<User> userList) {
        writer.display("Введите длину логина и пароля от 5 до 20");
        Scanner scanner = new Scanner(System.in);
        int stringLength = scanner.nextInt();
        return service.getUserStream(userList, stringLength);
    }

    public ArrayList<User> sortUserStream(Stream<User> userStream) {
        Stream sortedUserStream = service.sortUserStream(userStream);
        ArrayList<User> userList = (ArrayList<User>) sortedUserStream.collect(Collectors.toList());
        writer.display("Пользователи по убыванию идентификатора:", userList);
        return userList;
    }

    public void findUserWithEqualsIdAndAge(ArrayList<User> userList) {
        Optional<User> optionalUser = service.findUserWithEqualsIdAndAge(userList);
        if (optionalUser.isPresent()) {
            writer.display("Пользователь с возрастом, совпадающим с его id:", optionalUser.get());
        } else {
            writer.display("Пользователь с возрастом, совпадающим с его id не найден.");
        }
    }
}
