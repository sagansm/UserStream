package me.ssagan.userstreamapp.model.service;

import me.ssagan.userstreamapp.model.comparator.UserComparator;
import me.ssagan.userstreamapp.model.entity.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class UserService {

//Запустить поток из листа, инициализируя пользователей используя функционал Builder и
// генератор случайных значений Math.rand().
// Строковые данные тоже генерировать случайным образом используя английский алфавит (и заглавные, и строчные буквы).
// id у всех пользователей должен быть уникальным и генерироваться с помощью Builder.
//Размер строк передается как случайное число от 5 до 20.
//Вместо терминального оператора сохранить stream в переменную.
    public Supplier<Stream<User>> getUserStream(ArrayList<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            long randomId = 0;
            boolean isExistsId = true;
            while (isExistsId) {
                isExistsId = false;
                randomId = 1 + (long) (Math.random() * userList.size());
                for (int j = 0; j < i; j++) {
                    if (userList.get(j).getId() == randomId){
                        isExistsId = true;
                    }
                }
            }
            User user = User
                    .newBuilder()
                    .setId(randomId)
                    .setLogin(generateRandomString())
                    .setPassword(generateRandomString())
                    .setAge((int) (Math.random() * 100))
                    .build();
            userList.set(i, user);
        }
        Supplier<Stream<User>> streamSupplier = () -> userList.stream();
        return streamSupplier;
    }

    //"Запустив" Stream, отсортировать пользователей по убыванию и вывести результат собрав их в коллекцию.
    public Stream<User> sortUserStream(Stream<User> userStream) {
        Stream sortedStream = userStream.sorted(new UserComparator());
        return sortedStream;
    }

    //Проверить, есть ли хотя бы один пользователь с возрастом, совпадающим с его id.
    public Optional<User> findSomeUser(Stream<User> userStream) {
        Stream filteredStream = userStream.filter(user -> user.getAge() == user.getId());//TODO: написать условие в соотетствии с условием задачи
        Optional<User> optionalUser = filteredStream.findAny();
        return optionalUser;
    }

    private String generateRandomString() {
        int length = 5 + (int) (Math.random() * 20);
        char[] charArray = new char[length];
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (97 + (int) (Math.random() * 25));
        }
        return new String(charArray);
    }
}