package Ss02;

import java.util.*;
import java.util.function.*;

class UserBai04 {
    private String username;

    public UserBai04() {
        this.username = "default";
    }

    public UserBai04(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Bai04 {
    public static void main(String[] args) {

        List<UserBai04> users = Arrays.asList(
                new UserBai04("duong"),
                new UserBai04("nam"),
                new UserBai04("linh")
        );

        Function<UserBai04, String> getUsername = UserBai04::getUsername;

        Consumer<String> print = System.out::println;

        Supplier<UserBai04> createUser = UserBai04::new;

        for (UserBai04 u : users) {
            print.accept(getUsername.apply(u));
        }

        UserBai04 newUser = createUser.get();
        print.accept(newUser.getUsername());
    }
}