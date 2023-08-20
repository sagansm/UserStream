package me.ssagan.userstreamapp.model.comparator;

import me.ssagan.userstreamapp.model.entity.User;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return (int)(o2.getId() - o1.getId());
    }
}
