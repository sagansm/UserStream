package me.ssagan.userstreamapp.controller;

import me.ssagan.userstreamapp.model.entity.User;
import me.ssagan.userstreamapp.model.service.UserService;
import me.ssagan.userstreamapp.view.ConsoleWriter;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserController {
    UserService service = new UserService();
    ConsoleWriter writer = new ConsoleWriter();

    public Supplier<Stream<User>> getUserStream(ArrayList<User> userList) {
        Supplier<Stream<User>> userStream = service.getUserStream(userList);
        return userStream;
    }

    public Stream<User> sortUserStream(Stream<User> userStream) {
        Stream sortedUserStream = service.sortUserStream(userStream);
        ArrayList<User> userList = (ArrayList<User>) sortedUserStream.collect(Collectors.toList());
        writer.display("Пользователи по убыванию идентификатора:", userList);
        return sortedUserStream;
    }

    public void findSomeUser(Stream<User> userStream) {
        Optional<User> optionalUser = service.findSomeUser(userStream);
        if (optionalUser.isPresent()) {
            writer.display("Пользователь с возрастом, совпадающим с его id:", optionalUser.get());
        } else {
            writer.display("Пользователь с возрастом, совпадающим с его id не найден.");
        }
    }
}
