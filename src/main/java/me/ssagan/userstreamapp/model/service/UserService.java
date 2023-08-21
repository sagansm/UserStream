package me.ssagan.userstreamapp.model.service;

import me.ssagan.userstreamapp.model.comparator.UserComparator;
import me.ssagan.userstreamapp.model.entity.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class UserService {

    //Запустить поток из листа, инициализируя пользователей используя функционал Builder и
// генератор случайных значений Math.rand().
// Строковые данные тоже генерировать случайным образом используя английский алфавит (и заглавные, и строчные буквы).
// id у всех пользователей должен быть уникальным и генерироваться с помощью Builder.
//Размер строк передается как случайное число от 5 до 20.
//Вместо терминального оператора сохранить stream в переменную.
    public Stream getUserStream(ArrayList<User> userList, int stringLength) {
        return userList.stream().map((user) -> User
                .startBuild()
                .generateUserId()
                .setLogin(generateRandomString(stringLength))
                .setPassword(generateRandomString(stringLength))
                .setAge((int) (Math.random() * 100))
                .build());
    }

    //"Запустив" Stream, отсортировать пользователей по убыванию и вывести результат собрав их в коллекцию.
    public Stream<User> sortUserStream(Stream<User> userStream) {
        return userStream.sorted(new UserComparator());
    }

    //Проверить, есть ли хотя бы один пользователь с возрастом, совпадающим с его id.
    public Optional<User> findUserWithEqualsIdAndAge(ArrayList<User> userList) {
        return userList.stream().filter(user -> user.getAge() == user.getId()).findAny();
    }

    private String generateRandomString(int length) {
        //int length = 5 + (int) (Math.random() * 20);
        char[] charArray = new char[length];
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (97 + (int) (Math.random() * 25));
        }
        return new String(charArray);
    }
}